package chap1.basic_program_model;

/**
 * 正确使用数组
 */
public class ArrayUsage {
    public static void main(String[] args) {

        double[] doubles = {0.7, 14.5, 5.6, 3.2};
        System.out.println(findMaxElementOfArray(doubles));

        for (double aCopy : duplicateArray(doubles)) {
            System.out.println(aCopy);
        }

        double[] copy = {};
        System.arraycopy(doubles,0,copy,0,doubles.length-1);
        for (double aCopy : copy) {
            System.out.println(aCopy);
        }
    }

    /**
     * 找出数组中最大的元素
     *
     * @param doubles
     * @return
     */
    private static double findMaxElementOfArray(double[] doubles) {
        double max = doubles[0];
        for (int i = 1; i < doubles.length; i++) {
            if (doubles[i] > max) {
                max = doubles[i];
            }
        }
        return max;
    }

    /**
     * 手工复制数组
     * @param doubles
     */
    private static double[] duplicateArray(double[] doubles) {
        double[] copy = new double[doubles.length];//开一个新的数组空间

        for (int i = 0; i < doubles.length; i++) {
            copy[i] = doubles[i];
        }
        return copy;
    }
}
