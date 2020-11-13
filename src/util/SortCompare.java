package util;

import chap2.sort.InsertionSort;
import chap2.sort.SelectionSort;

import java.util.Random;

/**
 * 粗略比较排序算法的性能，只使用随机数，没有考虑特殊情况的输入
 */
public class SortCompare {

    private static double time(String alg, Comparable[] a) {
        long beginTime = System.nanoTime();
        if (alg.equals("Insertion")) {
            InsertionSort.sort(a);
        }
        if (alg.equals("Selection")) {
            SelectionSort.sort(a);
        }
        long endTime = System.nanoTime();
        return endTime - beginTime;
    }

    /**
     * 根据时间随机的输入
     *
     * @param alg 算法名称
     * @param N   输入规模
     * @param T   实验次数
     * @return 平均每次实验耗费的时间
     */
    private static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];//随机生成的数组
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = new Random().nextDouble();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        System.out.printf("对于输入规模 %d ， %s 比 %s 快 %.1f 倍", N, alg1, alg2, t2 / t1);
    }
}
