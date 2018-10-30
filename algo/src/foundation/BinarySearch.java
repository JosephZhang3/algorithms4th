package foundation;

/**
 * 二分查找算法，运用前提：输入的数据数组必须是已经排好序的
 */
public class BinarySearch {

    private static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
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

    public static void main(String[] args) {
        int[] a = {4, 7, 8, 9, 11};
        System.out.println(rank(8, a));
    }
}
