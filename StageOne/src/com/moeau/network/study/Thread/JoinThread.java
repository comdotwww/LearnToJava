package com.moeau.network.study.Thread;

public class JoinThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("VIP Thread is here. " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();
        Thread thread = new Thread(joinThread);
        thread.start();

        //主线程
        //  i<200 时，main 和 VIP 是受CPU调度的，故可能有穿插输出
        for (int i = 0; i < 5000; i++) {
            if (i == 200) {
                    thread.join();  //插队，让VIP执行完成
            }
            System.out.println("main Thread " + i);
        }
    }
}
