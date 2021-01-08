package com.eden.learn.juc;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundeQueue {

    private LinkedList<Object> buffer;
    private int size;
    private Lock lock;
    private Condition empty;
    private Condition full;

    public BoundeQueue(int size) {
        this.size = size;
        buffer = new LinkedList<Object>();
        lock = new ReentrantLock();
        empty = lock.newCondition();
        full = lock.newCondition();
    }

    public void set(Object object) {
        lock.lock();
        try {
            while (buffer.size() == size) {
                //已经放满了  等一等
                full.await();
            }
            buffer.add(object);
            System.out.println(object+" set ");
            empty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object get() {
        Object poll = null;
        lock.lock();
        try {
            while (buffer.size() == 0) {
                //已经放满了  等一等
                empty.await();
            }
            poll = buffer.poll();
            System.out.println(poll+" get ");
            full.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return poll;
    }


    public static void main(String[] args) {
        BoundeQueue boundeQueue = new BoundeQueue(5);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {


                }

                boundeQueue.set(new Object());
            }
        });

        executorService.execute(() -> {
            while (true) {


                boundeQueue.get();
            }
        });
    }
}
