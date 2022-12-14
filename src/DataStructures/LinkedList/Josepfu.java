package DataStructures.LinkedList;

public class Josepfu {
    public static void main(String[] args) {
        //测试 单向环形链表
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);//加入5个小孩节点
        circleSingleLinkedList.showBoy();

        //测试小孩出圈是否正确
        circleSingleLinkedList.countBoy(1,2,5);

    }
}

//创建环形单项链表
class CircleSingleLinkedList {
    //创建一个first节点，当前无编号
    private Boy first = new Boy(-1);

    //添加小孩节点，构成一个环形的链表
    public void addBoy(int nums) {
        //nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，构建环形链表
        //使用循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//让curBoy指向第一个小孩

            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("无小孩");
            return;
        }
        //因为first不动，所以仍热使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();//curboy后移
        }
    }

    //根据用户输入计算出出圈的顺序
    public void countBoy(int startNO, int countNUm, int nums) {
        //对数据校验
        if (first == null || startNO < 1 || startNO > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建要给辅助指针，帮助小孩完成出圈
        Boy helper = first;
        //需要创建一个辅助指针（变量）helper，事先应该指向环形列表的最后节点
        while (true) {
            if (helper.getNext() == first) {
                //说明helper指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动k-1次
        for (int j = 0; j < startNO - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();

        }
        //小孩报数时，让first和helper指针同时移动m-1次，然后出圈
        //这是一个循环操作，直到圈中只有一个节点
        while (true) {
            if (helper == first) {
                //说明圈中只有一个节点
                break;
            }
            //让first和helper指针同时移动countNum - 1 次
            for (int j = 0; j < countNUm - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩
            System.out.printf("小孩%d", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号是 %d \n", first.getNo());
    }
}

//创建一个boy类，表示一个节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
