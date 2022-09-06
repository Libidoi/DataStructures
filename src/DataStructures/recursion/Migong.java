package DataStructures.recursion;

public class Migong {
    public static void main(String[] args) {
        //创建一个二维数组地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;
        //输出地图
        System.out.println("地图情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //使用递归回溯
        //setway(map, 1, 1);
        setway2(map, 1, 1);
        //输出新的地图,小球走过并且标识过的地图
        System.out.println("小球走过标识后");
        show(map);

    }

    //使用递归回溯来给小球找路
    //说明
    //1、map表示地图
    //2、i、j表示从地图的哪个位置开始触发（1，1）
    //3、如果小球能到map[6][5]位置，则说明通路找到
    //4、当map[i][j]为0表示该点没有走过 当为1的时候表示墙，为2则表示通路可以走
    //表示为3则表示该路已经走过但是走不通
    //5、走迷宫时，需要确定一个策略（方法），下右上左

    /**
     * @param map 表示地图
     * @param i   表示从哪个位置开始找
     * @param j
     * @return 找到路则返回true 否则返回false
     */
    public static boolean setway(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //说明通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                //如果当前路径没有走过
                //则按照给定策略
                map[i][j] = 2;//假定该点可以走通
                if (setway(map, i + 1, j)) {
                    //向下走
                    return true;
                } else if (setway(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setway(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setway(map, i, j - 1)) {
                    //向左走
                    return true;
                } else {
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j] ！=0，map可能是1可能是2可能是3
                return false;
            }
        }
    }

    public static boolean setway2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //说明通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                //如果当前路径没有走过
                //则按照给定策略 上右下左
                map[i][j] = 2;//假定该点可以走通
                if (setway2(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setway2(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setway2(map, i + 1, j)) {
                    //向上走
                    return true;
                } else if (setway2(map, i, j - 1)) {
                    //向左走
                    return true;
                } else {
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j] ！=0，map可能是1可能是2可能是3
                return false;
            }
        }
    }

    public static void show(int map[][]) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
