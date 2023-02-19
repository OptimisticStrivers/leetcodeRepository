package edu.cmu.optimisticStrivers.thread.print1To100;

/**
 * @ClassName: Method1_syn
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/17 8:55 AM
 * @Version 1.0
 */
public class Method1_syn extends Thread {

    static int threadAmount = 5;
    static volatile int currentNum = 0;
    private int threadName;

    public Method1_syn(int name) {
        threadName = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Method1_syn.class) {
                if (currentNum < 100) {
                    if (currentNum % threadAmount == threadName) {
                        currentNum++;
                        System.out.println("thread " + threadName + " print " + currentNum);
                    }
                } else {
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Method1_syn(i).start();
        }

    }
}
