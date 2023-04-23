public class Output implements Runnable{
    private Stroge st;
    private int count = 1;
    Output(Stroge st){
        this.st = st;
    }
    public synchronized void run(){
        while (true){
            if(st.ISOK && count <=50){
                st.get();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
            }else{
                this.notify();
            }
            if(count > 50){
                break;
            }
        }
    }
}
