package DataStructures.huffmanCode;

import java.util.*;

public class huffmancode {
    public static void main(String[] args) {
        String content = "i like like like python do u like a python";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        List nodes = getNode(contentBytes);
        System.out.println(nodes);

        //测试
        System.out.println("赫夫曼树");
        Node huffmanTreeRoot = creatHuffTree(nodes);
        System.out.println("前序遍历");
        huffmanTreeRoot.preOrder();
    }

    //前序遍历
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }

    //通过list创建一颗huffman树
    public static Node creatHuffTree(List<Node> nodes) {

        //排序
        while (nodes.size() > 1) {
            //从小到二
            Collections.sort(nodes);
            //取出根节点权值最小俩颗
            Node leftnode = nodes.get(0);
            //取出第二小
            Node rightnode = nodes.get(1);
            //构建新的二叉树，因为根节点没有data，只有权值
            Node parent = new Node(null, leftnode.weight + rightnode.weight);
            parent.left = leftnode;
            parent.right = rightnode;
            //将处理的二叉树删除从nodes
            nodes.remove(leftnode);
            nodes.remove(rightnode);

            nodes.add(parent);
        }
        //nodes最后的结点，即为赫夫曼树的结点
        return nodes.get(0);
    }

    /**
     * @param bytes 接收字节数组
     * @return 返回list
     */
    private static List getNode(byte[] bytes) {
        //创建一个arraylist
        ArrayList<Node> nodes = new ArrayList<>();
        //存储每一个byte出现的次数
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        //将每个键值对转成node对象 加入到nodes集合
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }
}

class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

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
}