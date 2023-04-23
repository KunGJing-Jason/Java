package SIM;

public interface SIM{
    int max = 100;
    int MIN = 10;
    default void GetNothing(){
        System.out.println("Test");
    }
    void CompuerSun(int a, int b);
    private void ShowMessage(){
        System.out.println("TEST");
    }
    static int MAX(){
        return MIN;
    }
}

abstract class Node{
    private void Node(){};
    protected void USA(){};
    protected abstract void get();
}
