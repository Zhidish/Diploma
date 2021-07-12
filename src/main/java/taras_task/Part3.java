package taras_task;

import lombok.SneakyThrows;

public class Part3  {
private final static Object obj = new Object();
private static int counter;
private  static int counter1;
private int numberOfThreads;
private  int numberOfIterations;




class ChildThread extends Thread{

     @SneakyThrows
     public void run(){
     for(int i =0;i<numberOfIterations;i++){
         compare();

     }
     for (int i=0;i<numberOfIterations;i++){
         compareSync();
     }


     }




}

public Part3( int numberOfThreads, int numberOfIterations){
            this.numberOfThreads=numberOfThreads;
            this.numberOfIterations=numberOfIterations;

    }



            public Part3(){


            }

    public static void main(String[] args) {
        new Part3(5, 6);

        for (int i = 0; i < 5; i++) {
            new Part3(5, 6).new ChildThread().start();


        }
    }

    public void compare()  {

        try {
            System.out.println(counter == counter1);

            counter++;
            Thread.sleep(100);
            counter1++;
        }catch(InterruptedException e ){
            e.getCause();
        }


    }


    public void compareSync() throws InterruptedException {
        synchronized (obj){
        try {
            counter++;
            Thread.sleep(100);
            counter1++;
        }catch(InterruptedException e ){
            e.getCause();

        }



        }


    }




    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter1() {
        return counter1;
    }

    public void setCounter1(int counter1) {
        this.counter1 = counter1;
    }
     public  void setNumberOfThreads(int numberOfThreads){
                this.numberOfThreads=numberOfThreads;

     }


     public void setNumberOfIterations(int numberOfIterations){
        this.numberOfIterations=numberOfIterations;

     }
     public int getNumberOfThreads(){
            return numberOfThreads;
     }

    public  int getNumberOfIterations(){
        return numberOfIterations;
    }

}
