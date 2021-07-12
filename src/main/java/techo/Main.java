package techo;

interface  I_A{
    int i=9;
public void out1()throws Exception;
}
interface I_B{
    public void out2();

}


public class Main implements I_A,I_B{
  static   boolean  booleans;
boolean[] arr;
int i =9;
public static void test_1(){
    System.out.println("BAtushka");

}

     class Inner{
public static final int u=9;

    }


    public static void main(String[] args) {

     short y =8;
        float hj=21.1f;
        double hjj=21.1d;
        System.out.println(hj);
  int i =10;
  i+=i++;
        System.out.println(i);
    Main main = new C();
        System.out.println(((C)main). i);
 
        
    }


    @Override
    public void out1() throws IllegalAccessException {
        System.out.println("1");
    }

    @Override
    public void out2() {
        System.out.println("2");
    }
}

class C extends Main implements I_A{
int i=10;
 void method(){


}

/*
static class Gh  implements  I_A{
    @Override
    public void out1() {

    }
}
*/
static class Ggh{}
}

