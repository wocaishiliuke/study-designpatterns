package com.baicai.singleton;

import java.io.*;

/**
 * 静态内部类+重写readResolve方法
 * @Author yuzhou
 * @Date 19-1-1
 */
public class Singleton6 implements Serializable{
    /** 1.私有构造 */
    private Singleton6() {}

    /** 2.获取实例的方法 */
    public static Singleton6 getInstance() {
        return Inner.singleton6;
    }

    /** 静态内部类，即能保证懒加载，又能保证线程安全 */
    private static class Inner {
        private static final Singleton6 singleton6 = new Singleton6();
    }

    /** 重写该方法，防止反序列化破坏单例 */
    public Object readResolve() {
        return Inner.singleton6;
    }

    /** 测试反射和反序列化破坏单例 */
    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, IOException, ClassNotFoundException {
        Singleton6 singleton6 = getInstance();
        /* 反射获取实例 */
        Singleton6 singleton6Two = Singleton6.class.newInstance();

        /* 反序列化获取实例 */
        String file = "singleton6";
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(singleton6);
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Singleton6 singleton6Three = (Singleton6) inputStream.readObject();

        /* 比较3个实例 */
        System.out.println(singleton6 + "\n" + singleton6Two + "\n" + singleton6Three);

    }
}
