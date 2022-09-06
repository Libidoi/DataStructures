package DataStructures.Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSort(arr);//交换式
        shellSort2(arr);//移位式
    }

    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            //希尔第一轮排序
            //10/2=5组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组所有元素(共gap组,每组个元素),步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序" + (++count) + "伦后" + Arrays.toString(arr));
        }

    }

    //对交换式的希尔排序进行优化--》移位法
    public static void shellSort2(int arr[]) {
        int count = 0;
        //增量gap，并逐渐减少增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //退出while后，就给temp找到插入的位置
                    arr[j] = temp;

                }
            }
        }
        System.out.println("希尔排序" + (++count) + "伦后" + Arrays.toString(arr));
    }
}
