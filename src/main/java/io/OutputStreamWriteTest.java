package io;

import java.io.*;

public class OutputStreamWriteTest {
    public static void main(String[] args) throws IOException {
//        write_utf_8();
//        write_gbk();
        read_utf_8();

    }

    private static void read_utf_8() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("src/main/a.txt"),"gbk");
        // 定义变量 保存数据
        int len = 0;
        while ((len = isr.read()) != -1){
//            System.out.println(len);  // 输出的是 ASCII
            System.out.println((char) len);
        }
        isr.close();
    }

    private static void write_gbk() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src/main/a.txt"), "gbk");
        osw.write("你好");
        osw.flush();
        osw.close();
    }

    private static void write_utf_8() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src/main/a.txt"), "utf-8");
        osw.write("你好");
        osw.flush();
        osw.close();
    }
}
