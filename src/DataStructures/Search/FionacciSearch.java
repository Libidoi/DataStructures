package DataStructures.Search;

import java.util.Arrays;

public class FionacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        //有序数组
        int arr[] = {1, 34, 53, 65, 666, 6778};
        System.out.println(fibsearch(arr,6778));
    }

    //mid=low +F(k-1)-1,使用斐波那契数列，需要先获取到一个斐波那契数列
    //非递归
    public static int[] fibo() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //斐波那契查找算法

    /**
     * @param a     数组
     * @param value 需要查找的数据
     * @return 返回对应下标，如果没有的话返回-1
     */
    public static int fibsearch(int[] a, int value) {
        int low = 0;
        int higth = a.length - 1;
        int mid = 0;//mid值存放
        int k = 0;//表示斐波那契分割数值的下标
        int f[] = fibo();//获取斐波那契数列
        //获取斐波那契分割数值的下标
        while (higth > f[k] - 1) {
            k++;
        }
        //f[k]可能大于数组长度，使用Array类构造新数组，并且指向a
        //不足的部分使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //实际上需要使用a数组的最后的数填充temp
        for (int i = higth + 1; i < temp.length; i++) {
            temp[i] = a[higth];
        }
        //使用while循环处理，找到value
        while (low <= higth) {
            mid = low + f[k - 1] - 1;
            if (value < temp[mid]) {
                //继续向数组前查找，向左查找
                higth = mid - 1;
                k--;
            } else if (value > temp[mid]) {
                //向数组后查找，向右查找
                low = mid + 1;
                k -= 2;
            } else {
                //需要确定返回的下标
                if (mid <= higth) {
                    return mid;
                } else {
                    return higth;
                }
            }
        }
        return -1;
    }
}
