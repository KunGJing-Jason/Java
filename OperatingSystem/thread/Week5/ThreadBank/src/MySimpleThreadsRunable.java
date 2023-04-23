public class MySimpleThreadsRunable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(Thread.currentThread().getName() + "[" + j + "]  ");
            }
            System.out.println();
        }
        System.out.println("-----" + Thread.currentThread().getName() + " ends-----");
    }
}
