package top.yourwit.network.study.Thread;

//  模拟龟兔赛跑
//  Simulate Tortoise and Hare in Multithreading

public class ImplementRunnableTest_2 implements Runnable {

    //胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息
            if (Thread.currentThread().getName().equals("rabbit") && i % 10 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //判断比赛是否结束
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    //判断是否完成比赛
    private boolean gameOver(int steps) {
        //判断是否有胜利者
        if (winner != null) {
            //已经存在胜利者
            return true;
        } else {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("Winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ImplementRunnableTest_2 implementRunnableTest2 = new ImplementRunnableTest_2();
        new Thread(implementRunnableTest2, "rabbit").start();     //兔子线程
        new Thread(implementRunnableTest2, "tortoise").start();    //乌龟线程
    }
}
