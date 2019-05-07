package com.baicai.singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author yuzhou
 * @Date 19-5-7
 */
public class Singleton8 {
    private static final AtomicReference<Singleton8> INSTANCE = new AtomicReference();

    private Singleton8() {}

    public static Singleton8 getInstance() {
        for (;;) {
            Singleton8 singleton8 = INSTANCE.get();
            if (null != singleton8)
                return singleton8;

            singleton8 = new Singleton8();
            if (INSTANCE.compareAndSet(null, singleton8))
                return singleton8;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Set<Singleton8> set = new HashSet<>();
        // Windows每个进程最多1000个线程，Linux每个进程最多2000个线程
        for (int i = 0; i < 2000; i++) {
            new Thread(() -> {
                set.add(Singleton8.getInstance());
            }).start();
        }

        // main线程等待15秒，让2000个线程尽量都执行完毕
        Thread.sleep(15000);
        System.out.println("单例模式测试-----");
        for (Singleton8 singleton8 : set) {
            System.out.println(singleton8);
        }
    }

}
