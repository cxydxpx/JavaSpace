package com.example.javademo.java;//: holding/QueueDemo.java
// Upcasting to a Queue from a LinkedList.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
    public static void printQ(Queue queue) {

        while (queue.peek() != null)
            System.out.print(queue.remove() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
//    Queue<Integer> queue = new LinkedList<Integer>();
//    Random rand = new Random(47);
//
//    System.out.println(rand.nextInt(100));
//
//    for(int i = 0; i < 10; i++){
//      System.out.print(rand.nextInt(i + 10));
////      queue.offer(rand.nextInt(i + 10));
//      queue.offer(i);
//    }
//    System.out.println();
//    printQ(queue);
//    Queue<Character> qc = new LinkedList<Character>();
//    for(char c : "Brontosaurus".toCharArray())
//      qc.offer(c);
//    printQ(qc);


        Queue<Integer> mList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            mList.add(i);
        }

        Integer element = mList.poll();
        System.out.println("poll值: " + element);

        Integer peek = mList.peek();
        System.out.println("peek值: " + peek);



        System.out.println(mList);
    }
} /* Output:
8 1 1 1 5 14 3 1 0 1
B r o n t o s a u r u s
*///:~
