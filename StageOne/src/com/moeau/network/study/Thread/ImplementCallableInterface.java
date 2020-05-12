package com.moeau.network.study.Thread;


/*
 *   实现 Callable 接口（了解）
 *
 *   1. 实现 Callable 接口，需要返回值类型
 *   2. 重写 call() 方法，需要抛出异常
 *   3. 创建目标对象
 *   4. 创建执行服务：ExecutorService ser = Executors.newFixedThreadPool(1);
 *   5. 提交执行：Future<Boolean> result1 = ser.submit(t1);
 *   6. 获取结果：boolean r1 = result.get();
 *   7. 关闭服务：ser.shutdownNow();
 *
 *  优点：1、可自定义返回值（如Boolean）；
 *       2、可抛出异常。
 * */

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class ImplementCallableInterface implements Callable<Boolean> {
    private String url;
    private String name;

    public ImplementCallableInterface(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //  下载图片的线程的执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ImplementCallableInterface t1 = new ImplementCallableInterface("https://ae01.alicdn.com/kf/H6e76346b577e42d6bfb25a1d7dfb1be90.jpg", "ICI1.jpg");
        ImplementCallableInterface t2 = new ImplementCallableInterface("https://ae01.alicdn.com/kf/H05a17d42b9a342f28d6a30aaf08f0bf2p.png", "ICI2.png");
        ImplementCallableInterface t3 = new ImplementCallableInterface("https://ae01.alicdn.com/kf/H2b42d2fc751b446f92475a61287a0a7eo.png", "ICI3.png");

        //4. 创建执行服务：
        ExecutorService ser = Executors.newFixedThreadPool(3);  //丢3个

        //5. 提交执行：
        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);

        //6. 获取结果：
        boolean rs1 = result1.get();
        boolean rs3 = result3.get();
        boolean rs2 = result2.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        /*下载文件名为：ICI1.jpg
        *下载文件名为：ICI2.png
        *下载文件名为：ICI3.png
        * */
//        try {
//            boolean rs1 = result1.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        try {
//            boolean rs2 = result2.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        try {
//            boolean rs3 = result3.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        //7. 关闭服务：
        ser.shutdownNow();

    }


    class WebDownloader {
        public void downloader(String url, String name) {
            try {
                FileUtils.copyURLToFile(new URL(url), new File(name));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("I/O异常，downloader方法出现问题！");
            }
        }
    }
}