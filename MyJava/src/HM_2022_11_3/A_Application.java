package HM_2022_11_3;

import java.util.Scanner;

public class A_Application {
    public static void main (String[] ags){
        String str = null;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        System.out.println("The Toggle of "+str+" is :" + ToggleCase(str,str.length()));
    }

    static String ToggleCase(String str,int n){
        String ans = new String();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(Character.isLowerCase(c)){
                //Change into UpperCase then add by concat() with ans
                ans = ans.concat(String.valueOf(Character.toUpperCase(c)));
            }else{
                //Change into LowerCase then add by concat() with ans
                ans = ans.concat(String.valueOf(Character.toLowerCase(c)));
            }
        }
        return ans;
    }
}


