package taras_task;


import lombok.SneakyThrows;

public class Main {


      final static Object object = new Object();


    private class ChildThread extends Thread {
         public ChildThread(String name){
             super(name);

         }


        @SneakyThrows
        @Override
        public void run() {
            synchronized(object) {
                for (int i = 0; i < 4; i++) {
                    System.err.println(this.getName());
                    sleep(500);
                        object.notify();
                        object.wait();

                }
            }

        }
    }


    private class ChildInterfaceThread implements Runnable {

        String name;

                ChildInterfaceThread(String name){
                   this.name=name;
                }
        @SneakyThrows
        @Override
        public void run() {
            synchronized (object) {
                for (int i = 0; i < 4; i++) {
                    System.err.println(getName());
                        object.notify();
                        object.wait();
                }
            }
        }

        public String getName(){
                    return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


    public static void main(String[] args) {

         new Main().pusk();
            object.notify();


    }

    public void pusk(){

        ChildInterfaceThread childInterfaceThread=new ChildInterfaceThread("child_interface");
        Thread thread =new Thread(childInterfaceThread);
        ChildThread  childThread = new ChildThread("child_thread");

        childThread.start();
        thread.start();


    }


}
