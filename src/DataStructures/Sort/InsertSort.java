package DataStructures.Sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {110, 23, 43, 56, -1, -98, 98};
        insertSort(arr);
    }

    //插入排序
    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //逐步推导
        for (int i = 1; i < arr.length; i++) {


            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1;

            //给insertVal 找到插入的位置
            //1、insertIndex >=0 保证在insertVal找插入位置，不越界
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //退出while循环时，说明插入位置已经找到
            //判断是否需要赋值
            if (insertVal + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
            System.out.println("第" + i + "轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }
}
