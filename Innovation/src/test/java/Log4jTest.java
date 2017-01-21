import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhipengwu on 17-1-19.
 */
public class Log4jTest {

    private static Logger logger = LoggerFactory.getLogger(Log4jTest.class);// 日志

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        try {
            int c = a / b;
            System.out.println(c);

        } catch (Exception e) {
            System.out.println("输出日志信息");

            logger.error("a/b 计算错误, a={}, b={}, {}", a, b, e);
            logger.warn("a/b 计算错误, a={}, b={}, {}", a, b, e);
            logger.error("a/b 计算错误, a={}, b={}, {}", a, b, e);

        }

        int d=6+6;
        System.out.println(d);
        System.out.println("执行完毕");

    }
}
