package top.yourwit.network.study.Thread;


//  创建线程方式2：实现runnable接口，重写run()方法，
/*
*   1. 定义 MyRunnable 类实现 Runnable 接口
*   2. 实现 run() 方法，编写线程执行体
*   3. 创建线程对象，调用 start() 方法启动线程
* */

public class ImplementRunnableInterface implements Runnable{
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
        ImplementRunnableInterface implementRunnableInterface = new ImplementRunnableInterface();
        //调用start()方法开启线程
        new Thread(implementRunnableInterface).start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程————" + i);
        }
    }
}
