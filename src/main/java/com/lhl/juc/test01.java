package com.lhl.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/**
 * @athor:lhl
 * @create:2020-05-27 18:53
 */
public class test01 {



    public static void main(String[] args) {
        final Ticket ticket=new Ticket();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"C").start();
    }

}

class Ticket{
    private int num=30;

    public void sale(){

        Lock lock=new ReentrantLock();

        lock.lock();
        try{
            if (num>0){
                System.out.println(Thread.currentThread().getName()+":"+num--);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }

}
