package chap3.BST;

/**
 * 二叉查找树的递归实现
 *
 * @param <Key>
 * @param <Value>
 */
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

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        // 节点计数器的值就是子树的节点个数
        return x.N;
    }

    /**
     * 查找命中平均所需的比较次数为 1.39lgN ，查找未命中仅需要多一次额外的比较
     *
     * @param key 键
     * @return 匹配结点的值
     */
    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        //取到空节点时，说明已经到达末端，结束递归
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            //如果查找命中，直接return值。如果未命中，最后还得再进一步递归get方法至遇到树末端null结点
            return x.value;
        }
    }

    /**
     * 替换现有结点的值平均所需的比较次数为 1.39lgN ，添加新结点仅需要多一次额外的比较
     *
     * @param key   待插入的键
     * @param value 待插入的值
     */
    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * value 可以为 null，但是 key 不可以
     *
     * @param x     每次遍历到的结点
     * @param key   结点键
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
            x.value = value;//如果待插入键已存在，直接替换此结点值。如果不存在，则变成添加结点的情况，需要多一次递归至遇到树末端null结点
        }

        //update node count
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    /**
     * 查找树中最小键
     *
     * @return it
     */
    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    /**
     * 查找树中最大键
     *
     * @return it
     */
    @Override
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }

    /**
     * 向下取整，floor 地板
     *
     * @return 小于等于key的最大键
     */
    @Override
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp < 0) {
            return floor(x.left, key);//小于等于key的最大键一定在左子树
        } else {
            Node t = floor(x.right, key);//查找右子树中小于等于key的最大键
            if (t != null) {
                return t;//got it
            } else {
                return x;//未找到，返回临时的根结点
            }
        }
    }

    /**
     * 向上取整，ceiling 天花板
     *
     * @return 大于等于key的最小键
     */
    @Override
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp > 0) {
            return ceiling(x.right, key);//大于等于key的最小键一定在右子树
        } else {
            Node t = ceiling(x.left, key);//查找左子树中大于等于key的最小键
            if (t != null) {
                return t;//got it
            } else {
                return x;//未找到，返回临时的根结点
            }
        }
    }

    /**
     * 查找排名为k的键
     *
     * @param k 排名
     */
    @Override
    public Key select(int k) {
        return select(root, k);
    }

    private Key select(Node x, int k) {
        if (x == null) {
            return null;
        }
        if (x.N == k) {
            return x.key;
        } else if (x.N < k) {
            return select(x.right, k);
        } else {
            return select(x.left, k);
        }
    }

    /**
     * 查找键key的排名
     *
     * @param key 给定键
     */
    public void rank(Key key) {

    }

    /**
     * 二叉查找树最难写的方法，删除 todo
     *
     * @param key 键
     */
    @Override
    public void delete(Key key) {

    }

}
