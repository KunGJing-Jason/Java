package HM_2022_11_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class F_Application {
    public static void main(String[] args){
        String str = null;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        System.out.println("The average score is : " + getAvgScore(str));
    }
    public static double getAvgScore(String str){
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter("[^0123456789.]+"); //only number accepted by the regex expression
        double sum = 0;
        int count = 0;
        while (scanner.hasNext()){
            try{
                double score = scanner.nextDouble();
                sum += score;
                ++count;
            }catch(InputMismatchException se){
                String t = scanner.next();
            }
        }
        return (sum / count);
    }
}

