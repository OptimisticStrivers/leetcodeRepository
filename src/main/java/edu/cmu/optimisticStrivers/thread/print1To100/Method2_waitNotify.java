package edu.cmu.optimisticStrivers.thread.print1To100;

/**
 * @ClassName: Method2_waitNotify
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/17 9:02 AM
 * @Version 1.0
 */

//阻塞是线程自己发现没资源，获取不到资源，它自己先去休息了，有资源它会自己回来，而且不占用CPU。
//忙等待是指线程找不到资源就一直等，并且将CPU占据。
//睡眠是指CPU告诉线程，你先去休息，过规定时间，你自己回来。
//挂起是指CPU告诉线程你先去休息，有资源我告诉你。它会释放CPU。

//所以方法1的话是 忙等 占据cpu（相当于轮询问） 效率低
//用等待唤醒机制，当一个线程执行完当前任务后再唤醒其他线程来执行任务，自己去休眠，避免在线程执行任务的时候其他线程处于忙等状态，浪费cpu资源。
public class Method2_waitNotify extends Thread {

//    https://blog.csdn.net/m0_58806933/article/details/123952196

    static final Object target = new Object();
    static int threadAmount = 5;
    static volatile int currentNum = 0;
    private int threadName;

    public Method2_waitNotify(int i) {
        this.threadName = i;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (target) { //或者用.class对象
                if (currentNum < 100) {
                    if (currentNum % threadAmount == threadName) {
                        currentNum++;
                        System.out.println("thread " + threadName + " print " + currentNum);
                        try {
                            target.notify(); //唤醒一个
                            target.wait(); //自己睡
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        target.notify(); //唤醒一个
                        try {
                            target.wait(); //自己睡
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
//                    target.notify();
                    target.notifyAll();
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Method2_waitNotify(i).start();
        }
    }
}
