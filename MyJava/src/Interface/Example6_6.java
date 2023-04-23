package Interface;

interface SpeakHello{
    void speakHello();
}
abstract class test{
    static void tesd(){

    }
    private void sum(){

    }
    abstract  class none{

    }

}
class Chinese implements  SpeakHello{
    @Override
    public void speakHello() {
        System.out.println("您好，您吃了吗？");
    }
}

class English implements  SpeakHello{
    @Override
    public void speakHello() {
        System.out.println("Hello! How do you do? What a bloody lovely day.");
    }
}

class KindHello{
    public void lookHello(SpeakHello hello){
        hello.speakHello();
    }
}

public class Example6_6 {
    public static void main(String args[]){
        KindHello kindHello = new KindHello();
        Chinese chinese = new Chinese();
        English english = new English();

        kindHello.lookHello(chinese);
        kindHello.lookHello(new English());
        kindHello.lookHello(() -> {
            System.out.println("The coder says: No bug");
        });
    }
}
