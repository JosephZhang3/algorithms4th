package chap1.basic_program_model;

/**
 * 二分查找算法，使用的前提：the data array gave must be 'ordered'
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

        int mid = lo + (hi - lo) / 2;//中点索引，始终会是一个正整数或者零！
        System.out.println("首元素索引" + lo + "，尾元素索引" + hi + "，中点元素索引" + mid);

        if (lo <= hi) {//新搜索起点或终点都是正常（在界内）
            if (key < a[mid]) {
                //因为要查找的key元素比mid索引及之后位置的元素都要小，所以新的搜索终点变成mid - 1
                hi = mid - 1;
            } else if (key > a[mid]) {
                //因为要查找的key元素比mid索引及之前位置的元素都要大，所以新的搜索起点变成mid + 1
                lo = mid + 1;
            } else {
                //要查找的key元素和mid索引一样大，搜索命中返回
                return mid;
            }
            return rankRecursive(key, a, lo, hi);
        } else {/* 理解： lo > hi 即选取的新搜索起点或终点已经越界， */
            return -1;
        }
    }

    /**
     * 测试
     *
     * @param args args
     */
    public static void main(String[] args) {
        int[] a = {4, 7, 8, 9, 11, 23};
//        System.out.println(rank(8, a));
        System.out.println("查找匹配元素索引" + rankRecursive(9, a, 0, a.length - 1));
    }
}
