public class Stroge {
    private int[] cells = new int[50];
    private int inPos,outPos;
    public boolean ISOK = false;
    public void put(int num){
        cells[inPos] = num;
        System.out.println(Thread.currentThread().getName()+"在cell["+inPos+"] 中写入数据 ---"+num);
        inPos++;
        ISOK = true;
    }

    public void get() {
        int data = cells[outPos];
        System.out.println(Thread.currentThread().getName() + "在cell[" + outPos + "]  中取出数据 ---" + data);
        outPos++;
        if (outPos == cells.length)
            outPos = 0;
    }
}
