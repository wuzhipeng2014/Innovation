package com.qunar.innovation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhipengwu on 16-11-22.
 */
public class UserBehaviorFilterMapperTest {

    public static void main(String[] args) {
        String line ="时间字符串例子: 2016-11-18 21:45:36,53algkfjdslgj";

//        String regex = "(.*?)(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{0}-\\d{3})(.*?)";
        String regex="(.*?)(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{1,3})(.*?)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            String logtime = matcher.group(2);

            System.out.println("logtime:"+logtime);
        }else {

            System.out.println("匹配失败");
        }


    }

}