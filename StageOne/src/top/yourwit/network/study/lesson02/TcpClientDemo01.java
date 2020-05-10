package top.yourwit.network.study.lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;

        try {
            //1.要知道服务器地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //2.创建一个Socket连接
            socket = new Socket(serverIP, port);
            //3.发送消息I/O流
            os = socket.getOutputStream();
            os.write("你好，欢迎你！".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
