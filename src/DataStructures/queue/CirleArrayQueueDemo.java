package DataStructures.queue;

import java.util.Scanner;

public class CirleArrayQueueDemo {
    public static void main(String[] args) {
        //测试数组为环形数组
        CirleArray cirleArray = new CirleArray(4);
        char key = ' ';//接收用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        //输出一个菜单
        while (loop) {
            System.out.println("一个小菜单");
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):获取队列数据");
            System.out.println("h(head):获取队列头部数据");
            key = sc.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    cirleArray.showQueue();
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = sc.nextInt();
                    cirleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = cirleArray.getQueue();
                        System.out.println("取出的数据是" + res + "\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int res = cirleArray.hearQueue();
                        System.out.println("队列头的数据是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//环形队列
class CirleArray {
    private int maxSize;//数组最大容量
    private int front;//队列头部指向队列第一个元素即arr[front]为队列第一个元素，front初试值为0
    private int rear;//指向队列最后一个元素的后一个位置，rear的初始值为0
    private int[] arr;//模拟队列

    public CirleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据
    public void addQueue(int n) {
        //判断是否为满
        if (isFull()) {
            System.out.println("队列已满，不可添加数据");
            return;
        }//加入数据
        arr[rear] = n;//
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据(出队列)
    public int getQueue() {
        //判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据");
        }
        //分析出front是指向队列的第一个元素，第一步先把front对应的值保存到一个临时变量，再将front后移
        //将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        //思路：从front开始遍历，遍历多少元素
        //
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }


    }

    //求出当前队列有效个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列头部数据
    public int hearQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无数据");
        }
        return arr[front];
    }
}