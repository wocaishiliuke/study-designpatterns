package com.baicai.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举实现单例
 * @Author yuzhou
 * @Date 19-1-2
 */
public enum Singleton7 {
    //实例
    SINGLETON7;

    public Singleton7 getInstance() {
        return SINGLETON7;
    }

    /** 测试反射和反序列化破坏单例 */
    public static void main(String[] args)
            throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton7 singleton7 = Singleton7.SINGLETON7;
        //查看构造
        Constructor<?>[] constructors = Singleton7.class.getDeclaredConstructors();
        /* 反射获取实例 */
        //没有空参，该方式报错
        //Singleton7 singleton7Two = Singleton7.class.newInstance();
        //使用有参构造反射，同样报错
        Constructor<Singleton7> constructor = Singleton7.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        Singleton7 singleton7Two = constructor.newInstance("test", 666);

        /* 反序列化获取实例 */
        String file = "singleton7";
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(singleton7);
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Singleton7 singleton7Three = (Singleton7) inputStream.readObject();

        /* 比较3个实例 */
        System.out.println(singleton7 + "\n" + singleton7Two + "\n" + singleton7Three);

    }
}
