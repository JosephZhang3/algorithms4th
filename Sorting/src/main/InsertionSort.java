package main;

import main.util.Operate;
import main.util.Test;

/**
 * 概述：插入排序
 * <p>
 * <p>详述：a[i]项与其左边的a[i-1]项对比，小于则交换值
 * a[i-1]与a[i-2]比较，小于则交换值
 * 依次进行
 * ...
 * a[1]与a[0]比较，小于则交换值
 * 这时，a[0] ~ a[i]的项就已被完全排序。
 * <p>
 * i从1开始自增1，travel from left to right，依次进行上面的操作，
 * 直到i=N-1这一次循环结束，整个数组就被完全排序了。
 *
 * @author zhangjianghao on 2018-09-05.
 */
public class InsertionSort {

    /**
     * 没有优化的插入排序
     *
     * @param a 输入数组
     */
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && Operate.less(a[j], a[j - 1]); j--) {
                Operate.exch(a, j, j - 1);

                Test.show(a);
            }
        }
    }

    /**
     * 优化后的插入排序
     *
     * @param a 输入数组
     */
    public static void enhancedSort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            Comparable cur = a[i];
            for (int j = i; j > 0; j--) {
                if (Operate.less(cur, a[j - 1])) {
                    a[j] = a[j - 1];
                    a[j - 1] = cur;
                }
            }
        }
    }


}
