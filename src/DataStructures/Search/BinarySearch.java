package DataStructures.Search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    //二分查找的前提是有序数组!!!!!!!!
    //有序数组，取中间值，所需值若大于mid,则向右递归
    //                  若小于mid，则向左递归
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 67, 2334, 453, 23};
        //int resultIndex = binarySearch(arr, 0, arr.length - 1, 8)
        //System.out.println("resultIndex=" + resultIndex);
        List resIndexList = binarySearch2(arr, 0, arr.length - 1, 23);
        System.out.println("resIndexList" + resIndexList);

    }

    //二分查找
    public static int binarySearch(int arr[], int left, int right, int findValue) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findValue > midVal) {
            //向右递归
            return binarySearch(arr, mid + 1, right, findValue);
        } else if (findValue < midVal) {
            return binarySearch(arr, left, right - 1, findValue);
        } else {
            return mid;
        }
    }

    /**
     * 有多个相同的数值时，如何将所有的数组都查找到
     * <p>
     * 思路：
     * 1、在找到mid索引值，不直接返回
     * 2、向mid 索引值的右边扫描，将所有满足1000的元素下标存储到集合中
     * 3、向mid 索引值的右边扫描，同理
     * 4、返回集合
     */
    public static ArrayList<Integer> binarySearch2(int arr[], int left, int right, int findValue) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findValue > midVal) {
            //向右递归
            return binarySearch2(arr, mid + 1, right, findValue);
        } else if (findValue < midVal) {
            return binarySearch2(arr, left, mid - 1, findValue);
        } else {

            ArrayList<Integer> resIndexlist = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findValue) {
                    break;
                }
                //否则，将temp放入到resIndexlist中
                resIndexlist.add(temp);
                temp -= 1;//temp左移
            }
            resIndexlist.add(mid);

            //向mid索引值的右边扫描，将所有满足1000 的元素下标，加入到array；list
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findValue) {
                    break;
                }
                //否则，将temp放入到resIndexlist中
                resIndexlist.add(temp);
                temp += 1;//temp右移
            }
            return resIndexlist;

        }

    }
}

