package chap2.sort;

public class QuickSort3 {
    public static <T> void main(String[] args) {
        Comparable<T>[] a = new Comparable[]{'Q', 'U', 'I', 'C', 'K', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        sort(a, 0, a.length - 1);
        for (Comparable e : a) {
            System.out.printf("%s ", e);
        }
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {// 相遇，结束递归，整个数组已经排好序
            return;
        }
        int j = partition(a, lo, hi);// 分区包含交换过程，返回新切分点j
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;// while 中 --j 起步，所以需要 hi + 1
        Comparable v = a[lo];// 切分元素 why lo?为什么位置点取最左端？TODO
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;// 左指针右移到了最右
                }
            }
            while (less(v, a[--j])) {
//                if (j == lo) {
//                    break;// 右指针左移到了最左
//                }
            }
            if (i >= j) {// 区间大小变为1，仅有一个元素。对应 lo >= hi return 结束
                break;
            }
            exch(a, i, j);// a[i]比v大，a[j]比v小，所以交换a[i] a[j]
        }
        exch(a, lo, j);// 切分元素的值赋给j，j索引位置成为新的切分点 TODO 如何直观理解？
        return j;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int m, int n) {
        Comparable temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
}
