package DataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList;//存储点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//边的数目

    public static void main(String[] args) {
        //测试图的创建
        int n = 5;//结点个数
        String vertexs[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        //循环添加顶点
        for (String Vertexvalue : vertexs) {
            graph.insertVertex(Vertexvalue);
        }
        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

    //显示邻接矩阵
        graph.show();

    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    //图中常用的方法
    public int getNumofVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i下标对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //显示图对应矩阵
    public void show() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边

    /**
     * @param v1     表示点的下标即第几个顶点
     * @param v2     第二个定点对应的下标
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}

