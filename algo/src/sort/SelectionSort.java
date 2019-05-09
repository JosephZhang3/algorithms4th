package sort;

import util.*;

/**
 * 概述：选择排序
 * <p>
 * <p>详述：最简单的排序算法之一
 * 首先，找到数组中最小的项，并且把它同第一项交换。
 * 接下来，（从排除第一项后的其它项中）找到下一个最小的项，把它同第二项交换。
 * 依次确定最小的项，第二小的项，第三小的项 ...-> 最大的项
 * 以这种方式继续，直到整个数组被排序。
 * <p>
 * 这种方法被称作选择排序，因为它通过反复地选取最小的剩余项来工作。
 * <p>
 * 若有N个项待排序，则需要(N-1)+(N-2)+...+2+1 = (N-1+1)(N-1)/2 次比较操作
 *
 * @author zhangjianghao on 2018-09-05.
 */
public class SelectionSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int min = i;//（当前已寻到的）最小项的下标
            for (int j = i + 1; j < N; j++) {
                if (Operate.less(a[j], a[min])) {
                    min = j;//每次寻到更小项，就更新当前最小项下标
                }

                System.out.println(++count);//11个项，55次less()调用
            }
            Operate.exch(a, i, min);
        }
    }

    /**
     * 主方法，排序->断言->显示排序后结果
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] a = {"s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
        sort(a);
        assert Test.isSorted(a);
        Test.show(a);
    }
}
