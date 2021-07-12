package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    private void method_to_call(Main a ){
        a.say_cool_stuf();

    }
    private void say_cool_stuf(){
        System.out.println("cool_stuff");
    }






    public static void main(String[] args) {

            new Main().method_to_call(new Main());



    }





}

class A{
    protected void method_protected(){

        System.out.println("FOOO");

    }

    private void private_method(){

        System.out.println("like a whisper");

    }


    protected void  call_private_method(A a){



        a.private_method();
    }


}

class B extends A{


    public void main_foo(){



    }



}

