package com.moeau.network.study.Thread;

/*
* 线程优先级
*
* 优先级低只是意味着获得调度的概率低，并不是优先级低就不会被调用了，
* 这都是看CPU的调度
* */
public class PriorityThread{
    public static void main(String[] args) {
        //Main的默认优先级
        System.out.println(Thread.currentThread().getName()+"---->"+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread thread1 = new Thread(myPriority,"thread1");
        Thread thread2 = new Thread(myPriority,"thread2");
        Thread thread3 = new Thread(myPriority,"thread3");
        Thread thread4 = new Thread(myPriority,"thread4");
        Thread thread5 = new Thread(myPriority,"thread5");
        Thread thread6 = new Thread(myPriority,"thread6");

        //先设置优先级，再启动
        thread1.start();

        thread2.setPriority(1);
        thread2.start();

        thread3.setPriority(4);
        thread3.start();

        thread4.setPriority(Thread.MAX_PRIORITY);   //Thread.MAX_PRIORITY == 10
        thread4.start();

        thread5.setPriority(-1);
        thread5.start();

        thread6.setPriority(11);
        thread6.start();
    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---->"+Thread.currentThread().getPriority());
    }
}