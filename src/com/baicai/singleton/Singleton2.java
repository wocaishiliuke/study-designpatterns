package com.baicai.singleton;

/**
 * 饿汉式
 * @Author yuzhou
 * @Date 19-1-1
 */
public class Singleton2 {

    /** 引用，类加载时就创建实例 */
    private final static Singleton2 singleton2 = new Singleton2();

    /** 1.私有构造 */
    private Singleton2() {
    }

    /** 2.获取实例的方法 */
    public static Singleton2 getInstance() {
        return singleton2;
    }
}
