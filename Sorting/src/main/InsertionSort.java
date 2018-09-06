package main;

/**
 * 概述：插入排序
 * <p>
 * <p>详述：
 *
 * @author zhangjianghao on 2018-09-05.
 */
public class InsertionSort {

    public static void sort(Comparable[] a) {
        int N = a.length;

    }

    /**
     * 如果a比b小，返回true
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean less(Comparable a, Comparable b) {
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
            System.out.println(anA + "\t");
        }
    }

    /**
     * 判断数组是否已经被从小到大正确排序
     *
     * @param a
     * @return
     */
    private static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
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
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
