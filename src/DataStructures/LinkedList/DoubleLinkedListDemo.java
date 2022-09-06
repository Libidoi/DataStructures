package DataStructures.LinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");
        HeroNode2 heroNode1 = new HeroNode2(1, "芜湖", "大司马");
        HeroNode2 heroNode2 = new HeroNode2(3, "pdd", "大飞猪");
        HeroNode2 heroNode3 = new HeroNode2(5, "吴奇隆", "葫芦岛");
        HeroNode2 heroNode4 = new HeroNode2(7, "心海", "低分崽");

        //创建一个双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();

        //修改
        HeroNode2 heroNode5 = new HeroNode2(4, "喜羊羊", "崽");
        doubleLinkedList.update(heroNode5);
        doubleLinkedList.list();

        //删除
        System.out.println("删除后");
        doubleLinkedList.del(3);
        doubleLinkedList.list();


        //编号添加
        System.out.println("编号添加");
        doubleLinkedList.addByorder(new HeroNode2(4,"nihao","ceshi"));
        doubleLinkedList.addByorder(new HeroNode2(2,"nao","cshi"));
        doubleLinkedList.list();
    }

}

class DoubleLinkedList {
    //先初始化一个头结点
    private HeroNode2 head = new HeroNode2(0, "", "");//仅仅表示一个头节点，不存放任何数据、

    public HeroNode2 getHead() {
        return head;
        //返回头节点
    }

    //更新结点信息，根据no编号修改，修改节点的信息，双向链表的节点内容修改和单项链表一样
    public void update(HeroNode2 newheroNode) {
        //判断是否非空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;//辅助变量
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

    //从双向链表中删除节点
    //对于双向链表 可以直接找到目标节点，找到以后自我删除即可
    public void del(int no) {
        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;//辅助变量
        boolean flag = false;//标识是否找到待删除节点的前一个节点
        while (true) {
            if (temp == null) {//已经到链表的最后
                break;
            }
            if (temp.no == no) {
                //找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，遍历
        }
        //判读flag
        if (flag) {
            //找到待删除节点
//            temp.next = temp.next.next;   单项链表的删除方式
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的节点%d不存在", no);
        }
    }

    //从双向链表后面插入
    public void add(HeroNode2 heroNode) {
        //当不考虑编号的顺序时，找到当前链表的最后结点，将最后结点的next指向新的结点
        //辅助结点
        HeroNode2 temp = head;
        //遍历链表找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //未找到，则将temp后移
            temp = temp.next;
        }
        //退出while循环时，temp就指向了链表最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //根据编号
    public void addByorder(HeroNode2 heroNode) {
        //头节点不能动，所以仍通过辅助变量找到添加位置
        //因为是单链表，因此我们找的temp是位于添加位置的前一个结点，否则无法插入
        HeroNode2 temp = head;
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
            heroNode.pre = temp;

        }
    }

    //遍历双向链表
    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头结点不能动，所以需要一个辅助变量遍历
        HeroNode2 temp = head.next;
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

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个结点 4
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
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