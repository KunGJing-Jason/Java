package Review;

import java.util.Arrays;
import java.util.Scanner;

public class ExampleOne {
    public static void main(String[] args){
        USB usb = ()->{
            System.out.println("Type-C");
        };
        usb.getUSBType();
    }
}

abstract class Printer{
    abstract int getLength(String str);
    abstract String showPrint(String str);
    private int Noth(){
        return 0;
    }
}

class HP extends Printer{
    int getLength(String str){
        return str.length();
    }
    String showPrint(String str){
        return str;
    }
    String showPrint(int a){
        return Integer.toString(a);
    }
}

interface USB{
    void getUSBType();
    private void nothing(){}
    default void setNone(){}
    static void get(){}
}
class E {
    int  x;
    public void f(int n) {
        int m;               //A
        int t = x+n;         //B
        int y = x+m;         //C
        m = 10;
        y = x+m;            //D
    }
}