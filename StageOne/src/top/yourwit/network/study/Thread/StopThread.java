package top.yourwit.network.study.Thread;

/*
 *        测试停止线程
 *
 * 1、建议线程正常停止————>利用次数，不建议死循环
 * 2、建议使用标志位————>设置一个标志位
 * 3、不要使用stop()或destroy()等过时或者JDK不建议使用的方法
 * */

public class StopThread implements Runnable {
    //1. 设置标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run Thread" + i++);
        }

    }

    //2. 设置一个公开的方法停止线程，转换标志位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        new Thread(stopThread).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i == 900) {
                //调用stop()方法切换标志位，让线程停止
                stopThread.stop();
                System.out.println("Thread is ready to stop.");
            }
        }
    }
}
