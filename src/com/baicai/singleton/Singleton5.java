package com.baicai.singleton;

/**
 * 静态内部类
 * @Author yuzhou
 * @Date 19-1-1
 */
public class Singleton5 {
    /** 1.私有构造 */
    private Singleton5() {}

    /** 2.获取实例的方法 */
    public static Singleton5 getInstance() {
        return Inner.singleton5;
    }

    /** 静态内部类，即能保证懒加载，又能保证线程安全 */
    private static class Inner {
        private static final Singleton5 singleton5 = new Singleton5();
    }
}
