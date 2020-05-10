package top.yourwit.network.study.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpServerDemo01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //1.建立服务的端口
            serverSocket = new ServerSocket(9999);

            while (true){
                //2.等待客户端的连接
                socket = serverSocket.accept();
                //3.读取客户端的消息
                is = socket.getInputStream();
                //4.管道流 输出
                byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[2014];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                System.out.println(byteArrayOutputStream.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
