public class Syn_Input implements Runnable{
    private int num = 1;
    private Syn_Stroge stroge;

    Syn_Input(Syn_Stroge stroge){
        this.stroge = stroge;
    }

    public synchronized void run(){
        while(true){
            stroge.put(num++);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
