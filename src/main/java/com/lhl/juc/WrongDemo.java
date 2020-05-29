package com.lhl.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @athor:lhl
 * @create:2020-05-27 20:47
 * 写一个ArrayList线程不安全的例子
 * 并解决它
 *
 * 多次执行之后报错:java.util.ConcurrentModificationException
 */
public class WrongDemo {

    public static void main(String[] args) {

//        List list=new ArrayList();
//        List list=new Vector();  //方法1
//        List list= Collections.synchronizedList(new ArrayList<>()); //方法2
        List list=new CopyOnWriteArrayList(); //方法3 写时复制list,与ArrayList平级的类
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list+":"+Thread.currentThread().getName());
            },String.valueOf(i)).start();
        }

    }

}
