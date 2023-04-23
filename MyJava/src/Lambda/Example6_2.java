package Lambda;
interface ShowMessage{
    void ShowTradeMark(String s);
    //public void ShowHardware(String h);   //Lambda need all the void to override
}

interface ShowMessage2{
    void ShowTradeMark(int i);
}

public class Example6_2 {
    public static void main (String args[]){
        ShowMessage sm;
        sm = (s)->{
            System.out.println("tvtvtvtv");
            System.out.println(s);
            System.out.println("tvtvtvtv");
        };
        sm.ShowTradeMark("长城牌电视机");

        sm = (s) -> {
            System.out.println("pcpcpc");
            System.out.println(s);
            System.out.println("pcpcpc");
        };
        sm.ShowTradeMark("华为个人电脑");
    }
}
