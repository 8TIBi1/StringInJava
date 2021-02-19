import java.awt.image.BufferedImage;
import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        System.out.println("Please enter original text: ");
        Scanner input = new Scanner(System.in);
        var origText = input.nextLine();
        System.out.println("Please enter the key: ");
        var key = input.nextInt();

        StringBuffer buffer = new StringBuffer(origText);
        StringBuffer cipherTxt = GetCipher(buffer, key);

        System.out.println("\nCipher: \n" + cipherTxt);

        StringBuffer plainTxt = ResolveCipher(cipherTxt, key);
        System.out.println("\nPlain: \n" + plainTxt);
    }


    static StringBuffer GetCipher(StringBuffer buf, int key) {

        final int mod = 26;
        int offset = key % mod;

        String tmpString = buf.toString();
        char[] tmpChar = tmpString.toCharArray();

        int len = buf.length();
        //ASCII表中，大写字母A~Z的值为65~90
        //          小写字母a~z的值为97~122
        // 也可以直接使用字符来进行操作，因为char可以接受整型数字来表示字符
        for(int i = 0; i < len; i++) {

            if(tmpChar[i] >= 'A' && tmpChar[i] <= 'Z') {
                if(tmpChar[i] <= 'Z' - offset) {
                    tmpChar[i] += offset;
                }
                else {
                    tmpChar[i] += (offset - mod);
                }
            }

            if(tmpChar[i] >= 'a' && tmpChar[i] <= 'z') {
                if(tmpChar[i] <= 'z' - offset) {
                    tmpChar[i] += offset;
                }
                else {
                    tmpChar[i] += (offset - mod);
                }
            }

        }

        String resString = String.valueOf(tmpChar);
        StringBuffer resBuf = new StringBuffer(resString);
//        System.out.println("resBuf: " + resBuf);

        return resBuf;
    }

    static StringBuffer ResolveCipher(StringBuffer buf, int key) {

        final int mod = 26;
        int offset = key % mod;

        String tmpString = buf.toString();
        char[] tmpChar = tmpString.toCharArray();

        int len = buf.length();

        for(int i = 0; i < len; i++) {

            if (tmpChar[i] >= 'A' && tmpChar[i] <= 'Z') {
                if (tmpChar[i] > 'A' + offset) {
                    tmpChar[i] -= offset;
                } else {
                    tmpChar[i] -= (offset - mod);
                }
            }

            if (tmpChar[i] >= 'a' && tmpChar[i] <= 'z') {
                if (tmpChar[i] > 'a' + offset) {
                    tmpChar[i] -= offset;
                } else {
                    tmpChar[i] -= (offset - mod);
                }
            }
        }

        String resString = String.valueOf(tmpChar);
        StringBuffer resBuf = new StringBuffer(resString);
//        System.out.println("resBuf: " + resBuf);

        return resBuf;
    }


}
