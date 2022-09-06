package DataStructures.recursion;

public class Queen8 {
    //定义一个数组 共有多少皇后
    int max = 8;
    int[] array = new int[max];
    static int count;

    public static void main(String[] args) {
        //八皇后
        //测试8皇后是否正确
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("一共有"+count+"种");
    }

    //编写一个方法，放置第n个皇后
    //特别注意。check是每一次递归时，进入到check中都有for（int i=0；i<max；i++）,因此会有回溯
    private void check(int n) {
        if (n == max) {
            //n =8，所有八个皇后已防止完成
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前皇后n，放到该行第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                //不冲突
                //接着放n+1个皇后，即开始递归
                check(n + 1);
            }
            //如果冲突，则继续执行array[n]=i；
        }
    }

    //查看我们放置的第n个皇后，就去检测该皇后和前面拜访的皇后是否冲突

    /**
     * @param n 标识第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //说明
            //1、array[i]==array[n]  表示判断第n个皇后和前面n-1个皇后在同一列
            //2、Math.abs(n-i) == Math.abs(array[n]-array[i])表示判断第n个皇后是否和第i个皇后在同一斜线
            // n=1放置第二列1 n= 1 array[1]=1
            //Math.abs(1-0) ==1  Math.abs(array[n]-array[i]) = Math.abs（1-0） = 1
            //3、判断是否在同一行，没有必要，因为n每次都递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
