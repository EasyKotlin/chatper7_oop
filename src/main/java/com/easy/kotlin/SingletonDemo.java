package com.easy.kotlin;

import org.jetbrains.annotations.NotNull;

/**
 * Created by jack on 2017/7/3.
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        //Singleton singleton2 = new Singleton(); //error, cannot private access
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton() {} // private

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


