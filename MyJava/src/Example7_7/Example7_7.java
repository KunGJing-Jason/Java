package Example7_7;

public class Example7_7 {
    public static void main(String[] args){
        int [] score = {-120, 98, 89, 120, 99};
        int sum = 0;
        for(int number:score){
            assert number > 0:"Negtive is not Allowed!";
            sum += number;
        }
        System.out.println("Score is :"+sum);
    }
}
