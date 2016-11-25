package test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.io.compress.Lz4Codec;
import org.apache.hadoop.mapred.JobPriority;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * Created by zhipengwu on 16-8-15.
 */
public class StatisticTest extends Configured implements Tool {

    public static enum FileRecorder{
        PvRecorder,
        UvRecorder
    }

    public static void main(String[] args) {
        int status = 0;
        try {
            status = ToolRunner.run(new StatisticTest(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(status);
    }

    public static class StatisticMapper extends Mapper<Object, Text, Text, Text> {
        public String inputPath = "";

        @Override
        protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            Pattern pattern = Pattern
                    .compile("(?<=HOMEPAGE_MODULE_SHOW_bn39sa_START####).*?(?=####HOMEPAGE_MODULE_SHOW_bn39sa_END)");

            String line = value.toString();
            if (null != line) {

                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String matchResult = matcher.group();
                    if (matchResult.contains("\"module\":\"smallEntrances\"")) {
                        String[] splits = line.split("\t");
                        if (splits.length>9) {
                            String gid = splits[9];
                            if (null != gid && !gid.isEmpty()) {
                                context.write(new Text(gid), new Text("1"));
                            }
                        }
                    }
                }
            }
        }

    }

    public static class StatisticReducer extends Reducer<Text, Text, Text, Text> {
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            context.getCounter(FileRecorder.UvRecorder).increment(1);
            int count=0;
            for (Text value : values) {
                count++;
            }
            context.getCounter(FileRecorder.PvRecorder).increment(count);
            context.write(key, new Text(String.valueOf(count)));
        }
    }

    @Override
    public int run(String[] args) throws Exception {
        String inputPath=args[0];
        String outputPath=args[1];
        int numReduceTasks = Integer.parseInt(args[2]);

        Configuration conf = this.getConf();
        conf.set("mapred.job.queue.name", "wirelessdev");
        conf.set("mapreduce.map.memory.mb", "4096");
        conf.set("mapred.child.map.java.opts", "-Xmx4096m");
        conf.set("mapreduce.map.java.opts", "-Xmx4096m");
        conf.set("mapreduce.reduce.memory.mb", "8192");
        conf.set("mapred.child.reduce.java.opts", "-Xmx8192m");
        conf.set("mapreduce.reduce.java.opts", "-Xmx8192m");
        conf.set("mapred.job.priority", JobPriority.VERY_HIGH.name());
        conf.setBoolean("mapred.compress.map.output", true);
        conf.setClass("mapred.map.output.compression.codec", Lz4Codec.class, CompressionCodec.class);
        conf.setBoolean("mapred.output.compress", true);
        conf.setClass("mapred.output.compression.codec", GzipCodec.class, CompressionCodec.class);


        Job job = Job.getInstance(conf);
        job.setJobName("StatisticTest.zhipeng.wu");
        job.setJarByClass(StatisticTest.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.setInputPaths(job, inputPath);
        FileOutputFormat.setOutputPath(job, new Path(outputPath));
        job.setNumReduceTasks(numReduceTasks);

        job.setMapperClass(StatisticMapper.class);
        job.setReducerClass(StatisticReducer.class);

        boolean success = job.waitForCompletion(true);
        System.out.println(String.format("pv: %s , uv: %s",job.getCounters().findCounter(FileRecorder.PvRecorder).getValue(),job.getCounters().findCounter(FileRecorder.UvRecorder).getValue()));
        return success ? 0 : 1;
    }
}
