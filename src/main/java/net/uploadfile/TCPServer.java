package net.uploadfile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);
        // 让服务器一直处于监听状态
        while (true){
            Socket socket = server.accept();

            // 开启多线程完成文件的上传
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        InputStream is = socket.getInputStream();

                        File file = new File("J:\\upload");
                        if (!file.exists()){
                            file.mkdirs();
                        }

                        String fileName = "\\iaminlearn" + new Random().nextInt(9999) + ".png";

                        FileOutputStream fos = new FileOutputStream(file + fileName);
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = is.read(bytes)) != -1){
                            fos.write(bytes,0,len);
                        }

                        OutputStream os = socket.getOutputStream();
                        os.write("上传成功".getBytes());

                        fos.close();
                        socket.close();
                    }catch (IOException e){
                        System.out.println(e);
                    }finally {
                        System.out.println("==============");
                    }
                }
            }).start();

        }

        //server.close();


    }
}
