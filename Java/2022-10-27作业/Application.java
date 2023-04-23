
import java.util.*;
public class Application {
    public static void main(String[] args){
        int score = 0, sum = 0, mount = 0;              //Variable to make the result

        Scanner score_scanner = new Scanner(System.in); //instance of Scanner to get the input

        while(!score_scanner.hasNext("-2")){    //pattern:-2, is the end of Input

            score = score_scanner.nextInt();          //to assignment score

            assert (score >= 0 && score <= 100): "非法输入！";   //Assertion : when the score is invalid

            sum +=score;                              //Make the count
            ++mount;                                  // amount of score
        }

        System.out.println("当前总成绩为："+sum);
        System.out.println("当前平均成绩为："+sum/mount);
    }
}




