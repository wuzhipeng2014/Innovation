package com.qunar.commonutil;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by zhipengwu on 16-8-12.
 */
public class FileUtil {

    /**
     * 从resources文件夹读取文件
     * @param fileName
     */
    public static void readFile(String fileName){
        String filePath=FileUtil.class.getClassLoader().getResource(fileName).getPath();
        System.out.println(filePath);
        String line;
        InputStream resourceAsStream = FileUtil.class.getClassLoader().getResourceAsStream(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取指定文件内容到list
     * @param fileName 待读取文件路径
     * @return list
     */
    public static List<String> readFileToList(String fileName){
        String filePath=FileUtil.class.getClassLoader().getResource(fileName).getPath();
        List<String> list= Lists.newArrayList();
        System.out.println(filePath);
        String line;
        InputStream resourceAsStream = FileUtil.class.getClassLoader().getResourceAsStream(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            while ((line=bufferedReader.readLine())!=null){
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void writeFile(List<String> list,String fileName){
        Preconditions.checkNotNull(list,"输入列表为空");
        File file =new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
                FileWriter fileWritter = new FileWriter(file.getName(),true);
                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                for (String s:list){
                bufferWritter.write(s);
                    bufferWritter.newLine();
                }
                bufferWritter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
