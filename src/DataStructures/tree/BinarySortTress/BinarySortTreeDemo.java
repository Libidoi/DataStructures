package DataStructures.tree.BinarySortTress;


public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2, 0};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树");
        binarySortTree.infixOrder();

        //删除叶子节点
        System.out.println("删除结点");
        binarySortTree.delNode(1);
        binarySortTree.infixOrder();
        //删除父节点
    }
}

//创建二叉排序树
class BinarySortTree {
    private Node root;

    //查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //编写方法
    //返回的以node为根节点的二叉排序树的最小结点的值
    //删除node为根节点的二叉排序树的最小节点
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        //target则指向最小结点
        //删除最小结点
        delNode(target.value);
        return target.value;
    }

    //添加结点方法
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node searchnode = search(value);
            if (searchnode == null) {
                return;
            }//如果searchnode没有父结点
            //如果当前排序树只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //找到searchnode的父节点
            Node parentNode = searchParent(value);
            //如果要删除的结点是叶子结点
            if (searchnode.left == null && searchnode.right == null) {
                //判断searchnode是父结点的左子节点还是右子节点
                if (parentNode.left != null && parentNode.left.value == value) {//为左子节点
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value) {//为右子节点
                    parentNode.right = null;
                } else if (searchnode.left != null && parentNode.right != null) {//删除有两颗子树的结点
                    int minvalue = delRightTreeMin(searchnode.right);
                    searchnode.value = minvalue;
                }
            } else if (searchnode.left != null && searchnode.right != null) {

            } else {//删除只有一颗子树的结点
                //如果要删除的结点只有左子节点
                if (searchnode.left != null) {
                    //如果searchnode是parent的左子节点
                    if (parentNode.left.value == value) {
                        parentNode.left = searchnode.left;
                    } else {
                        //为右子节点
                        parentNode.right = searchnode.left;
                    }
                } else {
                    //要删除的结点有右子节点
                    if (searchnode.right != null) {
                        if (parentNode.left.value == value) {
                            parentNode.left = searchnode.right;
                        } else {
                            parentNode.right = searchnode.right;
                        }
                    }
                }
            }
        }
    }


    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("树为空无法遍历");
            return;
        }
    }
}

//创建Node
class Node {
    int value;
    Node left;
    Node right;

    //查找要删除的结点
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            //查找的值小于当前的结点，即为向左子树递归查找
            //如果左子节点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            //查找的值不小于当前结点
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除结点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值，并且当前结点的左子节点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;//未找到父节点
            }
        }
    }

    public Node(int value) {
        this.value = value;
    }

    //添加结点
    public void add(Node node) {
        if (node == null) {
            return;
        }

        //判断传入的结点的值和当前根节点比较
        if (node.value < this.value) {
            if (this.left == null) {
                //如果当前根节点左子节点为空
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            //添加的结点的值大于当前结点的值
            if (this.right == null) {
                this.right = node;
            } else {//递归的向右子树添加
                this.right.add(node);
            }
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

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}