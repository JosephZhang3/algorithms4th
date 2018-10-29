package main;

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

    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);

                show(a);
            }
        }
    }

    /**
     * 优化后的插入排序
     *
     * @param a
     */
    public static void enhancedSort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            Comparable cur = a[i];
            for (int j = i; j > 0; j--) {
                if (less(cur, a[j - 1])) {
                    a[j] = a[j - 1];
                    a[j - 1] = cur;
                }
            }
        }
    }

    /**
     * 如果a比b小，返回true
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean less(Comparable a, Comparable b) {
        System.out.println("比较次数");
        if (a != null) {

        }
        return a.compareTo(b) < 0;
    }

    /**
     * 交换数组中两个元素的值，两个元素的索引分别是i、j
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 遍历数组中各个元素的值
     *
     * @param a
     */
    private static void show(Comparable[] a) {
        for (Comparable anA : a) {
            System.out.print(anA + "\t");
        }
    }

    /**
     * 判断数组是否已经被从小到大正确排序
     *
     * @param a
     * @return
     */
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 主方法，排序->断言->显示排序后结果
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] a = {"s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
//        String[] a = {"a", "c", "o", "s"};

//        sort(a);
        enhancedSort(a);
        assert isSorted(a);
        show(a);

    }
}
