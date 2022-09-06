package DataStructures.Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70,-1,900};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("arr=" + Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;//临时变量，作为交换时
        //中轴值
        int pivot = arr[(l + right) / 2];
        //while循环的目的是让比pivot值小放到左边
        //比pivot值大放到右边
        while (l < r) {
            //在pivot左边一直找，
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l>=r说明pirvot的左右两边的值已经按照左边全部都是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现pivot==arr[l]相等，前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现arr[r]=pivot相等l++
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //如果1==r,必须l++,r--,否则出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, right);
        }
    }
}
