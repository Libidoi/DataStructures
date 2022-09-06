package DataStructures.Search;

import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        //System.out.println(Arrays.toString(arr));
        int index = InsertValuesearch(arr, 0, arr.length - 1, 100);
        System.out.println(index);

    }

    /**
     * @param arr       数组
     * @param left      左边索引
     * @param right     右边索引
     * @param findvalue 所需查找的值
     * @return 找到则返回对应下标，未找到则返回-1
     */
    public static int InsertValuesearch(int[] arr, int left, int right, int findvalue) {

        if (left > right || findvalue < arr[0] || findvalue > arr[arr.length - 1]) {
            return -1;
        }
        //求出mid
        int mid = left + (right - left) * (findvalue - arr[left]) / (arr[right] - arr[left]);
        int midVale = arr[mid];
        //若数组从小到大
        if (findvalue > midVale) {
            //向右递归
            return InsertValuesearch(arr, mid + 1, right, findvalue);
        } else if (findvalue < midVale) {
            //向左递归查找
            return InsertValuesearch(arr, left, mid - 1, findvalue);
        } else {
            return mid;
        }
    }
}
