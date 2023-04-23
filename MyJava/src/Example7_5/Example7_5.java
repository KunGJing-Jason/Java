package Example7_5;

public class Example7_5 {
    public static void main(String[] args){
        int n = 0, m = 0, t = 1000;
        try {
            m = Integer.parseInt("8899");
            n = Integer.parseInt("ab89");
            t = 7777;
        }catch(NumberFormatException e){
            System.out.println("发生异常:" + e.getMessage());
        }
        System.out.println("n ="+n+", m = "+m+",t = "+t);
        try{
            System.out.println("Exception on purpose:");
            throw new java.io.IOException("I was on purpose");
        }catch(java.io.IOException e){
            System.out.println("发生异常:" + e.getMessage());
        }
    }
}
