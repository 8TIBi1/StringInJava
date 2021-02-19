package CascadeCall;

// 级联调用的实现，就是在类中，使用return this这一句语句。
// 它可以实现跳出返回类型为MyCounter的当前调用的方法，从而进入类中的另一个方法中，
// 从而实现级联调用。
// 我的理解是，级联调用本质上，是同一个类中的多个方法的依次调用，即可以退出某一方法，从而调用另一个方法，再次调用同一个方法，
// 应该也是可行的。

public class CascadeCallClass {

    public static void main(String[] args) {
//        String str = "abc";
//        String result = str.trim().toUpperCase().concat("defg");

        MyCounter counter1 = new MyCounter(1);
        MyCounter counter2 = counter1.increase(100).decrease(2).increase(3);
        System.out.println("counter2.value(): " + counter2.value);

    }
}

class MyCounter {

    public int value;

    {
        value = 0;
    }

    public MyCounter(int value) {
        this.value = value;
    }

    public MyCounter increase(int number) {
        this.value += number;
        return this;
    }

    public MyCounter decrease(int number) {
        this.value -= number;
        return this;
    }
}