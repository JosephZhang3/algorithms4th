package chap1.basic_program_model;

import edu.princeton.cs.algs4.StdIn;

/**
 * 计算标准输入给出的数的平均数
 * Ctrl +D 结束输入
 */
public class StandardInputTest {

    public static void main(String[] args) {
        double sum = 0;
        int cnt = 0;
        while (!StdIn.isEmpty()) {
            sum += StdIn.readDouble();
            cnt++;
        }
        System.out.printf("Average is %.2f", sum / cnt);
    }
}
