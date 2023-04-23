package HM_2022_11_3;

import java.util.Scanner;

public class E_Application {
    public static void main(String[] args) {
        String str = null;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        String regex = "[a-zA-z]";
        System.out.println(str + "去掉字母为：" + str.replaceAll(regex,""));
    }
}

