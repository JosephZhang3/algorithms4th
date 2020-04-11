package chap1.basic_program_model;

import util.StdIn;
import util.StdOut;
import util.StdRandom;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static java.math.RoundingMode.FLOOR;
import static java.math.RoundingMode.HALF_UP;

public class Excise1_1 {

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

        for (int n = 19; n > 0; n = n / 2) {
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
        System.out.println(lg(129));
    }

    private static int lg(int N) {
        if (N < 1) {
            throw new IllegalArgumentException("N必须是不小于1的正实数");
        }

        int i = 0;
        while (N > 1) {
            N = N / 2;
            ++i;
        }
        return i;//2的i次幂小于等于N
    }

    private static void exercise_1_1_15() {
        int[] r = histogram(new int[]{1, 2, 3, 1, 1, 3, 3, 3, 3, 11, 12}, 3);
        for (int i : r) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    private static int[] histogram(int[] a, int M) {
        int[] r = new int[M];

        //要求：返回数组r，数组r中第i个元素的值为整数i在参数数组a中出现的次数，
        // 如果数组a中的值均在0到M-1之间，返回的数组r中所有元素之和应该和a.length相等

        for (int i = 0; i < M; i++) {
            //本质就是计算整数i+1在数组a中出现的次数
            int times = 0;
            for (int anA : a) {
                if (anA == i + 1) {
                    times++;
                }
            }
            r[i] = times;
        }

        return r;
    }

    private static void exercise_1_1_16() {
        String r = exR1(6);
        System.out.println(r);
    }

    private static String exR1(int n) {
        if (n <= 0) {
            return "";
        }

        return exR1(n - 3) + n + exR1(n - 2) + n;
    }


    private static void exercise_1_1_18() {
//        System.out.println(mystery(2, 25));
//        System.out.println(mystery(3, 31));
//        System.out.println(mystery(8, 80));

        System.out.println(mysteryV2(2, 25));
        System.out.println(mysteryV2(3, 11));
        System.out.println(mysteryV2(8, 80));
    }

    private static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        }

        return mystery(a + a, b / 2) + a;
    }

    private static int mysteryV2(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return mysteryV2(a * a, b / 2);
        }

        return mysteryV2(a * a, b / 2) * a;
    }

    public static void exercise_1_1_19() {
        for (int i = 0; i < 100; i++) {
//            System.out.println("N " + fibonacci_recursive(i));
            System.out.println("N " + fibonacci_cache(i));
        }
    }

    /**
     * 递归算法非常慢，因为随着N增加，计算次数增长速度越来越快
     *
     * @param N
     * @return
     */
    private static int fibonacci_recursive(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fibonacci_recursive(N - 1) + fibonacci_recursive(N - 2);
    }

    private static int fibonacci_cache(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        //使用数组保存中间计算结果，最后返回一个保存fibonacci数列的数组
//        int[] cache = new int[N];
//        cache[0] = 0;
//        cache[1] = 1;
//
//        for (int i = 2; i < N; i++) {
//            cache[i] = cache[i - 2] + cache[i - 1];
//        }
//        return cache;


        //不保存中间计算结果，返回一个指定位置的fibonacci数
        int prepre = 0;
        int pre = 1;
        int temp = 0;
        for (int i = 2; i < N; i++) {
            temp = prepre + pre;
            prepre = pre;
            pre = temp;
        }
        return temp;
    }

    private static void exercise_1_1_20() {
        System.out.println(Math.log1p(calaculateFactorial(6) - 1));
    }

    private static int calaculateFactorial(int n) {
        if (n == 1) {
            return n;
        }
        return n * calaculateFactorial(n - 1);
    }

    public static void exercise_1_1_21() {
        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            String[] members = line.split(" ");
            int hit = Integer.parseInt(members[1]);
            int all = Integer.parseInt(members[2]);
            BigDecimal rate = new BigDecimal(hit).divide(new BigDecimal(all), 3, HALF_UP);//四舍五入保留3位小数
            System.out.println(members[0] + "\t" + members[1] + "\t" + members[2] + "\t" + rate.toString());
        }
    }

    private static void exercise_1_1_22() {
        int[] a = {2, 6, 7, 13, 45, 87, 109, 202, 444, 1098, 4567};
        int key = 45;
        int val = binarySerachRecursive(a, 0, a.length, key, 0);
        if (val == -1) {
            System.out.println("未在数组a中找到数" + key);
        } else {
            System.out.println("数" + key + "在数组a中的位置是" + val);
        }
    }

    private static int binarySerachRecursive(int[] a, int lo, int hi, int key, int deepth) {

        int mid = (lo + hi) >>> 1;

        if (lo <= hi) {
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        } else {
            return -1;//fail
        }

        deepth++;
        for (int i = 0; i < deepth; i++) {
            System.out.print("  ");
        }
        System.out.println(lo + "+" + hi);

        return binarySerachRecursive(a, lo, hi, key, deepth);
    }

    private static void exercise_1_1_24() {
        int p = 1111111;
        int q = 1234567;
        System.out.println("p和q的最大公约数是" + euclid(p, q));
    }

    private static int euclid(int p, int q) {
        System.out.printf("%s%20d%s%20d", "p", p, "\t\tq", q);
        System.out.println();

        if (p <= 0 || q <= 0) {
            throw new IllegalArgumentException("要求输入值是正整数");
        }

        if (p < q) {
            int temp = p;
            p = q;
            q = temp;
        }
        int val = p % q;
        if (val == 0) {
            return q;
        }

        return euclid(q, val);
    }

    //todo 练习1.1.25 使用数学归纳法证明Euclid算法，以及，求Euclid算法最时概率是否吻合？的时间复杂度 https://www.zhihu.com/question/35133122


    private static void exercise_1_1_27() {
//        System.out.println(binomial(100,50,0.25));
        System.out.println(binomialCache(100, 50, 0.25));
    }

    private static double binomial(int n, int k, double p) {
        if (n == 0 && k == 0) {
            return 1.0;
        }
        if (n < 0 || k < 0) {
            return 0.0;
        }
        return (1.0 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);
    }

    private static double binomialCache(int n, int k, double p) {
        if (n == 0 && k == 0) {
            return 1.0;
        }
        if (n < 0 || k < 0) {
            return 0.0;
        }

        double[][] cache = new double[n][k];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k; j++) {
                if (i == 1) {
                    cache[i][j] = 1;
                    System.out.printf("cache[%d][%d] = 1\n", i, j);
                } else if (j == 1) {
                    cache[i][j] = (1.0 - p) * cache[i - 1][j];
                    System.out.printf("cache[%d][%d] = (1.0 - %f) * cache[%d-1][%d]\n", i, j, p, i, j);
                } else {
                    cache[i][j] = (1.0 - p) * cache[i - 1][j] + p * cache[i - 1][j - 1];
                    System.out.printf("cache[%d][%d] = (1.0 - %f) * cache[%d-1][%d] + %f * cache[%d-1][%d-1]\n", i, j, p, i, j, p, i, j);
                }
                System.out.printf("cache[%d][%d] = %.20f\n", i, j, cache[i][j]);
            }
        }

        return cache[n - 1][k - 1];
    }

    private static void exercise_1_1_30() {
        boolean[][] a = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 || j == 0) {
                    a[i][j] = true;
                } else {
                    a[i][j] = euclid(i, j) == 1;
                }
            }
        }
        System.out.println("breakpoint");
    }

    //todo 不会做这一题，直接看解答吧
    public static void exercise_1_1_31() {
        int n = StdIn.readInt();
        double p = StdIn.readDouble();

//        StdDraw.
    }

    private static void exercise_1_1_32() {
        int n = StdIn.readInt();
        double[] ds = StdIn.readAllDoubles();
        double l = ds[0];//区间起点
        double r = ds[1];//区间终点

        double per = (r - l) / n;
        double begin = l;
        double end;
        int[] hitNums = new int[n];
        for (int i = 0; i < n; i++) {
            end = l + (i + 1) * per;
            int hitNum = 0;
            for (double d : ds) {
                if (d == l || d == r) {
                    continue;
                }
                if (d >= begin && d < end) {
                    ++hitNum;
                }
            }
            hitNums[i] = hitNum;
            begin = end;
        }

        int x = 0;
        for (int i = 0; i < n; i++) {
            //todo 无法使用画图工具            x += per / 2;
        }
    }

    //todo 矩阵计算不会，回去补线性代数课程，谁让你当初挂科。。。
    private static void exercise_1_1_33() {

    }

    private static void exercise_1_1_34() {

//        /**
//         * 打印出最大和最小的数，不需要保存输入的所有值
//         */
//        int max = 0, min = 0;
//        boolean isFirst = true;
//        while (!StdIn.isEmpty()) {
//            int i = StdIn.readInt();
//
//            if (isFirst) {
//                max = i;
//                min = i;
//                isFirst = false;
//                continue;
//            }
//
//            if (i > max) {
//                max = i;
//            }
//            if (i < min) {
//                min = i;
//            }
//        }
//        System.out.printf("最大的数是%d，最小的数是%d\n", max, min);


        /**
         * 打印出所有数的中位数，不需要保存输入的所有值
         *//*
        int sum = 0;
        int count = 0;
        while (!StdIn.isEmpty()) {
            ++count;
            sum += StdIn.readInt();
        }
        StdOut.printf("所有数的中位数是%d\n", sum / count);*/


        /**
         //the k-th largest number，打印出第k小的数，设k等于26
         int k = 5;
         int[] foo = new int[k];
         int index = 0;
         while (!StdIn.isEmpty()) {
         int inNUm = StdIn.readInt();

         if (index < k) {
         foo[index] = inNUm;
         ++index;
         continue;
         }
         //保证foo数组中保存的始终是前k大的数（每当读取的数比遍历数组到的数小，就替换）
         for (int i = 0; i < k; i++) {
         if (inNUm < foo[i]) {
         foo[i] = inNUm;
         break;
         }
         }
         }
         int max = foo[0];
         for (int aFoo : foo) {
         if (aFoo > max) {
         max = aFoo;
         }
         }
         System.out.println("第" + k + "大的数是\t" + max);
         */


        /*
        //打印出大于平均值的数的百分比
        int N = 50;
        int[] all = new int[N];
        int sum = 0;
        int count = 0;
        while (!StdIn.isEmpty()) {
            if (count == N) {
                break;//最多输入50个数
            }
            int temp = StdIn.readInt();
            all[count] = temp;
            sum += temp;
            ++count;
        }
        int largerCount = 0;
        assert count != 0;
        int avg = sum / count;
        for (int i : all) {
            if (i > avg) {
                ++largerCount;
            }
        }
        System.out.println("大于平均值的数的百分比\t" +
                new BigDecimal(largerCount).divide(new BigDecimal(count), 3, BigDecimal.ROUND_HALF_UP));
                */


        /**
         //冒泡排序（升序打印），对于输入规模N，时间复杂度为(N-1) + (N-2) + ... + 3 + 2 + 1 = N(N - 1)/2
         //去掉系数和低幂次项，时间复杂度为N的二次幂
         int N = 50;
         int[] all = new int[N];
         int i = 0;
         while (!StdIn.isEmpty()) {
         all[i] = StdIn.readInt();
         ++i;
         }

         int complex = 0;
         for (int j = i; j > 0; j--) {
         for (int k = 0; k < j - 1; k++) {
         complex++;
         if (all[k] > all[k + 1]) {
         int temp = all[k + 1];
         all[k + 1] = all[k];
         all[k] = temp;
         }
         }
         }

         for (int anAll : all) {
         System.out.print(anAll + "\t");
         }
         System.out.println();
         System.out.println("复杂度" + complex);
         */


        /**
         //随机顺序打印
         int N = 50;
         int[] all = new int[N];
         int i = 0;
         while (!StdIn.isEmpty()) {
         all[i] = StdIn.readInt();
         ++i;
         }
         int[] copy = new int[i];
         for (int j = 0; j < i; j++) {
         copy[j] = all[j];
         }

         StdRandom.shuffle(copy);
         for (int anAll : copy) {
         System.out.print(anAll + "\t");
         }
         */
    }

    public static void main(String[] args) {

//        exercise_1_1_39();//see in RandomMatch.java

        /*

        exercise_1_1_35();

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

        exercise_1_1_14();

        exercise_1_1_15();

        exercise_1_1_16();

        exercise_1_1_18();

        exercise_1_1_19();

        exercise_1_1_20();

        exercise_1_1_21();

        exercise_1_1_22();

        exercise_1_1_24();

        exercise_1_1_27();

        exercise_1_1_30();

        exercise_1_1_32();

        exercise_1_1_34();
        */

    }

    /**
     * 每种两个骰子之和的准确概率分布
     */
    private static void exercise_1_1_35() {

        double[] e = exactProbability();
        double[] n100 = nTimesDice(100);
        double[] n1000 = nTimesDice(1000);
        double[] n10000 = nTimesDice(10000);
        double[] n100000 = nTimesDice(100000);
        double[] n1000000 = nTimesDice(1000000);
        double[] n10000000 = nTimesDice(10000000);
        double[] n100000000 = nTimesDice(100000000);

        try {
            System.out.println("N为100时概率是否吻合？：   " + compareDegreeOfSimilarity(e, n100));
            System.out.println("N为1000时概率是否吻合？：   " + compareDegreeOfSimilarity(e, n1000));
            System.out.println("N为10000时概率是否吻合？：   " + compareDegreeOfSimilarity(e, n10000));
            System.out.println("N为100000时概率是否吻合？：   " + compareDegreeOfSimilarity(e, n100000));
            System.out.println("N为1000000时概率是否吻合？：   " + compareDegreeOfSimilarity(e, n1000000));
            System.out.println("N为10000000时概率是否吻合？：   " + compareDegreeOfSimilarity(e, n10000000));
            System.out.println("N为100000000时概率是否吻合？：   " + compareDegreeOfSimilarity(e, n100000000));
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    /**
     * 比较两个 和概率数组内容 的相似度 吻合程度达到小数点后3位
     *
     * @param e
     * @param n
     * @return
     * @throws Exception
     */
    private static boolean compareDegreeOfSimilarity(double[] e, double[] n) throws Exception {
        if (e.length != n.length) {
            throw new Exception("长度不等");
        }
        boolean similar = true;
        for (int i = 2; i < e.length; i++) {
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(3);
            df.setGroupingSize(0);
            df.setRoundingMode(FLOOR);
            if (!df.format(e[i]).equals(df.format(n[i]))) {
                similar = false;
            }
        }
        return similar;
    }

    /**
     * 计算准确概率
     *
     * @return
     */
    private static double[] exactProbability() {
        double[] p = new double[2 * 6 + 1];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                p[i + j] += 1.0;
            }
        }

        for (int i = 2; i <= 2 * 6; i++) {
            p[i] /= 6 * 6;
        }

        for (int i = 2; i < 2 * 6 + 1; i++) {
            System.out.printf("投资和%d出现的概率为" + p[i] + "\n", i);
        }
        return p;
    }

    /**
     * 模拟N次掷骰（tou 第三声）子实验，一个骰子的点数为1到6，得到经验概率
     *
     * @param N
     */
    private static double[] nTimesDice(int N) {
        double[] p = new double[2 * 6 + 1];
        for (int i = 0; i < N; i++) {
            p[StdRandom.uniform(1, 7) + StdRandom.uniform(1, 7)] += 1.0;
        }

        for (int i = 2; i < 2 * 6 + 1; i++) {
            p[i] /= N;
        }

        for (int i = 2; i < 2 * 6 + 1; i++) {
            System.out.printf("投资和%d出现的概率为" + p[i] + "\n", i);
        }
        return p;
    }

}