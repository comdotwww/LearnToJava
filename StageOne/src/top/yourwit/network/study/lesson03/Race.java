package top.yourwit.network.study.lesson03;

//  龟兔赛跑
public class Race implements Runnable {
    @Override
    public void run() {
//

    }


    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"Test");
        new Thread(race,"Test2");
    }
}
