package sort;

/**
 * 一个例子结构组织良好的排序类的示例，包含
 * 比较、交换、顺序验证、打印等子方法
 */
public class Example {

    public static void sort(Comparable[] a) {

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
     * 遍历打印数组中各个元素的值
     *
     * @param a
     */
    private static void show(Comparable[] a) {
        for (Comparable anA : a) {
            System.out.println(anA + "\t");
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
        assert isSorted(a);
        show(a);
    }
}
