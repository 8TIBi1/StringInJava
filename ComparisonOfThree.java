package StringPerformanceComparison;

/*  参考博文地址：https://www.cnblogs.com/dolphin0520/p/3778589.html
*
*  比较String和StringBuffer，以及StringBuilder三者的性能，我暂且采用的是连接相同轮数的
*  相同字符串所用的时间，最终运行时间越短的，视作性能越好。
*
*  最终运行时间的大小，是Time(String) >> Time(StringBuffer) > Time(StringBuilder)
*
*  附上某一次的运行时间结果：
*
*  使用String程序运行时间：143ms
*  使用StringBuffer程序运行时间：6ms
*  使用StringBuilder程序运行时间：4ms
*
*  网络上的三者的大致使用场景的总结：
*
*  String适用于少量的字符串操作的情况
*  StringBuffer适用多线程下在字符缓冲区进行大量操作的情况
*  StringBuilder适用于单线程下在字符缓冲区进行大量操作的情况
*/

public class ComparisonOfThree {

    public static void main(String[] args) {

        testString();
        testStringBuffer();
        testStringBuilder();

    }

    static void testString() {

        String str = "";
        final int patches = 10000;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < patches; i++) {
            if(i < (patches - 1))
                str +=  "patch:" + (i + 1) + ", ";
            else str += "patch:" + (i + 1);
        }

        long endTime = System.currentTimeMillis();

//        System.out.println(str);
        System.out.println("使用String程序运行时间：" + (endTime - startTime) + "ms");

    }

    static void testStringBuffer() {

        StringBuffer strBuf = new StringBuffer("");

        final int patches = 10000;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < patches; i++) {
            if(i < (patches - 1)) {
                strBuf.append("patch:" + (i + 1) + ", ");
            }
            else strBuf.append("patch:" + (i + 1));
        }

        long endTime = System.currentTimeMillis();

//        System.out.println(strBuf);
        System.out.println("使用StringBuffer程序运行时间：" + (endTime - startTime) + "ms");

    }

    static void testStringBuilder() {

        StringBuilder stringBuilder = new StringBuilder("");

        final int patches = 10000;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < patches; i++) {
            if(i < (patches - 1)) {
                stringBuilder.append("patch:" + (i + 1) + ", ");
            }
            else stringBuilder.append("patch:" + (i + 1));
        }

        long endTime = System.currentTimeMillis();

//        System.out.println(stringBuilder);
        System.out.println("使用StringBuilder程序运行时间：" + (endTime - startTime) + "ms");

    }
}
