package test;


import com.qunar.commonutil.FileUtil;

/**
 * Created by zhipengwu on 16-8-11.
 */
public class FileTest {

    public static void main(String[] args) {
        new FileUtil().readFile("test.txt");
        FileUtil fileUtil=new FileUtil();
        fileUtil.readFile("prefixList.properties");
    }

}
