package threads;

import lombok.SneakyThrows;

import java.util.Set;

public class Main {

    void test() {

        for (int i = 0; i < 100; i++) {
            class Inner {
                void display() {

                    System.out.println("outer dfdfd");

                }

                private void print() {
                }

            }
            Inner inner = new Inner();
            inner.print();

        }


    }


    static int x = 3;

    static void tripple(int xn) {
        x *= xn;


    }

    static int getx() {
        tripple(x);

        return x;
    }

    public static void main(String[] args) throws InterruptedException {
        int io =1;






        int x = 3;
        for (int i = 0; i < 10; i++) {
            labael:
            System.out.println("sdsdsdsdsdsdsdsds");

            labael1:
            ;

        }

        String s = "abs";
        System.out.println((46 >> 2));
        MyClass myclass = new MyClass();
        System.out.println(getx());
        MyThread myThread = new MyThread("A");
        MyThread myThread1 = new MyThread("B");
        MyThread myThread2 = new MyThread("C");
        MyThread myThread3 = new MyThread("D");

        myThread1.start();
        myThread1.using(myclass);
        myThread.start();
        myThread.using(myclass);
        myThread2.start();
        myThread2.using(myclass);
        myThread3.start();
        myThread3.using(myclass);


    }


}


class MyThread extends Thread {
    String name;

    <T> void using(T obj) {


        ((MyClass) obj).print();
        System.out.println("from this class " + name);

    }

    MyThread(String name) {
        this.name = name;


    }


}


class MyClass {


    synchronized void print() {
        int i = 0;
        do {
            i++;


        } while (i != 1000);


    }


}

interface FACE {
}

abstract class VID implements FACE {


}

class Print1 {
    private void print() {

        System.out.println(777);
    }


    void print(Print1 p) {

        p.print();


    }

}


class Print2 extends Print1 {
    void print() {
        System.out.println(666);
    }

    public static void main(String[] args) {
        Print1 p = new Print1();
        Print2 q = new Print2();
        p.print(q);
        String str = null;
        System.out.println(str);

        Boolean  b = Boolean.valueOf("test");
        System.out.println(b );

    }
}


