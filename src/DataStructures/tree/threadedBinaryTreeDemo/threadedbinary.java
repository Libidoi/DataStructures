package DataStructures.tree.threadedBinaryTreeDemo;


/**
 * 线索化二叉树
 */
public class threadedbinary {
    public static void main(String[] args) {
        //测试中序线索化二叉树
        HeroNode root = new HeroNode(1, "tmo");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "mike");
        HeroNode node4 = new HeroNode(8, "alan");
        HeroNode node5 = new HeroNode(10, "wuhu");
        HeroNode node6 = new HeroNode(14, "yixi");

        //二叉树递归创建 简单处理 手动建树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试线索化
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);
        threadBinaryTree.threadNodes();

        //测试 以10号节点测试
        HeroNode leftnode = node5.getLeft();
        HeroNode right = node5.getRight();
        System.out.println("十号节点的前驱节点" + leftnode);
        System.out.println("十号节点的后继节点" + right);

        //线索化二叉树后，遍历
        threadBinaryTree.threadList();
    }
}

//定义线索化二叉树ThreadBinaryTree
class ThreadBinaryTree {
    private HeroNode root;//根节点
    private HeroNode pre;//前驱节点

    //实现线索化 需创建给指向当前节点的前驱节点的指针
    //递归进行线索化时，pre总是保留前一个节点
    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    //重载线索化的方法
    public void threadNodes() {
        this.threadNodes(root);
    }

    //中序遍历线索化二叉树
    public void threadList() {
        //定义一个变量，存储当前遍历节点，从root开始
        HeroNode node = root;
        while (node != null) {
            //循环找到lefttype ==1的节点，第一个找到的就是8节点
            //随着遍历变化，因为当lefttype ==1时，说明该节点就是按照线索化
            //处理后的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前节点
            System.out.println(node);
            //说明当前节点的右指针指向的是后继节点，则一直输出
            while (node.getLeftType() == 1) {
                //获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换当前遍历的节点
            node = node.getRight();
        }
    }
    //中序线索化

    /**
     * @param node 即为当前需线索化的节点
     */
    public void threadNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        //1、线索化左子树
        threadNodes(node.getLeft());
        //2、线索化当前节点
        if (node.getLeft() == null) {
            //使当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型,指向前驱节点
            node.setLeftType(1);
        }
        //处理后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //每处理一个节点，当前节点则为下一个节点的前驱节点
        pre = node;
        //3、线索化右子树
        threadNodes(node.getRight());
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {

        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //删除节点
    public void delNode(int no) {
        if (root != null) {
            //如果只有一个root节点，则判断是否为需删除的节点
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树无法删除");
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    private int leftType;
    private int rightType;
    //如果leftType ==0表示的是指向左子树，如果为1表示指向前驱节点
    //如果rightType ==0 表示指向右子树，如果为1表示指向后继节点


    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //递归删除节点
//1、如果删除的节点是叶子节点，则删除该节点
//2、如果删除的是非叶子节点，则删除该子树
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        //向右子树进行递归删除
        if (this.right != null) {
            this.right.delNode(no);
        }

    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);//输出父节点
        //向左子树递归
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //递归向左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        //比较当前节点是否
        if (this.no == no) {
            return this;
        }
        //判断当前节点左节点是否为空，不为空递归查找
        //如果左递归前序查找，找到节点则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            //说明左子树找到
            return resNode;
        }
        //左递归前序查找，找到节点，则返回，否则继续判断
        //当前的节点的右子节点是否为空，不为空则继续向左递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //如果找到，则返回，未找到则和当前节点比较，如果是则返回当前节点
        if (this.no == no) {
            return this;
        }
        //否则向右继续递归查找
        if (this.right != null) {
            return this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        //判断当前节点的左子节点是否为空，不为空则递归后序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //如果没有找到则向右递归查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //左右递归都未找到则返回父节点查找
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}