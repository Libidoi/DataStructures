package Algorithm.DAC;

public class Hanoitower {
    //汉诺塔移动方案
    //分治算法
    public static void main(String[] args) {
        move(5, 'A', 'B', 'C');
    }

    public static void move(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第一个盘从" + a + "->" + c);
        } else {
            //
            move(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从" + a + "-》" + c);
            move(num - 1, b, a, c);
        }


    }
}
