package top.yourwit.network.study.lesson03;


//  创建线程方式2：实现runnable接口，重写run()方法，
//  执行线程需求丢入runnable接口的实现类，调用start()方法

public class TestThread3 implements Runnable{
    @Override
    public void run() {
        //run()方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在测试代码————" + i);
        }
    }

    public static void main(String[] args) {
        //main()线程，主线程

        //创建一个线程对象，通过线程对象开启目标线程，代理
        TestThread3 testThread3 = new TestThread3();
        //调用start()方法开启线程
        new Thread(testThread3).start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程————" + i);
        }
    }
}
