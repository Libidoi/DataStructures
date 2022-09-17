package DataStructures.tree.AVLTree;


public class AVLTreeDemo {
    public static void main(String[] args) {
        //int arr[] = {4, 3, 6, 5, 7, 8};
        int arr[] = {10, 12, 8, 9, 7, 6};
        //创建一个avl树
        AvlTree avlTree = new AvlTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历");
        avlTree.infixOrder();

        //未平衡处理前
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot());
//        System.out.println("左子树的高度" + avlTree.getRoot().leftheight());
//        System.out.println("右子树的高度" + avlTree.getRoot().rightheight());
    }
}

// 创建avltree
class AvlTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

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

    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环查找左子节点，找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //即此时target指向最小值
        delNode(target.value);
        return target.value;
    }

    //删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //找到要删除的结点 targetnode
            Node targetNode = search(value);
            //如果没有找到要删除的结点
            if (targetNode == null) {
                return;
            }
            //如果发现二叉排序树此时只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找到targetNode结点
            Node parent = searchParent(value);
            //如果要删除的结点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode是父节点的左子节点，还是右子节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                int minval = delRightTreeMin(targetNode.right);
                targetNode.value = minval;
            } else {
                //删除只有一颗子树的结点
                if (targetNode.left != null) {
                    if (parent != null) {
                        //如果targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    //如果要删除的结点是右子节点
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    //添加结点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空无法遍历");
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    //    返回左子树的高度
    public int leftheight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightheight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //返回当前结点的高度，以该结点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左旋转方法
    private void leftRotate() {
        //创建新的结点 以当前结点的value
        Node newnode = new Node(value);

        newnode.left = left;
        //将新的节点的右子树设置成当前结点的右子树的左子树
        newnode.right = right.left;
        //把当前节点的的值替换成右子树的value
        value = right.value;
        //将当前节点的右子树设置成右子树的右子树
        right = right.right;
        //将当前节点的左子树设置成新的结点
        left = newnode;
    }

    //右旋方法
    private void rightRotate() {
        Node newnode = new Node(value);
        //将新节点的右子树设置成当前节点的右子树
        newnode.right = right;
        newnode.right = left.right;
        value = left.value;
        left = left.left;
        right = newnode;
    }

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
        //添加完一个结点后，如果 右子树.height-左子树.height >1
        if ((rightheight() - leftheight()) > 1) {
            //如果右子树的左子树的高度>右子树的右子树高度
            //先右旋转再左旋转
            if(right!=null&&right.leftheight()>right.rightheight()){
            right.rightRotate();
            leftRotate();
            }else {
                //直接进行左旋转
            leftRotate();
            }
           return;
        }

        //当添加完一个结点后，如果出现左子树高度-右子树高度 >1
        if (leftheight() - rightheight() > 1) {
            //如果左子树的右子树高度大于左子树的高度
            if(left!=null && left.rightheight()>left.leftheight()){
                //先对当前节点的左节点（左子树）左旋转
                left.leftRotate();
                //再对当前节点右旋转
                rightRotate();
            }else {
                //直接进行右旋转即可
                rightRotate();
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
