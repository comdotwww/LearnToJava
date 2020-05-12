package com.moeau.network.study.Thread;

//每一个对象都有一把锁，sleep() 不会释放锁
//模拟网络延时：放大问题的发生性
public class SleepThreadTest_1 implements Runnable{

    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (ticketNums>0){

            //模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"————>拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        SleepThreadTest_1 ticket = new SleepThreadTest_1();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛党").start();
    }
}
