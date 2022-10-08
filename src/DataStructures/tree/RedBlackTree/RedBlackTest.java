package DataStructures.tree.RedBlackTree;

public class RedBlackTest {
    public static void main(String[] args) {
        //创建红黑树
        RedBlackTree<String, String> tree = new RedBlackTree<>();

        //往树中插入元素
        tree.put("1", "张三");
        tree.put("2", "张4");
        tree.put("3", "张5");
        tree.put("4", "张6");
        tree.put("5", "张7");
        //获取
        System.out.println(tree.get("1"));
        System.out.println(tree.get("2"));
        System.out.println(tree.get("3"));
        System.out.println(tree.get("4"));
    }
}
