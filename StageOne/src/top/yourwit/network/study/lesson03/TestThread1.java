package top.yourwit.network.study.lesson03;

//  三种创建方式
//  Thread class      继承 Thread 类（重点）
//  Runnable接口      实现 Runnable 接口（重点）
//  Callable接口      实现 Callable 接口（了解）

//  创建线程方式一：继承 Thread 类，重写 run() 方法，调用 start() 开启线程

//  总结：
//      注意：线程开启不一定立即执行，由CPU调度执行
public class TestThread1 extends Thread {
    @Override
    public void run() {
        //run()方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在测试代码————" + i);
        }
    }

    public static void main(String[] args) {
        //main()线程，主线程

        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();
        //调用start()方法开启线程
        testThread1.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程————" + i);
        }
    }
}
