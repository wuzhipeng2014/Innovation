import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhipengwu on 16-8-12.
 */
public class LoggerTest {

   private static Logger logger= LoggerFactory.getLogger(LoggerTest.class);


    public static void main(String[] args) {

        System.out.println("测试slf4j+logback******************8");

        logger.info("test logger.info");
        logger.error("测试错误信息");
        logger.debug("测试debug信息");

    }

}
