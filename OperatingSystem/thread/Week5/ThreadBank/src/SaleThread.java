public class SaleThread implements Runnable{
    private int tickets = 10;
    public void run(){
        synchronized (this) {
            while (tickets > 0) {
                try {
                    this.notify();
                    Thread.sleep(10);
                } catch (InterruptedException se) {
                    se.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "--卖出的票" + tickets--);
                if(tickets != 0){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    System.out.println("票已售完！");
                    break;
                }
            }
        }
    }
}
