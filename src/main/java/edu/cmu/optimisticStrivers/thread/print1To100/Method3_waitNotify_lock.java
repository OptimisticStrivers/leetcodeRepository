package edu.cmu.optimisticStrivers.thread.print1To100;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: Method3_waitNotify_locl
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/17 9:17 AM
 * @Version 1.0
 */
public class Method3_waitNotify_lock extends Thread{

    //有问题

//    用 ReentrantLock 来解决，本质和解法二一样，不过是用synchronized 换成 lock 来实现，等待唤醒机制用 signal 和 await来实现

    int threadNum = 5;
    static Lock lock;
    static Condition condition;
    static volatile int currentNum = 0;
    int name;

    public Method3_waitNotify_lock(int name) {
        lock = new ReentrantLock();
        condition = lock.newCondition();
        this.name = name;
    }

    @Override
    public void run() {

        while(true){
            lock.lock();
            if(currentNum<100){
                if(currentNum % threadNum == name){
                    currentNum++;
                    System.out.println("thread " + name + " print " + currentNum);
                    condition.signal();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                condition.signalAll();
                break;
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            new Method3_waitNotify_lock(i).start();
        }
    }
}
