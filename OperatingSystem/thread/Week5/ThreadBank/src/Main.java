public class Main {
    public static void main(String[] args) {
        Syn_Stroge st = new Syn_Stroge();
        Syn_Input input = new Syn_Input(st);
        Syn_Output output = new Syn_Output(st);

        new Thread(input,"生产者").start();
        new Thread(output, "消费者").start();
    }

    void TestThreeSynchronized(){
        SaleThread saleThread = new SaleThread();
        new Thread(saleThread,"线程1").start();
        new Thread(saleThread,"线程2").start();
        new Thread(saleThread,"线程3").start();
        new Thread(saleThread,"线程4").start();
    }

    void TestOneExtendsThread(){
        Thread thread1 = new MySimpleThread();
        thread1.setName("T1");
        Thread thread2 = new MySimpleThread();
        thread2.setName("T2");
        thread1.start();
        thread2.start();
        System.out.println("====="+Thread.currentThread().getName()+" ends=====");
    }

    void TestTwoImplementRunnable(){
        MySimpleThreadsRunable mysr = new MySimpleThreadsRunable();
        Thread T1 = new Thread(mysr);
        Thread T2 = new Thread(new MySimpleThreadsRunable());
        T1.start();
        T2.start();
        System.out.println("====="+Thread.currentThread().getName()+" ends=====");
    }
    void SynchronizeInputAndOutout(){
        Stroge st = new Stroge();
        Input input = new Input(st);
        Output output = new Output(st);
        new Thread(input,"生产者").start();
        new Thread(output,"消费者").start();
    }
}

