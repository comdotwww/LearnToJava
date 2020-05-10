package top.yourwit.network.study.lesson03;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习 Thread ,实现多线程同步下载图片
public class TestThread2 extends Thread{
    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //  下载图片的线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://ae01.alicdn.com/kf/H6e76346b577e42d6bfb25a1d7dfb1be90.jpg","博客图1.jpg");
        TestThread2 t2 = new TestThread2("https://ae01.alicdn.com/kf/H6e76346b577e42d6bfb25a1d7dfb1be90.jpg","博客图2.jpg");
        TestThread2 t3 = new TestThread2("https://ae01.alicdn.com/kf/H6e76346b577e42d6bfb25a1d7dfb1be90.jpg","博客图3.jpg");

        t1.start();
        t2.start();
        t3.start();

//        下载文件名为：博客图3.jpg
//        下载文件名为：博客图1.jpg
//        下载文件名为：博客图2.jpg
    }
}


//下载器
class WebDownloader{
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("I/O异常，downloader方法出现问题！");
        }
    }
}