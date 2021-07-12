package techo;

public class A {
    private int i=9;



    public  int getX(){

        return i;
    }
    public static void main(String[] args) {
        B b =new B();
        System.out.println( b.getX());
    }

}


class B extends A{



}
