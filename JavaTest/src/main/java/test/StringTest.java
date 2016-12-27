package test;

import com.qunar.commonutil.FileUtil;
import com.qunar.commonutil.RegExpUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Created by zhipengwu on 16-8-9.
 */
public class StringTest {

public static String target="ZHOU_BIAN_YOU_mht6j_START####\\{.*?\\}####ZHOU_BIAN_YOU_mht6j_END";
public static Pattern pattern=Pattern.compile(target);


    public static void readFile(String fileName){
        String line="";
        String filePath=FileUtil.class.getClassLoader().getResource(fileName).getPath();
        InputStream resourceAsStream = FileUtil.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        try {
            while ((line=bufferedReader.readLine())!=null){
                splitString(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        String s="大\u0003小\u0003多\u0003少";
//        String s1="大小";
//        String[] strings = s.split("\u0003");
//        for (int i = 0; i < strings.length; i++) {
//            System.out.println(strings[i]);
//        }
//        StringBuilder sb=new StringBuilder();
//        for (int i=0;i<strings.length;i++){
//            sb.append(strings[i]);
//            if (i<strings.length-1) {
//                sb.append("\\u0003");
//            }
//        }
//
//
//        System.out.println(sb.toString());

//        start = TimeUtils.getDaysBefore(Integer.parseInt(getStartDate()));

//        List<String> stringList = FileUtil.readFileToList("partca");
//        List<String> stringList = FileUtil.readFileToList("etl_client_adr");
//        for (String item:stringList){
//            splitString(item);
//        }
//        readFile("etl_client_adr");
//        readFile("partca");
//        System.out.println("################");
//        System.out.println("count= "+count);
//        System.out.println("counterror= "+counterror  );

        String line ="{\"gid\":\"2282DF05-7489-1BB4-415D-D6A68387B964\",\"vid\":\"60001146\",\"cid\":\"C1012\",\"uid\":\"869637025347435\",\"cuid\":\"869637025347435\",\"pid\":\"10010\",\"username\":\"\",\"dt\":\"2016-12-14\",\"clickPos\":\"15\",\"clickTime\":\"20160706094158980\",\"clickType\":\"item\",\"itemName\":\"[门票]扬州瘦西湖门票{淡季}";
      Pattern compile = Pattern.compile("\"gid\":\".*?\"");
        List<String> strings = RegExpUtil.MatchReg(compile, line);
        System.out.println(strings.get(0));
        int colonIndex = strings.get(0).indexOf(":");
        if (colonIndex>0){
            System.out.println(strings.get(0).substring(colonIndex+2,strings.get(0).length()-1));
        }


    }

public static int count=0;
    public static int counterror=0;
    public static void matchString(String line,Pattern pattern){
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()){
            System.out.println(matcher.group());
            count++;
        }
    }


    public static void splitString(String line){
//        String line ="3798\t2016-08-21\t06:00:00\tserviceAccess\tC3952\t862555022902340\t862555022902340\t60001141\t10010\t889B40B8-6D89-9A37-CDD9-BCBEEADCD615\t0\t0\t1471730400081\t\t4.2.2_19\tHUAWEI G750-T00\tkey=1471730400081&cid=C3952&uid=862555022902340&gid=889B40B8-6D89-9A37-CDD9-BCBEEADCD615&pid=10010&vid=60001141&msg=&aid=&ma=84:1e:26:72:20:47&model=HUAWEI G750-T00&osVersion=4.2.2_19&sid=6D2454BB-FFD7-EA7D-524E-6064D1603AA2&t=recommendcard_fuc&ip=113.59.226.113&adid=7e3b869828df1ae2&iid=&username=&nt=wonet&mno=46001&port=51037&ref=&brush={\"lt\":\"0\"}&latLog=32.838272&lgtLog=111.76898&catom=com.mqunar.atom.alexhome_76&usid=&v=adr&pitcherTid=l-pitcher2.wap.cn5_a8ac69d76dc72ef9d68e9b07a0516d02&cat=&cs=&bizParam={\"boutiqueF\":0,\"historyCity\":\"\",\"latitude\":\"32.838272\",\"longitude\":\"111.76898\",\"requestId\":\"889B40B8-6D89-9A37-CDD9-BCBEEADCD615_1471730395801\",\"service\":\"tag_list\"}&bstatus=0&bstatsDes=成功请求数据&hotDogRunTime=2&hotDogDataSize=18034&traceId=l-pitcher2.wap.cn5_a8ac69d76dc72ef9d68e9b07a0516d02\t\t113.59.226.113\t46001\t\tl-pitcher2.wap.cn5";
        String[] split = line.split("\t");
        if (split.length<16){
            counterror++;
        }
        if (split.length>16) {
            String param = split[16];
            matchString(param,pattern);
        }
    }
}
