package com.moeau.network.study.Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

//每一个对象都有一把锁，sleep()不会释放锁
//模拟倒计时
public class SleepThreadTest_2 {
    public static void main(String[] args) {
        Countdown();

        //打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis());  //获取系统当前时间
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());  //更新系统当前时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void Countdown(){
        int num = 10;
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(num--);
                if(num<=0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
