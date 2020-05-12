package com.moeau.network.study.Thread;

/*
* 目的：避免匿名内部类定义过多；
*      使代码更简洁；
*      去掉无意义代码，留下核心的逻辑。
*       其 实质 属于函数式编程的概念。
*       (params) -> expression  //表达式
*       (params) -> statement   //语句
*       (params) -> { statement }
 * */

/*
* 函数式接口定义：
*   任何接口，若 只包含唯一一个抽象方法，则它是一个函数式接口。
*   对于函数式接口，可 通过Lambda表达式来创建该接口的对象。
* */

public class LambdaExpression {

    //3.静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I Like Lambda!2");
        }
    }

    public static void main(String[] args) {
        ILike iLike = new Like();
        iLike.lambda();
        iLike = new Like2();
        iLike.lambda();

        //4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I Like Lambda!3");
            }
        }

        iLike = new Like3();
        iLike.lambda();

        //5.匿名内部类，没有类名称，必须借助接口 或者 父类
        iLike = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I Like Lambda!4");
            }
        };
        iLike.lambda();

        //6.用Lambda简化 JDK1.8+
        iLike = () -> {
            System.out.println("I Like Lambda!5");
        };
        iLike.lambda();
    }
}

//1、定义一个函数式接口
interface ILike{
    public abstract void lambda();
    //或 void lambda();
}

//2.实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I Like Lambda!");
    }
}