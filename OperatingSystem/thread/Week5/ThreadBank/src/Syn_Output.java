public class Syn_Output implements Runnable {
    private Syn_Stroge stroge;
    private int count = 1;

    Syn_Output(Syn_Stroge stroge){
        this.stroge = stroge;
    }

    public synchronized void run(){
        while(true){
            stroge.get();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
