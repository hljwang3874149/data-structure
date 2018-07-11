package com.company;

public class Main {

    public static void main(String[] args) {
        Array<Student> array = new Array<>();
        for (int i= 0 ; i <10 ; i++){

            array.addLast(new Student("na "+ i,i));
        }

       System.out.println( array.toString());
        array.remove(4);
        System.out.println( array.toString());
       System.out.println(array.remove());

        System.out.println( array.toString());

        array.setLast(new Student("tt" , 120));
        System.out.println( array.toString());

        array.add(2,new Student("xl", 200));

        System.out.println( array.toString());
        System.out.println(array.valueOfIndex(new Student("tt" , 120)));
        array.add(2,new Student("wx", 200));
        array.add(2,new Student("wxl", 220));

        System.out.println( array.toString());
        array.remove();
        System.out.println( array.toString());
        array.remove();
        System.out.println( array.toString());
    }
}
