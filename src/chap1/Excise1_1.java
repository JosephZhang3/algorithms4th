package chap1;

import util.StdIn;
import util.StdOut;

/**
 * todo 练习1.1.25 数学归纳法证明
 */
public class Excise1_1 {
    public static void main(String[] args) {

        exercise1_1_1();

        exercise1_1_2();

        exercise1_1_3();

        exercise1_1_4();

        exercise1_1_5();

        exercise1_1_6();

        exercise_1_1_9();

        exercise_1_1_11();

        exercise_1_1_12();

        exercise_1_1_13();
    }

    private static void exercise1_1_1() {
        System.out.println((0 + 15) / 2);//7

        System.out.println(2.0e-6 * 100000000.1);

        System.out.println(true && false || true && true);//always true
    }

    private static void exercise1_1_2() {
        System.out.println((1 + 2.236) / 2);//1.618  整数除以整数，商还是整数  带精度数除以整数，商还是带精度数
        System.out.println(1 + 2 + 3 + 4.0);///10.0 float
        System.out.println(4.1 >= 4);//true
        System.out.println(1 + 2 + "3");//33

        int c = '3';
        System.out.println(c);//51 输出的是字符的数值表示
        System.out.println(1 + 2 + '3');//54 字符'3'代表一个数值51
    }

    private static void exercise1_1_3() {
        int firstInt = StdIn.readInt();
        int secondInt = StdIn.readInt();
        int thirdInt = StdIn.readInt();
        if (firstInt == secondInt && firstInt == thirdInt) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static void exercise1_1_4() {
        int a = 1, b = 1;
        int d = 1;
        if (a > b)
            d = 0;
        else
            b = 0;
    }

    private static void exercise1_1_5() {
        double x = 0, y = 1;
        if (x > 0 && x < 1 && y > 0 && y < 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
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
        System.out.println('b' + 'c');//the result of plus is int
        char i = 'a' + 4;//implicitly cast int to char
        System.out.println(i);//'e'
        System.out.println('a' + 4);//101
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

    private static void exercise_1_1_9() {
        String s = "";
        String s2 = Integer.toBinaryString(19);
        System.out.println(s2);

        for (int n = N; n > 0; n = n / 2) {
            s = n % 2 + s;
        }
        System.out.println(s);
    }

    /**
     * 打印二维布尔数组
     */
    private static void exercise_1_1_11() {
        int m = 3, n = 3;
        boolean[][] twoDimensionArray = new boolean[m][n];
        twoDimensionArray[0][0] = true;
        twoDimensionArray[0][1] = false;
        twoDimensionArray[0][2] = true;
        twoDimensionArray[1][0] = false;
        twoDimensionArray[1][1] = true;
        twoDimensionArray[1][2] = true;
        twoDimensionArray[2][0] = true;
        twoDimensionArray[2][1] = false;
        twoDimensionArray[2][2] = false;

        System.out.println("打印二维boolean数组：");

        System.out.print(" ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1);
        }
        for (int i = 0; i < m; i++) {
            System.out.println();
            System.out.print(i + 1);
            for (int j = 0; j < n; j++) {
                if (twoDimensionArray[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

        }
    }

    private static void exercise_1_1_12() {
        System.out.println();
        System.out.println("exercise_1_1_12");
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 打印M行N列的二维数组的reverse（exchange row with column）
     */
    private static void exercise_1_1_13() {
        int M = 3, N = 2;
        int[][] origin = {{7, 12}, {9, 8}, {8, 9}};

        System.out.println("-------------------");
        for (int j = N - 1; j >= 0; --j) {
            for (int i = 0; i < M; ++i) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.printf("%5d", origin[i][j]);
            }
            System.out.println();
            System.out.println("-------------------");
        }
    }

    private static void exercise_1_1_14() {
        System.out.println(2 ^ 4);
    }
}