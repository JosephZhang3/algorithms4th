package chap3.BST;

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

//    public int size() {
//        return size(root);
//    }

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
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * value allowed to be null,but key can not
     *
     * @param x 每次遍历到的结点
     * @param key 结点键
     * @param value 结点值
     * @return 匹配的结点
     */
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        //update node count
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

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

        System.exit(0);
    }

}
