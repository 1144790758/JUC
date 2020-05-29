package com.lhl.juc;

/**
 * @athor:lhl
 * @create:2020-05-29 10:47
 * 测试到底lock的什么,锁了那些东西不能同时修改
 * 实验结论:synchronized用this等锁住的是代码块,属性其他成员变量任然没有锁住,其他线程任然可以修改属性变量
 */
public class LockWhat {

    public static void main(String[] args) {
        TV t1=new TV();
        new Thread(()->t1.watch(),"A").start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.num=100;
        System.out.println(Thread.currentThread().getName()+":"+t1.num);
//        t1.watch();
    }
}
class TV{

    int num=10;

    public void watch(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized(this){
            System.out.println(Thread.currentThread().getName()+":"+num--);
        }
    }

}