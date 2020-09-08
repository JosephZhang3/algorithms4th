package chap1.basic_program_model;

import util.In;
import util.StdIn;
import util.StdOut;

import java.util.Arrays;

/**
 * 二分查找算法，使用的前提：the data array gave must be 'ordered'
 */
public class BinarySearch {

    //用循环方式实现
    static int rankLoop(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;//中点
//            StdOut.println("首元素索引" + lo + "尾元素索引" + hi + "中点元素索引" + mid);

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
        StdOut.println("首元素索引" + lo + "，尾元素索引" + hi + "，中点元素索引" + mid);

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
     * <p>
     * 命令行编译运行指令
     * zhangjianghao@DESKTOP-B98UJS4 MINGW64 /c/git-repos/algorithm4th/src (master)
     * $ javac -encoding utf-8 ./chap1/basic_program_model/BinarySearch.java ./util/StdIn.java  ./util/In.java ./util/StdOut.java
     * Note: .\chap1\basic_program_model\BinarySearch.java uses or overrides a deprecated API.
     * Note: Recompile with -Xlint:deprecation for details.
     * <p>
     * zhangjianghao@DESKTOP-B98UJS4 MINGW64 /c/git-repos/algorithm4th/src (master)
     * $ java chap1.basic_program_model.BinarySearch ./chap1/basic_program_model/tinyW.txt  -
     * ȥ▒غ▒▒▒▒▒▒Ԫ▒▒Ϊ   34      435     54645   34534547        34534547        34534547        223423423       0       0
     *
     * @param args args
     */
    public static void main(String[] args) {


        //练习1.1.129 等值键
        int[] a = {0, 1, 3, 5, 7, 9, 9, 9, 13, 24, 35, 35, 35, 44, 59, 79};
        int keyy = 9;
        int q = rank(keyy, a);
        int p = count(keyy, a);
        StdOut.print("与key " + keyy + "等值的元素索引分别是 ");
        for (int m = q; m >= q && m <= q + p - 1; m++) {
            StdOut.print(m + "\t");
        }
        StdOut.println();


        //循环非递归方式实现binarysearch
//        int[] a = {4, 7, 8, 9, 11, 23};
//        StdOut.println(rankLoop(8, a));
        //StdOut.println("查找匹配元素索引" + rankRecursive(9, a, 0, a.length - 1));


        int[] whiteList = In.readInts(args[0]);//从文件中读取整数
        String param = args[1];//控制台打印选项开关
        Arrays.sort(whiteList);


        //练习1.1.28 删除白名单中所有重复元素
        int[] occurredArray = new int[whiteList.length];
        int nowIndex = 0;
        for (int i : whiteList) {
            boolean occurredFlag = false;
            for (int anOccurredArray : occurredArray) {
                if (i == anOccurredArray) {
                    occurredFlag = true;
                }
            }
            if (!occurredFlag) {
                occurredArray[nowIndex] = i;
                ++nowIndex;
            }
        }
        whiteList = occurredArray;
        StdOut.print("去重后白名单元素为\t");
        for (int i : whiteList) {
            StdOut.print(i + "\t");
        }
        StdOut.println();
        //练习1.1.28 ... 代码结束


        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int resultIndex = rankRecursive(key, whiteList, 0, whiteList.length);
            //add 练习1.1.23 参数+打印出标准输入中不在白名单上的值；-，则打印出标准输入在白名单上的值
            if (resultIndex == -1) {
                if ("+".equals(param)) {
                    StdOut.println(key);//不在白名单上的整数（非法输入）
                }
            } else {
                if ("-".equals(param)) {
                    StdOut.print(whiteList[resultIndex]);
                }
                StdOut.println("    matched");
            }
        }
    }

    private static int rank(int key, int[] a) {
        int num = 0;
        for (int i : a) {
            if (i < key) {
                ++num;
            }
        }
        return num;
    }

    private static int count(int key, int[] a) {
        int num = 0;
        for (int i : a) {
            if (i == key) {
                ++num;
            }
        }
        return num;
    }
}
