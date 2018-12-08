package foundation;

/**
 * 二分查找算法，运用前提：输入的数据数组必须是已经排好序的
 */
public class BinarySearch {

    //用循环方式实现
    private static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;//中点
            System.out.println("首元素索引" + lo + "尾元素索引" + hi + "中点元素索引" + mid);

            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //用递归方式实现
    private static int rankRecursive(int key, int[] a, int lo, int hi) {

        int mid = lo + (hi - lo) / 2;//中点
        System.out.println("首元素索引" + lo + "尾元素索引" + hi + "中点元素索引" + mid);

        if (lo <= hi) {
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
            return rankRecursive(key, a, lo, hi);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 7, 8, 9, 11};
//        System.out.println(rank(8, a));
        System.out.println(rankRecursive(9, a, 0, a.length - 1));
    }
}
