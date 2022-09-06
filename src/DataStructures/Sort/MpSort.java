package DataStructures.Sort;

import java.util.Arrays;

public class MpSort {
    public static void main(String[] args) {
        int[] arr = {89, 123, 56, 435, 241, 12, 43};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }


}
