package test;

import com.google.common.collect.Lists;
import com.qunar.commonutil.TimeUtil;
import org.apache.commons.lang.StringUtils;

import java.util.List;



/**
 * Created by zhipengwu on 16-8-15.
 */
public class ParamsTest {


    public static void main(String... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        printParams("line1","line2");
        String inputDate="20160826";
        String dateString = TimeUtil.formateTime(inputDate);

        String inputBaseDir="marmot_warehouse/logclean/etl_client";
        String inputPath_adr=String.format("%s/%s/%s",inputBaseDir,"platform=adr","dt="+dateString);
        String inputPath_ios=String.format("%s/%s/%s",inputBaseDir,"platform=ios","dt="+dateString);
        String inputPath_qt=String.format("%s/%s/%s",inputBaseDir,"platform=qt","dt="+dateString);
        String inputPath_win8=String.format("%s/%s/%s",inputBaseDir,"platform=win8","dt="+dateString);
        String inputPath_wp7=String.format("%s/%s/%s",inputBaseDir,"platform=wp7","dt="+dateString);
        List<String> inputList= Lists.newArrayList();
        inputList.add(inputPath_adr);
        inputList.add(inputPath_ios);
        inputList.add(inputPath_qt);
        inputList.add(inputPath_win8);
        inputList.add(inputPath_wp7);


//        String inputPaths = "marmot_warehouse/logclean/etl_client/platform=adr/dt=2016-08-21/000276_0.gz";
        String inputPaths = StringUtils.join(inputList, ",");
        System.out.println(inputPaths);



    }



    public static void printParams(String... strings){
        for (String s:strings){
            System.out.println(s);
        }
    }
}
