package taras_task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class Main_pidreras {



    public static int foo(){
        try{

        throw
                new Exception();

        }catch(Exception e ){

            return 10 ;
        }
        finally{

            return 20;
        }


    }

    public static void main(String[] args) throws InterruptedException {
String str = null;
        try{

str.length();



        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("sdads");



        Lock lock  =  new ReentrantLock();
        Lock lock1  =  new ReentrantLock();
        Deque<String>  deque= new ArrayDeque<>();
        deque.add("one");
        deque.add("two");
        deque.add("three");
        System.out.println(deque.remove());
        int x=0;
        int y=7/x;



        try{
            System.out.println("1");
            lock.lock();
            System.out.println("2");
        }finally {
        lock1.unlock();
            System.out.println("3");



        }
    }






}
