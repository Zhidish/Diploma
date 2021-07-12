package taras_task;

import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Part5 {
    public  static final Object  object = new Object();
    public static RandomAccessFile randomAccessFile;

    static {
        try {
            randomAccessFile = new RandomAccessFile("part5.txt","rwd");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {

   /* for(int i=0;i<9;i++){
        new ChildThread(i).start();

    }*/

        randomAccessFile.seek(0);
        randomAccessFile.writeUTF(String.valueOf(1));
        randomAccessFile.seek(2);
        randomAccessFile.writeUTF(String.valueOf(2));
        randomAccessFile.close();

    }


}



class ChildThread extends Thread{
    int number;
    RandomAccessFile randomAccessFile=Part5.randomAccessFile;

@SneakyThrows
@Override
public synchronized void  run() {
    setPriority(10-number);

        synchronized (Part5.object) {
            for (int i = 0; i < 20; i++) {

                randomAccessFile.seek(i);
                randomAccessFile.writeUTF(String.valueOf(number));

            }
            randomAccessFile.writeUTF("\n");

        }


}


 public ChildThread(int number){
    this.number= number;
 }



}