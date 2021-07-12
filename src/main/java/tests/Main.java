package tests;


class Q {

    int n;
    boolean value = false;

    synchronized int get() {
        notify();
            try {
                wait();
            } catch (InterruptedException e) {

                System.out.println("InterruptedException catched");

            }



        System.out.println("получено" + n);
        value = false;

      //  notify();


        return n;
    }


    public synchronized void put(int n) {

        notify();
            try {
                wait();
            } catch (InterruptedException s) {

                System.out.println("InterruptedException" + s);
            }
            this.n = n;
            value = true;
            System.out.println("Отправлено" + n);
        //    notify();



    }
}
        class Consumer implements Runnable {
            Q q ;
            public Consumer(Q q ){
                this.q=q;
                new Thread(this,"COnsumer").start();





            }



            @Override
            public void run() {
                while(true){
                    q.get();

                }
            }

        }

        class Producer implements Runnable {

            Q q ;
            public Producer( Q q){
                this.q = q ;
                new Thread(this,"Producer").start();



            }


            @Override
            public void run() {
                int i =0;
            while(true){
                q.put(i++);



            }

            }


        }







public class Main {

    public static void main(String[] args) {
        var sum =0;
        sum+=1;
        Q q = new Q();

        new Producer(q);
        new Consumer(q);


    }


}
