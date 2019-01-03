package com.baicai.singleton;

/**
 * 双重检验锁
 * @Author yuzhou
 * @Date 19-1-1
 */
public class Singleton4 {

    /** 引用，volatile防止编译期流程优化 */
    private static volatile Singleton4 singleton4;

    /** 1.私有构造 */
    private Singleton4() {
    }

    /** 2.获取实例的方法 */
    public static Singleton4 getInstance() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
