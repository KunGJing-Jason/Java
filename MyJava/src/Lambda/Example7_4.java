package Lambda;
interface SpeakHello {
    void speak();
}
class HelloMachine{
    public void TurnOn(SpeakHello hello){
        hello.speak();
    }
}

public class Example7_4 {
    public static void main(String[] args){
        HelloMachine machine = new HelloMachine();
        machine.TurnOn(() -> {
            System.out.println("Hello, you are welcome!");
        });

        machine.TurnOn(() -> {
            System.out.println("你好！ 欢迎光临！");
        });
    }
}
