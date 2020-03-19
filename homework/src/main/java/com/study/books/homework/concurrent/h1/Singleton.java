package com.study.books.homework.concurrent.h1;

//1、单例类只能有一个实例。
//2、单例类必须自己创建自己的唯一实例。
//3、单例类必须给所有其他对象提供这一实例。

/**
 * 单例模式写法
 */
//@todo 双重检测模式
public class Singleton {
    //volatile(在这里起作用的是禁止指令重排序)
    public static volatile Singleton singleton;
    //构造方法私有化
    private Singleton() {
    }
    //双重检测
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

//@todo 懒汉模式
class Singleton1 {
    public static Singleton1 singleton;
    private Singleton1() {
    }
    public static synchronized Singleton1 getInstance() {
        if (null == singleton) {
            singleton = new Singleton1();
        }
        return singleton;
    }
}

//@todo 恶汉模式
class Singleton2{
    public static Singleton2 singleton = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance(){
        return singleton;
    }
}

//@todo 静态内部类模式
//第一次加载Singleton类时并不会初始化sInstance，只有第一次调用getInstance方法时虚拟机加载SingletonHolder 并初始化sInstance ，这样不仅能确保线程安全也能保证Singleton类的唯一性，所以推荐使用静态内部类单例模式。
class Singleton3{

    private Singleton3() {
    }

    private static class SingletonHolder{
        public static Singleton3 singleton = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return SingletonHolder.singleton;
    }
}

//@todo 枚举方式
enum  Singleton4{
    INSTANCE;
    public void getInstance(){}
}
