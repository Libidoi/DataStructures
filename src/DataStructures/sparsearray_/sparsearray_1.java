package DataStructures.sparsearray_;

import java.io.*;

public class sparsearray_1 {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0：表示没有棋子；1：表示黑子   2：表示白字
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();

        }
        //将二维数组转成稀疏数组
        //1、先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2、创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0的值存放到稀疏数组中
        int count = 0;// 用于记录第几个非0数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();
        //将稀疏数组恢复成原始的二维数组
        /* 1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，
         * 2、在读取稀疏数组后几行的数据，并赋给 原始的二维数组即可*/

        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2、在读取稀疏数组后几行的数据(从稀疏数组的第二行开始)，并赋给原始的二位数据即可
        for (int i =1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        System.out.println();
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("==============================");
        System.out.println("==============================");

        //4、将稀疏数组保存到磁盘上，例如map.data
        System.out.println("将稀疏数组命名为map.data");
        try {
            File f = new File("D:\\map.data/");
            FileOutputStream fos = new FileOutputStream(f);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            System.out.println("写入中----");
            for (int i = 0; i < sparseArr.length; i++) {
                osw.write(sparseArr[i][0]+","+sparseArr[i][1]+","+sparseArr[i][2]);
            }
            osw.close();
            fos.close();
            System.out.println("写入成功");
            //读取磁盘中的map.data文件
            System.out.println("读取中");
            FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            StringBuffer sb = new StringBuffer();
            while (isr.ready()){
                sb.append((char)isr.read());
            }
            isr.close();
            fis.close();
            System.out.println("读取成功");
            String ss = sb.toString();
            String[] sb1 = sb.toString().split(",");
            System.out.printf("从磁盘读取的字符串为：\n%s\n",ss);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
