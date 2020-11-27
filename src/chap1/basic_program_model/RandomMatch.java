package chap1.basic_program_model;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomMatch {
    public static void main(String[] args) {
        int[] scaleArray = new int[]{(int) Math.pow(10, 3), (int) Math.pow(10, 4), (int) Math.pow(10, 5), (int) Math.pow(10, 6)};
        int T = StdIn.readInt();
        int[][] stat = new int[scaleArray.length][T];

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < scaleArray.length; j++) {
                int[] a = new int[scaleArray[j]];
                int[] b = new int[scaleArray[j]];
                for (int k = 0; k < a.length; k++) {
                    a[k] = StdRandom.uniform(scaleArray[j]);
                }

                for (int k = 0; k < b.length; k++) {
                    b[k] = StdRandom.uniform(scaleArray[j]);
                }

                stat[j][i] = findCount(a, b);
            }
        }

        for (int aScaleArray : scaleArray) {
            System.out.printf("%10d", aScaleArray);
        }
        System.out.println();

        for (int i = 0; i < scaleArray.length; i++) {
            int avg;
            int sumTemp = 0;
            for (int j = 0; j < T; j++) {
                sumTemp += stat[i][j];
            }
            avg = sumTemp / T;
            System.out.printf("%10d", avg);
        }
        System.out.println();
    }

    //find the count of common integer in two arrays
    private static int findCount(int[] a, int[] b) {
        int count = 0;
        for (int anA : a) {
            int position = BinarySearch.rankLoop(anA, b);
            if (position != -1) {
                count++;
            }
        }
        return count;
    }
}
