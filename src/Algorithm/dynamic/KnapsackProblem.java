package Algorithm.dynamic;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品重量
        int[] val = {1500, 3000, 2000};//物品价值
        int bag = 4;//背包重量
        int num = val.length;

        //记录放入商品的情况，定义二维数组

        //二维数组 v[i][j] 表示前i个物品中能够装入容量为j的背包的最大价值
        int[][] v = new int[num + 1][bag + 1];
        int[][] path = new int[num + 1][bag + 1];
        //初始化第一行第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//第一列为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;//第一行为0

        }
        //根据前面公式动态规划处理
        for (int i = 1; i < v.length; i++) {//跳过不处理第一行，i从1开始
            for (int j = 1; j < v[0].length; j++) {//不处理第一列，j从1开始
                //
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    //i从1开始
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //为了记录商品存放到背包的情况，不能简单使用,使用if else 处理
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //将当前记录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }

                }
            }
        }
        //输出
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=====================");
        //输出最后放入的是哪些商品
        //遍历
//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                if (path[i][j] == 1)
//                    System.out.printf("第%d个商品放入到背包中", i);
//            }
//        }
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包中\n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }

}
