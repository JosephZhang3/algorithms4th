package chap3.BST;

import java.util.Map;
import java.util.TreeMap;

public class BSTApiImpl<Key extends Comparable<Key>, Value> implements BSTApi<Key, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;//结点计数器，存储以该结点为根的子树中的结点总数

        Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {//empty tree
            return 0;
        }
        return x.N;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        if (x.key.compareTo(key) < 0) {
            get(x.right, key);
        } else if (x.key.compareTo(key) > 0) {
            get(x.left, key);
        }
        return x.value;
    }

    @Override
    public void put(Key key, Value value) throws Exception {
        if (root == null) {
            root = new Node(key, value, 1);
        } else {
            put(root, key, value);
        }
    }

    /**
     * value allowed to be null,but key can not
     *
     * @param x
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    private Node put(Node x, Key key, Value value) throws Exception {
        //if two key equals then replace original value
        if (x.key.compareTo(key) == 0) {
            x.value = value;
        }

        // TODO: 4/13/2020 calculate N
        if (x.key.compareTo(key) > 0) {
            if (x.left == null) {
                x.left = new Node(key, value, 1);
                return x.left;
            }
            put(x.left, key, value);
        }
        if (x.key.compareTo(key) < 0) {
            if (x.right == null) {
                x.right = new Node(key, value, 1);
                return x.right;
            }
            put(x.right, key, value);
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> m = new TreeMap<>();
        m.put("dsf", null);
//        m.put(null, "324");
//        System.out.println(m.get(null));

        BSTApiImpl<Integer, String> bst = new BSTApiImpl();
        bst.put(32, "32");
        bst.put(1, "1");
        bst.put(6, "6");
        bst.put(10, "10");
        bst.put(4, "4");
        bst.put(22, "22");
        bst.put(2, "2");
        bst.put(34, "34");
    }

}
