package com.study.books.homework.jvm.h1;


//@todo 类加载分析

//@todo 1:SingleTon singleTon = SingleTon.getInstance();调用了类的SingleTon调用了类的静态方法，触发类的初始化
//@todo 2:类加载的时候在准备阶段过程中为类的静态变量分配内存并初始化默认值 singleton=null count1=0,count2=0
//@todo 3:类初始化化，为类的静态变量赋值和执行静态代码快。此时执行singleton=new SingleTon();因此触发了SingleTon类的构造方法
//@todo 4:执行SingleTon类的构造方法后count=1;count2=1
//@todo 5:然后继续为count1与count2的静态变量赋值,此时count1没有赋值操作,所以count1为1,但是count2执行赋值操作就变为0了
public class Singleton {

    private static Singleton singleton = new Singleton();
    public static int count1;
    public static int count2 = 0;

    private Singleton() {
        count1++;
        count2++;
    }

    public static Singleton getInstance(){
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("count1:"+singleton.count1);
        System.out.println("count2:"+singleton.count2);
    }



}
