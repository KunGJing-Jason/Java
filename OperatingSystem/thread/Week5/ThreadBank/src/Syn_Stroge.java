public class Syn_Stroge {
    int [] cells = new int[50];
    private int inPos, outPos,data;

    public synchronized void put(int num){
        while (inPos >= 50){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(inPos >= 50){
            inPos = 0;
        }else{
            cells[inPos++] = num;
            System.out.println(Thread.currentThread().getName()+"在cell["+inPos+"] 中写入数据 ---"+num);
        }
        notifyAll();
    }

    public synchronized void get(){
        while(inPos <=0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(outPos >= 50){
            outPos = 0;
        }else{
            data = cells[outPos++];
            inPos--;
            System.out.println(Thread.currentThread().getName() + "在cell[" + outPos + "]  中取出数据 ---" + data);
        }
        notifyAll();
    }
}
