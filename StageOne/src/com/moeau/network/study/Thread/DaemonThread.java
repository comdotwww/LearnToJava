package com.moeau.network.study.Thread;

/*
* 线程分为用户线程和守护线程
* 虚拟机必须确保用户线程执行完毕
* 虚拟机不用等待守护线程执行完毕
* */

public class DaemonThread {
    public static void main(String[] args) {
        God god = new God();
        Yours yours = new Yours();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认的false表示是用户线程，正常线程都是用户线程
        thread.start();

        new Thread(yours).start();;   //用户线程启动
    }
}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("God bless you!");
        }
    }
}

//You
class Yours implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("You are alive happily!");
        }
        System.out.println("=========Goodbye, world.");
    }
}