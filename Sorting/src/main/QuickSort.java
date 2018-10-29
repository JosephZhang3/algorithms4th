package main;

import main.util.Operate;
import main.util.StdRandom;
import main.util.Test;

/**
 * 快速排序流行的原因
 * 1.实现起来简单
 * 2.适用于各种不同的输入数据
 * 3.在大多数普通应用中比气他排序算法都要快得多
 * <p>
 * 优点
 * 1.原地排序（只需要一个很小的辅助栈）
 * 2.时间复杂度为 O(nlgN)
 * 3.内循环比大多数排序算法都要短小
 * <p>
 * 缺点
 * 1.许多种错误都能使它的性能变成糟糕的 O(n^2)
 * <p>
 * 思想
 * 1.基于“分治”的思想，把一个数组分成两个子数组，再把两部分独立地排序，最后递归得到最终排好序的数组。
 * <p>
 * 回顾一下之前学习的归并排序，归并排序是将数组分成两个子数组分别排序，并将有序的子数组（只有两个元素，不能再分）归并从而将整个数组排序。
 * <p>
 * 而快速排序呢，当两个子数组都有序时，整个数组就自然地有序了。
 */
public class QuickSort {

    private static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)//递归的终结条件
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 把数组a切分
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (Operate.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (Operate.less(v, a[--j])) {
                if (j == lo) {--
                    break;
                }
            }
            if (i >= j) {
                break;
            }

            Operate.exch(a, i, j);
        }

        Operate.exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        String[] a = {"s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
        sort(a);
        assert Test.isSorted(a);
        Test.show(a);
    }
}
