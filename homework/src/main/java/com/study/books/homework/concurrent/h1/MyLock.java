package com.study.books.homework.concurrent.h1;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;


/**
 * 不可重入锁
 */
//@todo 自定义不可重入锁
public class MyLock {

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            return super.tryAcquire(arg);
        }

        @Override
        protected boolean tryRelease(int arg) {
            return super.tryRelease(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }
    }

}
