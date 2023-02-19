package edu.cmu.optimisticStrivers.thread.abc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: Method1_AtomicInteger
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/17 8:53 AM
 * @Version 1.0
 */
public class Method1_AtomicInteger implements Runnable {

//    https://blog.csdn.net/qq_19734597/article/details/120226950

    private AtomicInteger currentCount = null;

    private static final Integer MAX_COUNT = 10;

    private static String[] chars = {"a", "b", "c"};

    private String name;

    public Method1_AtomicInteger(String name, AtomicInteger currentCount) {
        this.name = name;
        this.currentCount = currentCount;
    }

    @Override
    public void run() {
        while (currentCount.get() < MAX_COUNT) {
            if (this.name.equals(chars[currentCount.get() % 3])) {
                printAndPlusOne(this.name);
            }
        }
    }

    public void printAndPlusOne(String content) {
        System.out.print(content);
        currentCount.getAndIncrement();
    }

    public static void main(String[] args) {

        AtomicInteger currentCount = new AtomicInteger(0);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 20, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        threadPoolExecutor.execute(new Method1_AtomicInteger("a", currentCount)); //thread a打印 a
        threadPoolExecutor.execute(new Method1_AtomicInteger("b", currentCount));
        threadPoolExecutor.execute(new Method1_AtomicInteger("c", currentCount));
        threadPoolExecutor.shutdown();

    }

}
