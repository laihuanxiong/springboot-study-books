package com.study.books.homework.concurrent.h1;

//@todo 死锁的产生情况（静态死锁）
public class DeadLock {

    private static final Object lock1 = new Object();//第一个锁
    private static final Object lock2 = new Object();//第二个锁

    //先拿第一个锁，在那第二个锁
    private static void firstToSecond() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (lock1) {
            System.out.println(threadName + " get 1st");
            Thread.sleep(2000);
            synchronized (lock2) {
                System.out.println(threadName + " get 2st");
            }
        }
    }

    //先拿第二个锁，再拿第一个锁
    private static void secondToFirst() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (lock2) {
            System.out.println(threadName + " get 2st");
            Thread.sleep(2000);
            synchronized (lock1) {
                System.out.println(threadName + " get 1st");
            }
        }
    }

    private static class MyThread implements Runnable {

        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            Thread.currentThread().setName(name);
            try {
                secondToFirst();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("lock1ThreadName");
        MyThread myThread = new MyThread("lock2ThreadName");
        new Thread(myThread).start();
        firstToSecond();
    }

}
