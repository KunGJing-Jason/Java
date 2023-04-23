package Example7_1;

public class RedCowFarm {
    static String farmName;
    RedCow cow;
    RedCowFarm(){}
    RedCowFarm(String s){
        cow = new RedCow(150,112,5000);
        farmName = s;
    }
    public void showCowMess(){
        cow.speak();
    }
    static class RedCow{
        String cowName = "红牛";
        int height,weight,price;
        RedCow(int h, int w, int p){
           height = h;
           weight = w;
           price = p;
        }
        void speak(){
            System.out.println("偶是"+cowName+",身高："+height+"cm，体重："+weight+"kg，生活在："+farmName);
        }
    }
}
