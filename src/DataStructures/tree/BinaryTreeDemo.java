package DataStructures.tree;


public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建结点
        HeroNode root = new HeroNode(1, "松江");
        HeroNode node2 = new HeroNode(2, "芜湖");
        HeroNode node3 = new HeroNode(3, "嘿嘿");
        HeroNode node4 = new HeroNode(4, "嘻嘻");

        //先手动创建节点，后面学习递归方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(new HeroNode(5,"喜羊羊"));
        binaryTree.setRoot(root);
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        System.out.println("后序遍历");
//        binaryTree.postOrder();

//        //测试 前序遍历
//        System.out.println("前序查找");
//        HeroNode res = binaryTree.preOrderSearch(2);
//        if (res != null) {
//            System.out.printf("找到信息,no=%d name =%s", res.getNo(), res.getName());
//        } else {
//            System.out.println("未找到");
//        }
//
//        System.out.println("中序查找");
//        HeroNode res2 = binaryTree.infixOrderSearch(2);
//        if (res2 != null) {
//            System.out.printf("找到信息,no=%d name =%s", res2.getNo(), res2.getName());
//        } else {
//            System.out.println("没找到");
//        }
//
//        System.out.println("后序查找");
//        HeroNode res3 = binaryTree.postOrderSearch(3);
//        if (res3 != null) {
//            System.out.printf("找到信息,no=%d name =%s", res3.getNo(), res3.getName());
//        } else {
//            System.out.println("没找到");
//        }
        //测试删除节点
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除后");
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();
    }
}

//定义binaryTree 二叉树
class BinaryTree {
    private HeroNode root;//根节点

    public void setRoot(HeroNode root) {
        this.root = root;
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


//创建heronode节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

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

