package Example7_3;
interface SpeakHello{
    void speak();
}

class  HelloMachine {
    public void turnOn(SpeakHello hello) {
        hello.speak();
    }
}

public class Example7_3 {
    public static void main(String[] args){
        HelloMachine machine = new HelloMachine();
        machine.turnOn(new SpeakHello() {
            @Override
            public void speak() {
                System.out.println("Hello, you are welcome!");
            }
        });

        machine.turnOn(new SpeakHello() {
            @Override
            public void speak() {
                System.out.println("你好，欢迎光临！");
            }
        });
    }
}
