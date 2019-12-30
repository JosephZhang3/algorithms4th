package util;

import sort.InsertionSort;

/**
 * 主测试类，测试各种排序的性能
 */
public class Test {

    /**
     * 执行排序->断言检测->显示排序后结果
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] a = {"s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
//        String[] a = {"a", "c", "o", "s"};

//        sort(a);
        InsertionSort.enhancedSort(a);
        assert isSorted(a);
        show(a);

    }

    /**
     * 遍历数组中各个元素的值
     *
     * @param a
     */
    public static void show(Comparable[] a) {
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
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (Operate.less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
