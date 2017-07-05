package com.easy.kotlin;

/**
 * Created by jack on 2017/7/5.
 */
interface JSubject {
    public void request();
}

class JRealSubject implements JSubject {
    @Override
    public void request() {
        System.out.println("JRealSubject Requesting");
    }
}

class JProxy implements JSubject {
    private JSubject subject = null;

    //通过构造函数传递代理者
    public JProxy(JSubject sub) {
        this.subject = sub;
    }

    @Override
    public void request() { //实现接口中定义的方法
        this.before();
        this.subject.request();
        this.after();
    }

    private void before() {
        System.out.println("JProxy Before Requesting ");
    }

    private void after() {
        System.out.println("JProxy After Requesting ");
    }
}

public class DelegateDemo {
    public static void main(String[] args) {
        JRealSubject jRealSubject = new JRealSubject();
        JProxy jProxy = new JProxy(jRealSubject);
        jProxy.request();
    }
}
