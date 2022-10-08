package DataStructures.tree.RedBlackTree;

public class RedBlackTree<key extends Comparable<key>, value> {
    //根结点
    private Node root;
    //记录树中元素个数
    private int N;
    //红色链接
    private static final boolean RED = true;
    //黑色链接
    private static final boolean BLACK = false;

    //结点类
    private class Node {
        //存储键
        public key key;
        //存储值
        public value value;
        //左子节点
        public Node left;
        //右子节点
        public Node right;
        //由其父节点定义指向他的连接的颜色
        public boolean color;

        public Node(key key, value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    //获取树中元素个数
    public int size() {
        return N;
    }


    //判断当前父指向是否为红色
    public boolean isRed(Node x) {
        if (x == null) {
            //若返回false则链接默认为黑色
            return false;
        }
        return x.color == RED;
    }

    //左旋
    public Node rotateLeft(Node h) {
        //获取h结点的右子结点，表示为x
        Node x = h.right;
        //让x结点的左子节点称为h结点的右子结点
        h.right = x.left;
        //让h成为x结点的左子节点
        x.left = h;
        //让x结点的color等于h结点的color
        x.color = h.color;
        //让h结点的color属性变为红色
        h.color = RED;
        return x;
    }

    //右旋
    public Node rotateRight(Node h) {
        //获取h结点的左子节点，表示为x
        Node x = h.left;
        //让x结点的右子结点成为h结点的左子节点你
        h.left = x.right;
        //让h成为x结点的右子结点
        x.right = h;
        //让x结点的color等于h结点的color
        x.color = h.color;
        h.color = RED;
        return x;
    }

    //颜色反转
    private void flipColors(Node h) {
        //当前变为红色
        h.color = RED;
        //左子节点和右子节点变为黑色
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    //在整个树上完成插入
    public void put(key key, value value) {
        root = put(root, key, value);
        //根结点颜色总为黑色
        root.color = BLACK;
    }

    //在指定树中，完成插入操作，并返回添加元素后的新的树
    private Node put(Node h, key key, value value) {
        //判断h是否为空,如果根结点为空直接返回一个红色结点并且N++
        if (h == null) {
            //数量+1
            N++;
            return new Node(key, value, null, null, RED);
        }
        //比较h结点的值和key的大小
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            //继续往左
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            //继续往右
            h.right = put(h.right, key, value);
        } else {
            //值的替换
            h.value = value;
        }
        //进行左旋：当h的左子节点为黑色，右子节点为红色
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        //进行右旋:当h的左字节点，和左子节点的左子节点都为红色，需要右旋
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        //颜色反转 :当前节点的左子节点和右子节点都为红色
        if (isRed(h.left) && isRed(h.right)) {
             flipColors(h);
        }
        return h;
    }

    //获取k value
    public value get(key key) {
        return get(root, key);
    }

    //从指定的x中，查找key对应的value
    public value get(Node x, key key) {
        if (x == null) {
            return null;
        } else {
            //比较x结点的键和key的大小
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                return get(x.left, key);
            } else if (cmp > 0) {
                return get(x.right, key);
            } else {
                return x.value;
            }
        }


    }
}