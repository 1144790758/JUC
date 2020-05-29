package com.lhl.juc;



/**
 * @athor:lhl
 * @create:2020-05-28 13:06
 */

public class Lock8Demo  {

    public static void main(String[] args) throws InterruptedException {
        Phone p=new Phone();
        new Thread(()->{p.sendEmail();}).start();
        new Thread(()->{p.sendMs();}).start();
    }
}

class Phone{
    Object lock_sendEmail=new Object();
    Object lock_sendMs=new Object();

    public  void sendEmail(){
        synchronized(this){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sending email...");
        }

    }

    public void sendMs(){
//        synchronized(lock_sendMs){
            System.out.println("sending Ms...");
//        }

    }
}