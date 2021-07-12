package package_1;

import lombok.SneakyThrows;

public class MyClass {
    static final Object den = new Object();
    static final Object ada = new Object();


    public static int n;
    public static int m = 0;


    public Thread t1 = new Thread() {
        @SneakyThrows
        public void run() {
            synchronized (ada) {

                for (int i = 0; i < 5; i++, n++)
                    System.out.println("Thread1 n = " + n);
                Thread.yield();


                    ada.wait();
                synchronized (den) {


                    for (int i = 0; i < 5; i++, m++)
                        System.out.println("Thread 1 m = " + m);
                    System.out.println("Thread1 success!");

                }


            }


        }


    };
    public Thread t2 = new Thread() {


        @SneakyThrows
        public void run() {
            synchronized (ada) {


                for (int i = 0; i < 5; i++, m++)
                    System.out.println("Thread2 m = " + m);

                synchronized (den) {
                    for (int i = 0; i < 5; i++, n++)
                        System.out.println("Thread2 n = " + n);
                    System.out.println("Thread2 success");
                        ada.notify();

                }

            }

        }


    };


    public static void main(String[] args) {
//        MyClass myClass = new MyClass();
//        myClass.t1.start();
//        myClass.t2.start();
//
        boolean bil = true;
     char ch ='g';



    }

}
