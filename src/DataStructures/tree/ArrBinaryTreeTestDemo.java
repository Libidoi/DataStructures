package DataStructures.tree;

public class ArrBinaryTreeTestDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //创建一个arrayBinaryTree
        ArrBinaryTree tree = new ArrBinaryTree(arr);
//        tree.preOrder(0);
//        tree.infixOrder(0);
        tree.postOrder(0);
    }
}

//编写一个ArrayBinaryTree，实现顺序存储二叉树遍历
class ArrBinaryTree {
    private int[] arr;//存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * @param index 数组下标
     */
    //完成顺序存储二叉树的前序遍历
    public void preOrder(int index) {
        //如果数组为空，或者length为0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归输出
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    //中序遍历 左父右
    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    //后序遍历 左右父
    public void postOrder(int index){
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
        System.out.println(arr[index]);
    }
}