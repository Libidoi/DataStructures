package DataStructures.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        //完成一个中缀表达式转换为后缀表达式的转换
        //说明：
        //1、1+((2+3)*4)-5 =>转成1 2 3 + 4 * + 5 -
        //2、因为直接对str 进行操作，不方便，因此先将“1+（2+3）*4-5”
        //3、将得到的中缀表达式对应的list转成后缀表达式对应的list
        //即
        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);
        System.out.println("中缀表达式" + list);//ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> list1 = parsetSuffixExpreesionList(list);
        System.out.println("后缀表达式对应的list" + list1);
        //定义一个逆波兰表达式
        //（3+4）*5-6 =》3 4 + 5 * 6 -
        //为了方便使用，逆波兰表达式的数字和符号使用空格隔开
//        String suffixExpression = "3 4 + 5 * 6 - ";
//        //思路：
//        // 1、先将逆波兰表达式放进一个集合ArrayList中
//        //2、将集合传给一个方法，配合栈完成计算
//        List<String> list = getListString(suffixExpression);
//        System.out.println("rpnlist=" + list);
//        int res = calculator(list);
//        System.out.println("计算的结果=" + res);
    }

    public static List<String> parsetSuffixExpreesionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        //因为s2这个栈，转换过程中，没有pop操作，而且还需要逆序输出，过于麻烦
        List<String> s2 = new ArrayList<>();

        //遍历ls
        for (String item : ls) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.matches("（")) {
                s1.push(item);

            } else if (item.equals(")")) {
                //如果是左括号，则依次弹出s1栈顶的运算符，并压入s2
                //直到遇到左括号为止，将这一对括号抛弃
                while (s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将（s1弹出，消除小括号
            } else {
                //当item优先级小于等于栈顶的运算符，将s1栈顶的运算符弹出并加入到21中，再次转到（4，1）与s1中的新栈顶运算符相比较
                //缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
        //将s1剩余运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
    }


    //将逆波兰表达式依次将数据和运算符放入到一个arraylist中
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calculator(List<String> ls) {
        //创建栈，只需要一个栈
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : ls) {
            //使用正则表达式来匹配
            if (item.matches("\\d+")) {
                //入栈
                stack.push(item);
            } else {
                //pop出两个数运算,再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //将res入栈
                stack.push(res + "");
            }
        }
        //最后留在stack中的就是运算结构
        return Integer.parseInt(stack.pop());
    }

    //方法：将中缀表达式转成一个后缀表达式
    public static List<String> toInfixExpressionList(String s) {
        //定义一个list，存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0;//一个指针，用于遍历中缀表达式字符遗传
        String str;//对多位数的拼接
        char c;//每遍历到一个字符，就放入到c
        do {
            //如果c是一个非数字，加入到ls中
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;//指针后移
            } else {//如果是一个数，需要考虑多位数
                str = "";//先将str 制空
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//拼接
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

}

//编写一个可以返回运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个返回对应优先级数字的方法
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;

        }
        return result;
    }
}