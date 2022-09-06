package DataStructures.Stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试
        ArrayStack as = new ArrayStack(4);
        as.push(5);
        as.push(2);
        as.push(3);
        as.push(4);
        as.list();
        as.pop();
        as.list();
        as.pop();


    }
}

class ArrayStack {
    private int maxSize;//栈大小
    private int[] stack;//
    private int top = -1;//栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //入栈 push
    public void push(int value) {
        //判断栈是否满
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        //判断栈是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空无数据");
        }
        int value = stack[top];
        top--;
        return value;

    }

    //显示栈顶的情况[遍历栈],遍历时需要从栈顶显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，无数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
