package chap1;

import util.StdIn;
import util.StdOut;

public class Excise1_1_1 {
    public static void main(String[] args) {
        System.out.println((0 + 15) / 2);//7

        System.out.println(2.0e-6 * 100000000.1);

        System.out.println(true && false || true && true);//always true

        System.out.println((1 + 2.236) / 2);//1.618  整数除以整数，商还是整数  带精度数除以整数，商还是带精度数

        System.out.println(1 + 2 + 3 + 4.0);///10.0 float

        System.out.println(4.1 >= 4);//true

        System.out.println(1 + 2 + "3");//33

        int c = '3';
        System.out.println(c);//51 输出的是字符的数值表示

        System.out.println(1 + 2 + '3');//54 字符'3'代表一个数值51


        /*int firstInt = StdIn.readInt();
        int secondInt = StdIn.readInt();
        int thirdInt = StdIn.readInt();
        if (firstInt == secondInt && firstInt == thirdInt) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }*/

        int a = 1, b = 1;
        int d = 1;
        if (a > b)
            d = 0;
        else
            b = 0;

        double x = 0, y = 1;
        if (x > 0 && x < 1 && y > 0 && y < 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        exercise1_1_6();
    }

    private static void exercise1_1_6() {
        //print 0 f=1 g=0
        //print 1 f=1 g=1
        //print 1 f=2 g=1
        //print 2 f=3 g=2
        //print 3 f=5 g=3
        //print 5 f=8 g=5
        //print 8 f=13 g=8
        //...
        int f = 0, g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }

        exercise1_1_7();

        System.out.println('b');
        System.out.println('b'+'c');//the result of plus is int
        char i = 'a'+4;//implicitly cast int to char
        System.out.println(i);//'e'
        System.out.println('a'+4);//101

        //todo 1.1.9
    }


    private static void exercise1_1_7() {
        //t=5
        //t=3.4
        //t=3.025
        //t=3.
        //t ?
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);

        //1+2+3+..+999 = (1+1000)*500 -1000 = 499500
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);

        //i=1 j 1次
        //i=2 j 2次
        //i=4 j 4次
        //i=8 j 8次
        //...
        //i=512 j 512次
        //sum=1+2+4+8+...+512=2的零次幂一直加到2的九次幂=？2的十次幂减一
        int sumtwo = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < i; j++) {
                sumtwo++;
            }
        }
        StdOut.println(sumtwo);
    }
}