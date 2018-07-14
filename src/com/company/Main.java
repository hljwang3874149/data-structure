package com.company;

import com.company.array.Array;
import com.company.array.Student;
import com.company.stack.ArrayStack;

public class Main {

    public static void main(String[] args) {
//        testArray();
        testStack();
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
        for (int i = 0; i < 10; i++) {

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
}
