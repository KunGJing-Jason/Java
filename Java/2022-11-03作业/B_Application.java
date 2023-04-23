package HM_2022_11_3;

import java.util.Scanner;

public class B_Application {
    public static void main (String[] ags){
        String str = null;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        char first = str.charAt(0);                 //Get the first character
        char last = str.charAt(str.length() - 1);   //Get the last character
        System.out.println("The first character is :"+first+" .");
        System.out.println("The Last character is :"+last+" .");
    }
}


