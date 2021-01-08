package com.eden.learn.juc;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionUseCase {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ConditionUseCase conditionUseCase = new ConditionUseCase();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()->{
            conditionUseCase.conditionAwaitTime();
        });
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    conditionUseCase.conditionSignal();
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    conditionUseCase.conditionWait();
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });

    }

    public void conditionWait(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "拿到锁");

        try {
            System.out.println(Thread.currentThread().getName() + "阻塞 并 等待信号");
            condition.await();
            System.out.println(Thread.currentThread().getName() + "获取到信号");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSignal(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "拿到锁");

        try {
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "发出信号");
        }catch (Exception e){

        } finally {
            lock.unlock();
        }
    }

    public void conditionAwaitTime(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "拿到锁");

        try {
            condition.await(3,TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "超过时间 继续跑");
        }catch (Exception e){

        } finally {
            lock.unlock();
        }
    }
}
