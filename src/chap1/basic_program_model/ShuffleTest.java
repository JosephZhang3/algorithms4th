package chap1.basic_program_model;

import util.StdIn;
import util.StdOut;
import util.StdRandom;

public class ShuffleTest {

    public static void main(String[] args) {
        int count = 2;
        int M = 0, N = 0;
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            StdOut.println("从命令行接收到：" + key);
            if (count == 2) {
                M = key;
            }
            if (count == 1) {
                N = key;
            }
            count--;
            if (count < 1) {
                break;
            }
        }

        int[] a = new int[M];
        int[][] recorder = new int[M][M];

        for (int i = 0; i < N; i++) {
            reOrderAndShuffle(a);
            recordPositionTimes(a, recorder);
        }

        //print dealing result
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(recorder[i][j] + "\t");
            }
            System.out.println();
        }

    }

    /**
     * 重排序数组然后将其元素顺序打乱
     *
     * @param a int array
     */
    private static void reOrderAndShuffle(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        StdRandom.shuffle(a);
    }

    /**
     * 记录元素 a[i] 在第 i 个索引位置出现的次数
     *
     * @param a        int array
     * @param recorder 记录结果的二维数组
     */
    private static void recordPositionTimes(int[] a, int[][] recorder) {
        for (int i = 0; i < a.length; i++) {
            recorder[a[i]][i]++;
        }
    }
}
