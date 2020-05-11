package top.yourwit.network.study.Thread;

/*
* 静态代理模式总结：
*   真实对象（You）、代理对象（Wedding）都要实现同一个接口（Marry）
*   代理对象要代理真实代理角色（You）
*
* 优点：
*   代理对象可以做很多真实对象做不了的事情（before、after）
*   真实对象专注做自己的事
* */


public class ProxyPattern {
    public static void main(String[] args) {
        You you = new You();
        //you.HappyMarry();

        new Thread(()-> System.out.println("I Love You!")).start();

        new WeddingCompany(new You()).HappyMarry();

//        WeddingCompany weddingCompany = new WeddingCompany(you);
//        weddingCompany.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

//真实角色，你去结婚
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("你要结婚了！");
    }
}

//代理角色，帮助你结婚
class WeddingCompany implements Marry{
    //真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚后，收尾款。");
    }

    private void before() {
        System.out.println("结婚前布置现场。");
    }
}