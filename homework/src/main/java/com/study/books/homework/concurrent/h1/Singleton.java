package com.study.books.homework.concurrent.h1;

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
