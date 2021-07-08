package chap3.binary_search_tree;

/**
 * 二叉查找树的递归实现
 *
 * @param <Key>
 * @param <Value>
 * @author jianghao.zhang
 */
public class BstApiImpl<Key extends Comparable<Key>, Value> implements BSTApi<Key, Value> {

    private class Node {
        private final Key key;
        private Value value;
        private Node left, right;
        private int n;//结点计数器，存储以该结点为根的子树中的结点总数

        Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    private Node root;

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        // 节点计数器的值就是子树的节点个数
        return x.n;
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
            //如果待插入键已存在，直接替换此结点值。如果不存在，则变成添加结点的情况，需要多一次递归至遇到树末端null结点
            x.value = value;
        }

        //update node count
        x.n = size(x.left) + size(x.right) + 1;

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
                return t;
            } else {
                //未找到，返回临时的根结点
                return x;
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
        if (x.n == k) {
            return x.key;
        } else if (x.n < k) {
            return select(x.right, k);
        } else {
            return select(x.left, k);
        }
    }

    /**
     * 查找键key的排名 select方法的逆方法
     *
     * @param key 给定键
     */
    public int rank(Key key) {
        return rank(root, key);
    }

    /**
     * 本质上是递归求以x为根节点的子树中键小于 x.key 的节点数量
     */
    private int rank(Node x, Key key) {
        if (x == null) {
            // case:没有小于指定key的，说明已经搜索到了叶子
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            // 左子树中存在这样的节点，它的键比指定的key更小
            return rank(x.left, key);
        } else if (cmp > 0) {
            // 1 表示执行中的node x 自身， size(x.left) 表示求node左子树节点的数量（它的左子树中的所有节点键都小于它的键），
            // rank(x.right, key) 表示继续递归求解它的右子树中小于它的键的节点数量
            return 1 + size(x.left) + rank(x.right, key);
        } else {
            // 完全相等，说明匹配到了key，它的左子树节点数+1就是它的排名
            return size(x.left) + 1;
        }
    }

    /**
     * 删除树的最小键的节点
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            // 递归结束条件：当前节点没有左子节点，准确地说，完全没有子节点了
            // 这时，返回它的右子树，换个角度，就是最左末的一个节点被抛弃了
            return x.right;
        }
        // 一直沿左子树往深处递归
        x.left = deleteMin(x.left);
        // 递归往浅处跳出时，更新沿途每一个节点的计数器
        x.n = size(x.left) + size(x.right) + 1;
        // 返回抛弃了最左末节点的树
        return x;
    }

    /**
     * 二叉查找树最难写的方法，删除任意节点
     *
     * @param key 将被删除的节点的键
     */
    @Override
    public void delete(Key key) {
        // 把删除一个节点后的新树赋值给旧树
        root = delete(root, key);
    }

    /**
     * 从树x中删除一个键为k的节点。虽然复杂，画完步骤图后就容易理解
     *
     * @param x 想象成一棵🌲
     * @param k 将被删除的节点的键
     * @return 临时的处于中间状态的一颗树
     */
    private Node delete(Node x, Key k) {
        // 递归结束条件
        if (x == null) {
            return null;
        }
        int cmp = k.compareTo(x.key);
        if (cmp < 0) {
            // 如果k代表的目标节点在x的左子树中，则把 x的左子树删除节点k 然后赋值给 原始的x的左子树Node对象
            x.left = delete(x.left, k);
        } else if (cmp > 0) {
            x.right = delete(x.right, k);
        } else {
            // 简单情形之一
            if (x.right == null) {
                return x.left;
            }
            // 简单情形之二
            if (x.left == null) {
                return x.right;
            }
            // 情形一和二逻辑类似，都是把自己这个单节点删除，然后把（可能为空的）子树返回

            // x的左右节点都非空，则x是一颗至少包含3节点的完整形式的（子）树
            Node tmp = x;

            // 赋值，变量节点x为 从被删除节点的右子树中取最小的一个节点（非树）
            x = min(tmp.right);

            // 该节点的右节点应该是 被删除节点的右子树继续删除了最小节点 之后得到的子树
            x.right = deleteMin(tmp.right);

            // 该节点的左子树应该是 被删除节点的左子树
            x.left = tmp.left;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

}
