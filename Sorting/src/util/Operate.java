package util;

/**
 *
 */
public class Operate {

    /**
     * 如果a比b小，返回true
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean less(Comparable a, Comparable b) {
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
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
