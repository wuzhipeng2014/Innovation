package test;


import com.qunar.commonutil.FileUtil;

import java.io.IOException;

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

}
