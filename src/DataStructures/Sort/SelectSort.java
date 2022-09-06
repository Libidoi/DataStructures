package DataStructures.Sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {121, 13, 54,353,53,65};
        System.out.println("排序前"+ Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后"+ Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr) {
        //使用逐步推到的方式，
        //选择排序的时间复杂度是O（n^2）
        //第一轮
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    //说明假定最小值不是最小值
                    min = arr[j];
                    minIndex = j;//重置min和minIndex
                }
            }
            //将最小值，放在arr[0] 即交换
            if (minIndex!=i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }
    }
}
