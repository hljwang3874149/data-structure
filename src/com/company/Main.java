package com.company;

import com.company.array.Array;
import com.company.array.Student;
import com.company.queue.ArrayQueue;
import com.company.queue.LoopArrayQueue;
import com.company.queue.Queue;
import com.company.stack.ArrayStack;
import com.company.tree.bst.BinarySearchTree;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        testArray();
//        testStack();
//        testArrayQueue();
//        testLoopQueeu();
//      System.out.println(testQueueTime(new ArrayQueue<Integer>(),100000));
//      System.out.println(testQueueTime(new LoopArrayQueue<>(),100000));
        testBSTree();
    }

    private static double testQueueTime(Queue<Integer> queue, int count) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i< count ;i++){
            queue.dequeue();
        }
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;

    }


    private static void testLoopQueeu() {
        LoopArrayQueue<Integer> loopQueue = new LoopArrayQueue<>(5);
        for (int i = 0; i < 20; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue.toString());
            if (i % 2 == 1) {
                loopQueue.dequeue();
                System.out.println(loopQueue.toString());
            }
        }
        for (int i = 0; i < 10; i++) {
            loopQueue.dequeue();
            System.out.println(loopQueue.toString());
        }
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue.toString());
        }
    }

    private static void testArrayQueue() {

        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            integerArrayQueue.enqueue(i);
            System.out.println(integerArrayQueue.toString());

        }
        integerArrayQueue.dequeue();
        System.out.println(integerArrayQueue.toString());
        integerArrayQueue.enqueue(8);
        System.out.println(integerArrayQueue.toString());


    }

    private static void testStack() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack.toString());
        }
        arrayStack.pop();

        System.out.println(arrayStack.toString());

    }

    private static void testArray() {
        Array<Student> array = new Array<>();
        for (int i = 0; i < 55; i++) {

            array.addLast(new Student("na " + i, i));
        }

        System.out.println(array.toString());
        array.remove(4);
        System.out.println(array.toString());
        System.out.println(array.removeLast());

        System.out.println(array.toString());

        array.setLast(new Student("tt", 120));
        System.out.println(array.toString());

        array.add(2, new Student("xl", 200));

        System.out.println(array.toString());
        System.out.println(array.valueOfIndex(new Student("tt", 120)));
        array.add(2, new Student("wx", 200));
        array.add(2, new Student("wxl", 220));

        System.out.println(array.toString());
        array.removeLast();
        System.out.println(array.toString());
        array.removeLast();
        System.out.println(array.toString());

    }

    private  static  void testBSTree(){
        Integer[] ints = new Integer[]{5,3,4,1,2,6,7};
        BinarySearchTree<Integer>  binarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < ints.length; i++) {
            binarySearchTree.addNode(ints[i]);
        }
        binarySearchTree.preOrder();
        System.out.println("#########");
        binarySearchTree.inOrder();
        System.out.println("#########");
        binarySearchTree.postOrder();
        System.out.println("#########");
        System.out.println(binarySearchTree);

    }
}
