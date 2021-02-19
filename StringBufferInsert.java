package StringBuffer;

public class StringBufferInsert {
    public static void main(String[] args) {
        var buffer = new StringBuffer();
        var origBuf = new StringBuffer();
        for(int num = 1; num <= 100; num++) {
            buffer.append(num);
            origBuf.append(num);
//            if(num < 100)
//                result = buffer.append('|');
            if(num < 100)
                buffer = insert(buffer, buffer.length() - 1, '|');
        }
//        buffer.append('1');
//        result = insert(buffer, 0, '|');
        System.out.println(origBuf);
        System.out.println(buffer);

    }


    /*
    *  insert实现思路：
    *
    *     先将需要插入位置pos及其之前的所有的StringBuffer里的内容存入到一个char[] preChar中，然后再将其重新转换为StringBuffe类型
    *     的preBuf，再利用StringBuffer本身的append方法，在preBuf后插入所需要的char类型字符（如'|'）。
    *
    *     与此同时，将原StringBuffer类型的buf，转换为char[]类型的tmpChar。
    *
    *     之后再将pos之后的原StringBuffer类型的buf的内容，利用StringBuffer自身的append方法，以及转换得到的tmpChar，
    *     依次插入到preBuf之后，最终得到的resBuf，即为插入相应字符后的StringBuffer。
    *
    *
    *
    */
    static StringBuffer insert(StringBuffer buf, int pos, char ch) {
        int len = buf.length();

        if(pos > len) {
            System.out.println("Position out of bound!");
        }

        String tmpString = buf.toString();
//        System.out.println("tmpString: " + tmpString);
        char[] tmpChar = tmpString.toCharArray();
//        for(int i = 0; i < tmpChar.length; i++) {
//            System.out.println("tmpChar[" + i + "]: " + tmpChar[i]);
//        }
        char[] preChar = new char[pos + 1];
        for(int i = 0; i <= pos; i++) {
            preChar[i] = tmpChar[i];
        }

//        for(int i = 0; i <= pos; i++) {
//            System.out.println("preChar[" + i + "]: " + preChar[i]);
//        }

        String preString = String.valueOf(preChar);
//        System.out.println("preString: " + preString);
        StringBuffer preBuf = new StringBuffer(preString);

        preBuf.append(ch);

        StringBuffer resBuf = preBuf;
        for(int i = pos + 1; i < len; i++) {
            resBuf.append(tmpChar[i]);
        }
//        System.out.println("resBuf: " + resBuf);
        return resBuf;
    }

}
