import util.FileUtil;
import util.RegExpUtil;

import java.util.List;
import java.util.regex.Pattern;



/**
 * Created by zhipengwu on 16-8-23.
 */


//正则表达式练习
public class RegExpTest {


   public static       Pattern pattern = Pattern.compile("prefix#####\\{.*?\\}####");

    public static Pattern pattern2=Pattern.compile("HOMEPAGE_MODULE_SHOW_bn39sa_START####\\{.*?\\}####HOMEPAGE_MODULE_SHOW_bn39sa_END");



    public static String resource="key=1471766122440&cid=C2022&uid=862565032950320&gid=018304CE-0619-4BBC-E825-35FAD9B062E3&pid=10010&vid=60001141&msg=&aid=&ma=20:5d:47:1b:d8:28&model=vivo X7&osVersion=5.1.1_22&sid=0EAA02B0-96C5-1801-A310-674D25517544&t=p_behaviors&ip=60.4.106.37&adid=a74b12da56ef976a&iid=&username=&nt=\"MERCURY_22D6\"&mno=46000&port=55694&ref=&brush={\"lt\":\"0\"}&latLog=39.143481&lgtLog=116.208687&catom=com.mqunar.atom.attemper_33&usid=&pitcherTid=l-pitcher2.wap.cn5_a7d24145e580ac8ec9cfffac30fbfd59&tsv=21&qrid=1471766116208&cat=&cs=APP&behaviors=|146505309*HywebviewLoadTime*https%3A%2F%2Factivity.qunar.com%2Fspecial%2Fdetail.htm%3FspecialNameEn%3Dyy_qjlvywd1608%26from%3DhotDest%26hybridid%3Dmob_activity%26commonParams%3D%257B%2522currLatitude%2522%253A%252239.143477%2522%252C%2522uid%2522%253A%2522862565032950320%2522%252C%2522currLongitude%2522%253A%2522116.208681%2522%252C%2522gid%2522%253A%2522018304CE-0619-4BBC-E825-35FAD9B062E3%2522%252C%2522pid%2522%253A%252210010%2522%252C%2522un%2522%253A%2522%2522%252C%2522vid%2522%253A%252260001141%2522%252C%2522city%2522%253A%2522%25E4%25BF%259D%25E5%25AE%259A%2522%257D%26cat%3D77*1726|146505311*:set*HOMEPAGE_MODULE_SHOW_bn39sa_START####{\"module\":\"operated_6_1\",\"page\":\"home\",\"requestId\":\"018304CE-0619-4BBC-E825-35FAD9B062E3_1471766100965\",\"showTime\":\"20160821155511231\"}####HOMEPAGE_MODULE_SHOW_bn39sa_END|146505312*:set*HOMEPAGE_MODULE_SHOW_bn39sa_START####{\"module\":\"RECENT_CELL\",\"page\":\"home\",\"requestId\":\"018304CE-0619-4BBC-E825-35FAD9B062E3_1471766100965\",\"showTime\":\"20160821155512308\"}####HOMEPAGE_MODULE_SHOW_bn39sa_END|146505312*:set*HOMEPAGE_MODULE_SHOW_bn39sa_START####{\"module\":\"LOCAL_TICKET_CELL\",\"page\":\"home\",\"requestId\":\"018304CE-0619-4BBC-E825-35FAD9B062E3_1471766100965\",\"showTime\":\"20160821155512623\"}####HOMEPAGE_MODULE_SHOW_bn39sa_END|146505316*:set*RECOMMEND_CLICK_YmVmY_START####{\"businessType\":\"TICKET\",\"cardType\":\"RECENT_CELL\",\"clickTime\":\"20160821155516215\",\"clickType\":\"detail\",\"detailLocation\":\"1\",\"logKey\":\"RECENT_CELL#RECENT_FOCUS$最近关注#TICKET$34096\",\"pattern\":\"RECENT_FOCUS\",\"requestId\":\"018304CE-0619-4BBC-E825-35FAD9B062E3_1471766100965\",\"title\":\"大秦温泉\"}####RECOMMEND_CLICK_YmVmY_END&bstatus=0&bstatsDes=成功&hotDogRunTime=1&hotDogDataSize=1167&traceId=1471766122upjLCGP6Eu3_p_behaviors\n" +
            "key=1471755086622&cid=C2022&uid=867666029830312&gid=018431C9-71DB-D7F5-4EC2-CB301D3896F9&pid=10010&vid=60001141&msg=&aid=&ma=ec:df:3a:93:1d:a4&model=vivo Y33L&osVersion=5.0_21&sid=E65E7223-24C2-CD87-6C97-DA27BA90261D&t=f_c2b_flightlist&ip=110.156.191.108&adid=c8d7ac77d730a802&iid=&username=&nt=\"LKJ\"&mno=46007&port=35274&ref=&brush={\"lt\":\"0\"}&latLog=46.751379&lgtLog=82.989994&catom=com.mqunar.atom.flight_88&atomId=88&cas=com.mqunar.atom.flight_88&versionCode=&qcookie=&vcookie=&tcookie=&usid=&cat=&searchCode=0&fromCity=乌鲁木齐&toCity=天津&depDate=2016-09-10&timeRange=&isFullTimeRange=&fromAirport=&toAirPort=&transferHours=&stop=&bstatus=-1&bstatsDes=木有符合条件的报价~&hotDogRunTime=11&hotDogDataSize=1065&traceId=1471755087Tgi5olwVKB9_f_c2b_flightlist";



    public static void main(String[] args) {
        String s="test124jgldkfglprefix#####{dididadaogjlkdfjgh}#####dflajgdflkbhjwefprefix#####{fdjklgbfj}####sdfhfjdgk;lsadf";
        List<String> prefixs = FileUtil.readFileToList("prefixList.properties");
        String prefix=prefixs.get(0);
        Pattern compile = Pattern.compile(prefix);

        int openBraceIndex=prefix.indexOf("{");
        int closeBraceIndex=prefix.indexOf("}");
        String first=prefix.substring(0,openBraceIndex-1);
        String end=prefix.substring(closeBraceIndex+1);
        String second="\"insertString\":\"value\",";
        System.out.println(first);

//        Matcher matcher = compile.matcher(resource);
        RegExpUtil.MatchReg(compile,resource);

//        while (matcher.find()){
//            String matcherResult= matcher.group();
//           matcherResult= matcherResult.replace(end,"");
//            String result= matcherResult.replace(first+"{",first+"{"+second);
//            System.out.println(result);
//
//        }

//        String s2= String.format("\"gid\":\"%s\",", "123");
//        System.out.println(s2);
//        Pattern pattern3 = Pattern.compile("prefix#####\\{.*?\\}####");
//        List<String> strings1 = FileUtil.readFileToList("prefixList.properties");
//        String p1= strings1.get(0);
//        int openBraceIndex=p1.indexOf("{");
//        System.out.println("$$$$$$44");
//        System.out.println(p1.substring(0,openBraceIndex-1));
//        Pattern compile = Pattern.compile(p1);
//        Matcher matcher1 = compile.matcher(s);
//        while (matcher1.find()){
//            System.out.println(matcher1.group());
//        }
//
//
//        String testString="abcdatfg{dsgfdlkg}gadflgj{gadflgkj}";
//        String replace = testString.replace("{ds", "***");
//        System.out.println(testString);
//        System.out.println(replace);
//        List<String> strings = FileUtil.readFileToList("prefixList.properties");


    }
}
