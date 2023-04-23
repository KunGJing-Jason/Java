public class MySimpleThread extends Thread{
    public void run(){
        for(int i=0; i<5; i++){
            for(int j=0; j<8; j++){
                System.out.print(getName()+"["+j+"]  ");
            }
            System.out.println();
        }
        System.out.println("-----" + getName() + " ends-----");
    }
}