package test;

import chap3.BST.BSTApiImpl;

public class BstTest {
    public static void main(String[] args) {
        BSTApiImpl<Integer, String> bst = new BSTApiImpl<>();
        bst.put(32, "32");
        bst.put(1, "1");
        bst.put(6, "6");
        bst.put(10, "10");
        bst.put(4, "4");
        bst.put(22, "22");
        bst.put(2, "2");
        bst.put(34, "34");

        System.out.println(bst.get(10));
        System.out.println(bst.get(2));

        System.out.print("min is ");
        System.out.println(bst.min());
        System.out.print("max is ");
        System.out.println(bst.max());

        System.out.print("向下取整：");
        System.out.println(bst.floor(9));
        System.out.print("向上取整：");
        System.out.println(bst.ceiling(9));

        System.out.print("排名第4的key为 ");
        System.out.println(bst.select(4));

        System.exit(0);
    }
}
