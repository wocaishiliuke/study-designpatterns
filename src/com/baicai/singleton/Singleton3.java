package com.baicai.singleton;

/**
 * 懒汉同步式
 * @Author yuzhou
 * @Date 19-1-1
 */
public class Singleton3 {

    /** 引用 */
    private static Singleton3 singleton3;

    /** 1.私有构造 */
    private Singleton3() {
    }

    /** 2.获取实例的方法 */
    public synchronized static Singleton3 getInstance() {
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
