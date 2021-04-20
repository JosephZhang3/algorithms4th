package chap2.sort;

public class QuickSort2 {
    static void quickSort(int[] arr, int l, int r) {
        // 区间仅包含一个元素时，停止递归
        if (l >= r) {
            System.out.printf("l = %d, r = %d 时终止\n", l, r);
            return;
        }

        int key = arr[l];
        int keyIdx = l;
        for (int i = l + 1; i < r; i++) {
            if (arr[i] < key) {
                // 交换 q[i] 和 q[keyIdx + 1] TODO
                keyIdx++;
                int t = arr[keyIdx];
                arr[keyIdx] = arr[i];
                arr[i] = t;
            }
        }

        arr[l] = arr[keyIdx];
        arr[keyIdx] = key;

        // 轴心点左区间递归
        quickSort(arr, l, keyIdx);
        // 轴心点右区间递归
        quickSort(arr, keyIdx + 1, r);
    }

    public static void main(String[] args) {
        int[] q = {23, 4, 2, 54, 565, 34};
        quickSort(q, 0, q.length);
        for (int i : q) {
            System.out.println(i);
        }
    }
}
