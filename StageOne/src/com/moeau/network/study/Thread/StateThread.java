package com.moeau.network.study.Thread;

/*
 *线程状态
 *   线程可以处于以下状态之一：
 *       NEW：尚未启动的线程处于此状态。
 *       RUNNABLE：在Java虚拟机中执行的线程处于此状态。
 *       BLOCKED：被阻塞等待监视器锁定的线程处于此状态。
 *       WAITING：正在等待另一个线程执行特定动作的线程处于此状态。
 *       TIMED_WAITING：正在等待另一个线程执行动作达到指定等待时间的线程处于此状态。
 *       TERMINATED：已退出的线程处于此状态。
 * 一个线程可以在给定时间点处于一个状态。 这些状态是不反映任何操作系统线程状态的虚拟机状态。
 * JDK >= 1.5
 */


public class StateThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("//////////");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);  //NEW

        //观察启动后的状态
        thread.start(); //启动线程
        state = thread.getState();
        System.out.println(state);  //RUN
        while (state != Thread.State.TERMINATED) {
            //只要线程不终止，就一直输出状态
            try {
                Thread.sleep(100);  //TIMED_WAITING
                state = thread.getState();
                System.out.println(state);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread.start(); //TERMINATED 后不能start()

    }
}
