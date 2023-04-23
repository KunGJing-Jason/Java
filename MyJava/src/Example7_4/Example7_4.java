package Example7_4;
interface SpeakHello{
    void speak();
}

class  HelloMachine {
    public void turnOn(SpeakHello hello) {
        hello.speak();
    }
}
public class Example7_4 {
    public static void main(String[] args){
        HelloMachine machine = new HelloMachine();
        machine.turnOn(()->{
                System.out.println("Hello, you are welcome!");
        });

        machine.turnOn(()-> {
                System.out.println("你好，欢迎光临！");
        });
    }
}
