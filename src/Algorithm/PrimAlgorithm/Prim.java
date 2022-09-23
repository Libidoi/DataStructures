package Algorithm.PrimAlgorithm;

import DataStructures.graph.Graph;

import java.util.Arrays;

public class Prim {
    //最小生成树
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.creatGraph(graph, verxs, data, weight);
        minTree.showGraph(graph);
        minTree.prim(graph, 0);
    }
}



//创建最小生成树,村庄图
class MinTree {
    //创建图的邻接矩阵

    /**
     * @param graph  图对象
     * @param verxs  结点数
     * @param data   各顶点值
     * @param weight 图的邻接矩阵
     */
    public void creatGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //prim算法，得到最小生成树

    /**
     * @param graph 图
     * @param v     表示从第几个顶点开始生成
     */
    public void prim(MGraph graph, int v) {
        //表示结点是否访问过
        int visteed[] = new int[graph.verxs];
        //默认值都是0，表示没有访问过
        visteed[v] = 1;
        //标记改结点以访问
        //h1和h2记录两顶点下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;//
        for (int k = 1; k < graph.verxs; k++) {
            //确定每一次生成的子图，和哪个结点的距离最近
            for (int i = 0; i < graph.verxs; i++) {//i表示被访问过的结点
                for (int j = 0; j < graph.verxs; j++) {//j表示未访问过的结点
                    if (visteed[i] == 1 && visteed[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条最小路径
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] +">权值"+ minWeight);
            //将当前找到结点标记为已访问
            visteed[h2] = 1;
            minWeight = 10000;
        }
    }

    //显示图
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }

    }
}

class MGraph {
    int verxs;//图的结点个数
    char[] data;//结点数据
    int[][] weight;//边，邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
