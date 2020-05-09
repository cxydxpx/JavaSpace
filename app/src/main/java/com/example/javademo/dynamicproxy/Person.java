package com.example.javademo.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Person {
    public void sayHello(String content, int age);

    public void sayGoodBye(boolean seeAgin, double time);
}

class Student implements Person {

    @Override
    public void sayHello(String content, int age) {
        System.out.println("student say hello" + content + " " + age);
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("student sayGoodBye " + time + " " + seeAgin);
    }
}

class MyInvocationHandler implements InvocationHandler, Person {

    private Person object;

    public MyInvocationHandler(Person object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过反射调用 被代理类的方法
        return method.invoke(this, args);
    }

    @Override
    public void sayHello(String content, int age) {
        System.out.println("所以 这个才是被代理的类");
//        object.sayHello(content, age);
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("这个才是被代理的类");
//        object.sayGoodBye(seeAgin, time);
    }

    public static void main(String[] args) {
        Student student = new Student();

        MyInvocationHandler h = new MyInvocationHandler(student);
        Person person = (Person) Proxy.newProxyInstance(
                //获得加载被代理类的 类加载器
                student.getClass().getClassLoader(),
                //指明被代理类实现的接口
                student.getClass().getInterfaces(),
                h);
        person.sayHello("你好啊", 20);

        person.sayGoodBye(true, 20.0);

        Teacher teacher = new Teacher();
        teacher.sayHello("老师好",30);
        teacher.sayGoodBye(true, 20.0);

    }

}

class Teacher implements Person {
    @Override
    public void sayHello(String content, int age) {
        System.out.println("Teacher say hello" + content + " " + age);

    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("Teacher sayGoodBye " + time + " " + seeAgin);

    }
}
