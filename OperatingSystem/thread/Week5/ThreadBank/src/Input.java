public class Input implements Runnable{
    private Stroge st;
    private int num = 1;
    Input(Stroge st){
        this.st = st;
    }

    public synchronized void run(){
        while (true){
            if(num <= 50){
                st.put(num++);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                st.ISOK = true;
                this.notify();
                break;
            }
        }
    }
}
