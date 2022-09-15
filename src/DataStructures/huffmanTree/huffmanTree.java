package DataStructures.huffmanTree;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class huffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);

        //测试
        //preOrder(root);
        //infixOrder(root);
        proOrder(root);
    }

    //前序遍历的方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树");
            return;
        }
    }

    //中序遍历
    public static void infixOrder(Node root) {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("空树");
            return;
        }
    }

    //后序遍历
    public static void proOrder(Node root) {
        if (root != null) {
            root.proOrder();
        } else {
            System.out.println("空树");
            return;
        }
    }
    //创建赫夫曼树

    /**
     * @param arr 需要创建成赫夫曼树的数组
     * @return 创建好后的赫夫曼树的root结点
     */
    public static Node createHuffmanTree(int[] arr) {
        //1、遍历数组
        //2、将arr的每个元素构成一个node
        //3、将node放入到arraylist中
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        //循环处理过程
        while (nodes.size() > 1) {
            //从小到大排序
            Collections.sort(nodes);
            System.out.println("nodes=" + nodes);

            //取出根节点权值最小的两颗二叉树
            //1、取出权值最小的结点（二叉树）
            Node leftNode = nodes.get(0);
            //2、取出权值第二小的结点
            Node rightNode = nodes.get(1);
            //3、构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //4、从arraylist中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5、将parent加入到nodes
            nodes.add(parent);
        }
        //返回赫夫曼树的第一个结点
        return nodes.get(0);
    }
}

//创建节点类
//为了让node类支持排序， 对象持续排序Collections集合排序

/**
 * 权值
 * 左子节点
 * 右子节点
 */
class Node implements Comparable<Node> {

    int value;
    Node left;
    Node right;

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void proOrder() {
        if (this.left != null) {
            this.left.proOrder();
        }
        if (this.right != null) {
            this.right.proOrder();
        }
        System.out.println(this);
    }

    public Node(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
    }
}
