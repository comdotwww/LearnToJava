package com.moeau.network.study.Thread.Unsafe;

//不安全的取钱
//2个人去银行取钱，账户
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");

        Drawing you = new Drawing(account,50,"You");
        Drawing girlfriend = new Drawing(account,100,"girlfriend");

        you.start();
        girlfriend.start();
    }
}

//账户
class Account {
    int money;  //余额
    String name;    //卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//bank + withdraw
class Drawing extends Thread {
    Account account;   //账户
    int drawingMoney;   //取钱数
    int nowMoney;   //当前钱数

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    //取钱
    @Override
    public void run() {
        //判断有没有钱
        if (account.money - drawingMoney <= 0) {
            System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
            return;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account.money = account.money - drawingMoney;
        nowMoney = nowMoney + drawingMoney;
        System.out.println(account.name + "余额为：" + account.money);
        //  <=> System.out.println(Thread.currentThread());
        System.out.println(this.getName() + "手里的钱：" + nowMoney);
    }
}












