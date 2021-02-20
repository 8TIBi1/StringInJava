package EmailCheck;

import java.util.Scanner;

public class EmailStringCheck {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your email address: ");

        var emailAdd = input.nextLine();
        EmailCheck(emailAdd);
    }

    static int EmailCheck(String address) {

        String output = "";
        final String atCh = "@";
        int atPos = 0;
        if(!address.contains(atCh)) {
            System.out.println("Lack of \"@\" !!!");
            output += "\"" + address + "\"" + " is not valid !!!";
            System.out.println(output);
            return -1;
        }
        else {
            atPos = address.indexOf(atCh);
        }

        if(atPos == 0) {
            System.out.println("Lack of prefix before \"@\" !!!");
            return -1;
        }

        // subString(left, right) 表示的区间为左闭右开区间：[left, right)
        String preStr = address.substring(0, atPos);

//        if(preStr == null) {
//            System.out.println("Lack of prefix before \"@\" !!!");
//        }

        char[] preChar = preStr.toCharArray();
        int[] check = new int[preChar.length];
        // ASCII表中，数字 0~9 对应的值为 48 ~ 57
        //           大写字母 A ~ Z 为 65 ~ 90
        //           小写字母 a ~ z 为 97 ~ 122
        for(int i = 0; i < preChar.length; i++) {
            if((preChar[i] >= 48 && preChar[i] <= 57) || (preChar[i] >= 65 && preChar[i] <= 90) || (preChar[i] >= 97 && preChar[i] <= 122)) {
                check[i] = 1;
            }
            else {
                check[i] = 0;
//                System.out.println("invalid: " + preChar[i]);
            }
        }

//        for(int i = 0; i < preChar.length; i++) {
//            System.out.println(preChar[i] + " " + check[i]);
//        }

        StringBuffer err = new StringBuffer("");
        for(int i = 0; i < preChar.length; i++) {
            if(check[i] == 0) {
                err.append("\"");
                err.append(preChar[i]);
                err.append("\"");
                err.append("、");
            }
        }
        err.deleteCharAt(err.length() - 1);

        if(!err.isEmpty()) {
            System.out.println(err + ": invalid characters ！！！");
            return -1;
        }

        String suffix = address.substring(atPos + 1);
        final String model = "bit.edu.cn";

        int postResult = suffix.compareTo(model);

        if(postResult == 0) {
            System.out.println("The address is valid !!!");
        }
        else {
            System.out.println("The suffix " + "\"" + suffix + "\"" + " is not matched with " + model + " !!!");
        }
        return 0;
    }

}
