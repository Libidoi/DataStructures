package DataStructures.Sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    //基数排序方法
    public static void radixSort(int[] arr) {
        //1、得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到的最大数是几位数
        int maxLength = (max + "").length();

        //第一轮（针对每个元素的个位进行排序处理）
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //说明：
        //1、二维数组包含10个一维数组
        //2、为了防止放入数的时候，数据溢出，则每个一维数组（桶，
        //大小定为arr.length
        //3、明确，基数排序是使用空间换取时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放多少数据，定义一维数组记录各个桶的每次放入的数据个数
        //

        int[] bucketElementCounts = new int[10];
        //使用循环处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位
                int digitoOfElemnt = arr[j] / n % 10;
                //放入对应桶中
                bucket[digitoOfElemnt][bucketElementCounts[digitoOfElemnt]] = arr[j];
                bucketElementCounts[digitoOfElemnt]++;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶（即第k个一维数组）
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
            }
            System.out.println("第一轮，对个位的排序处理arr=" + Arrays.toString(arr));
        }
    }
}
