package com.baicai.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * 懒汉式
 * @Author yuzhou
 * @Date 19-1-1
 */
public class Singleton1 {

    /** 引用 */
    private static Singleton1 singleton1;
    
    /** 1.私有构造 */
    private Singleton1() {
    }

    /** 2.获取实例的方法 */
    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }


    /** 测试懒汉式的多线程并发BUG */
    public static void main(String[] args) throws InterruptedException {
        Set<Singleton1> set = new HashSet<>();
        // Windows每个进程最多1000个线程，Linux每个进程最多2000个线程
        for (int i = 0; i < 2000; i++) {
            new Thread(() -> {
                set.add(Singleton1.getInstance());
            }).start();
        }

        // main线程等待15秒，让2000个线程尽量都执行完毕
        Thread.sleep(15000);
        System.out.println("单例模式测试-----");
        for (Singleton1 singleton1 : set) {
            System.out.println(singleton1);
        }
    }
}
