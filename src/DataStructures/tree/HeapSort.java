package DataStructures.tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9,-99,213,34,-1,-3,353};
        heapSort(arr);
    }

    public static void heapSort(int arr[]) {
        int temp = 0;
        System.out.println("堆排序");

        //分步完成
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次" + Arrays.toString(arr));//4，9，8，5，6
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次"+ Arrays.toString(arr));

        //最终
        //无序序列构建成一个堆，根据升序降序需求选择大顶堆或者小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        /**
         * 2、将堆顶元素与末尾元素交换，将最大元素沉到数组末端
         * 3、重新调整结构，将其满足堆定义，然后继续交换堆顶元素与当前末尾元素。反复执行调整＋交换不走，直到整个序列有序
         */
        for (int j = arr.length-1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    //将一个数组(二叉树),调整成一个大顶堆

    /**
     * 功能：完成将以i对应的树转化为大顶堆
     *
     * @param arr    调整数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素的调整，其为逐渐减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];//取出当前元素值，保存在临时变量
        //1、k=i*2 + 1 k是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //说明左子节点的值小于右子节点的值
                k++;//k指向右子节点
            }
            if (arr[k] > temp) {
                //如果子节点大于父节点
                arr[i] = arr[k]; // 将较大的值赋给当前节点
                i = k;//让i指向k，继续循环比较
            } else {
                break;
            }
        }
        //循环之后，已将i为父节点的树的最大值，放在了顶端
        arr[i] = temp;//将temp值放在调整后的位置
    }
}
