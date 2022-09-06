package DataStructures.LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "芜湖", "大司马");
        HeroNode heroNode2 = new HeroNode(2, "pdd", "大飞猪");
        HeroNode heroNode3 = new HeroNode(3, "吴奇隆", "葫芦岛");
        HeroNode heroNode4 = new HeroNode(4, "心海", "低分崽");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);
        //按照编号
        singleLinkedList.addByorder(heroNode1);
        singleLinkedList.addByorder(heroNode4);
        singleLinkedList.addByorder(heroNode2);
        singleLinkedList.addByorder(heroNode3);
        //测试修改节点的代码
        singleLinkedList.list();
        HeroNode newheroNode = new HeroNode(2, "皮蒂蒂", "肥猪");
        singleLinkedList.update(newheroNode);
        singleLinkedList.list();
        //删除一个几点
        singleLinkedList.del(4);
        singleLinkedList.del(2);
        singleLinkedList.del(3);
        singleLinkedList.del(1);
        System.out.println("删除后");
        singleLinkedList.list();
    }
}

//定义singleListlist来管理英雄
class SingleLinkedList {
    //先初始化一个头结点
    private HeroNode head = new HeroNode(0, "", "");//仅仅表示一个头节点，不存放任何数据、
    public HeroNode getHead(){
        return head;
    }


    //添加结点到单向链表
    public void add(HeroNode heroNode) {
        //当不考虑编号的顺序时，找到当前链表的最后结点，将最后结点的next指向新的结点
        //辅助结点
        HeroNode temp = head;
        //遍历链表找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //未找到，则将temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
    }



    public void addByorder(HeroNode heroNode) {
        //头节点不能动，所以仍通过辅助变量找到添加位置
        //因为是单链表，因此我们找的temp是位于添加位置的前一个结点，否则无法插入
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //说明已经在链表最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到，即为temp后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明已经存在相同的node
                flag = true;
                break;
            }
            temp = temp.next;//将temp后移
        }
        //判断flag
        if (flag) {
            //不能添加
            //编号存在
            System.out.printf("准备插入的英雄编号%d已经存在不能添加", heroNode.no);
        } else {
            //插入到链表中，temp后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //删除结点信息
    //1、head结点不能动
    //2、加入辅助节点找到待删除节点的前一个节点

    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;//标识是否找到待删除节点的前一个节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //找到待删除节点的前一个节点tempno
                flag = true;
                break;
            }
            temp = temp.next;//temp后移
        }
        //判读flag
        if (flag) {
            //找到待删除节点
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的节点%d不存在", no);
        }
    }

    //更新结点信息，根据no编号修改
    public void update(HeroNode newheroNode) {
        //判断是否非空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;//辅助变量
        boolean flag = false;//表示是否找到该结点
        while (true) {
            if (temp == null) {
                break;//表示遍历完链表
            }
            if (temp.no == newheroNode.no) {
                System.out.println("找到目标结点");
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag，判断是否找到要修改的结点
        if (flag) {
            temp.name = newheroNode.name;
            temp.nickname = newheroNode.nickname;
        } else {
            System.out.printf("未找到%d编号结点，不能修改", newheroNode.no);
        }
    }

    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头结点不能动，所以需要一个辅助变量遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表末尾
            if (temp == null) {
                break;
            }
            //输出结点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

//定义一个HeroNode,每个HeroNode   对象就是一个结点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个结点 4

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}
