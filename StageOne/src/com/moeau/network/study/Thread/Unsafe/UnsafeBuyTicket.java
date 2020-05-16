package com.moeau.network.study.Thread.Unsafe;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket trainTicket = new BuyTicket();

        new Thread(trainTicket,"Myself").start();
        new Thread(trainTicket,"Yourself").start();
        new Thread(trainTicket,"Ticket tout").start();
    }
}

class BuyTicket implements Runnable {

    //ticket
    private int ticketNums = 10;
    boolean flag = true;    //外部停止方式

    @Override
    public void run() {
        //买票
        while (flag){
            buy();

        }
    }

    //synchronized 同步方法 锁得是 this
    private synchronized void buy() {
        //判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName() + " has bought the ticket " + ticketNums--);
    }
}
