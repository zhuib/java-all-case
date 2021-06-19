package io.reader;

import java.io.FileReader;
import java.io.IOException;

public class FISRead {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileReader fr = new FileReader("src/main/read.txt");
        // 定义变量，保存有效字符个数
        int len ;
        // 定义字符数组，作为装字符数据的容器
        char[] cbuf = new char[2];
        // 循环读取
        while ((len = fr.read(cbuf))!=-1) {
            System.out.println(len);
            System.out.println(new String(cbuf,0,len));
        }
        // 关闭资源
        fr.close();
    }
}