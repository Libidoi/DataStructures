package DataStructures.hashtab;

public class HashTabDemo {
    public static void main(String[] args) {

    }
}

//创建hashtab     管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListsArray;
    private int size;//表示多少条链表

    //
    public HashTab(int size) {
        this.size = size;
        //初始化hash
        empLinkedListsArray = new EmpLinkedList[size];
        //不要忘记分别初始化每条链表
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i] = new EmpLinkedList();

        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工id，得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFUN(emp.id);
        //将emp添加到对应链表中
        empLinkedListsArray[empLinkedListNo].add(emp);
    }

    //遍历所有链表,遍历hashtab
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i].list();

        }
    }

    //编写一个散列函数,使用简单取模
    public int hashFUN(int id) {
        return id % size;
    }

}

//一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;//默认为null

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList，表示链表
class EmpLinkedList {
    //头指针，执行第一个emp
    private Emp head;

    //添加雇员到链表
    //说明
    //1、添加雇员时，id是自增，即id分配总是从小到大
    //因此将该雇员直接加入到本链表最后即可
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，使用辅助指针，帮助定位
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                //说明链表到最后
                break;
            }
            curEmp = curEmp.next;//后移
        }
        //退出时直接将emp加入到链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list() {
        if (head == null) {
            //说明链表为空
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表的信息为");
        Emp curEmp = head;//辅助指针
        while (true) {
            System.out.printf("==> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                //说明curEmp已经是最后结点
                break;
            }
            curEmp = curEmp.next;//后移，遍历
        }
        System.out.println();
    }
}
