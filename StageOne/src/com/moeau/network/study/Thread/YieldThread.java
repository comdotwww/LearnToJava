package com.moeau.network.study.Thread;

//线程礼让
//礼让不一定成功，靠CPU调度
public class YieldThread {
    public static void main(String[] args) {

        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread starts.");
        Thread.yield(); //线程礼让
        System.out.println(Thread.currentThread().getName() + " Thread ends.");
    }
}