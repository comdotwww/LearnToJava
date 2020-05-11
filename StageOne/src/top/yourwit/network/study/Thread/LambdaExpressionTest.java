package top.yourwit.network.study.Thread;
/*
* 总结：
*   1、Lambda表达式只能源有一行代码的情况下，简化为一行；
*   2、如源有多行代码，则如简化2，代码块需被花括号包裹；
*   3、多个参数也可去掉参数类型，若去掉，则需同时都去掉，且须加 ()；
*   前提是函数式接口：接口只有一个方法。
* */
public class LambdaExpressionTest {

    static class Love2 implements ILove {
        @Override
        public void Love(int a) {
            System.out.println("I Love Lambda!-->" + a);
        }
    }

    public static void main(String[] args) {

        ILove iLove = (int a) -> {
                System.out.println("I Love Lambda!-->" + a);
        };
        iLove.Love(520);

        //简化1：去掉参数返回类型
        iLove = (a) -> {
            System.out.println("I Love Lambda!-->" + a);
        };
        iLove.Love(1);

        //简化2：简化括号
        iLove = a -> {
            System.out.println("I Love Lambda!-->" + a);
        };
        iLove.Love(2);

        //简化3：去掉花括号
        iLove = a -> System.out.println("I Love Lambda!-->" + a);
        iLove.Love(3);
    }
}

interface ILove {
    void Love(int a);
}
