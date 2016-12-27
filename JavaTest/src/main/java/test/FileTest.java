package test;


import com.google.common.collect.Lists;
import com.qunar.commonutil.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhipengwu on 16-8-11.
 */
public class FileTest {

    public static void main(String[] args) {
//        new FileUtil().readFile("test.txt");
//        FileUtil fileUtil=new FileUtil();
//        fileUtil.readFile("prefixList.properties");

        try {
            Iterable<String> fileIterator = FileUtil.getFileIterator("hotel_type_201607_statistic.txt");

            while (fileIterator.iterator().hasNext()){
                System.out.println(fileIterator.iterator().next());
            }

            System.out.println("file end !!!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testWriteFile(){
        List<String> lists= Lists.newArrayList();

        lists.add("123");
        lists.add("456");
        FileUtil.writeFile(lists,"test.txt");
    }

}
