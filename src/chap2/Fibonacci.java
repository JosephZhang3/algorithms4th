package chap2;

/**
 * 计算裴波那契数列第n个索引位置的值
 *
 * @author jianghao.zhang
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fi(5));
        System.out.println(fi(11));
    }

    static int fi(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fi(n - 1) + fi(n - 2);
        }
    }
}
