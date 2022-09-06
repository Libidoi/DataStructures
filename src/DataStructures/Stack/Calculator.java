package DataStructures.Stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "3+2*6-2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要相关变量
        int index = 0;//扫描指针
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';

        //while循环扫描expression
        while(true){

        }
    }
}

//建栈
//拓展比较功能
class ArrayStack2 {
    private int maxSize;//栈大小
    private int[] stack;//
    private int top = -1;//栈顶

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;//存放计算结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    //判断是否为操作符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //返回运算符的优先级（程序员来定,优先级使用数字表示）(假定只有加减乘除)
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
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