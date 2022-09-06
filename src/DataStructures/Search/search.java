package DataStructures.Search;

public class search {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 24, 5};
        int index = seqSearch(arr, 11);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到在" + index);
        }
    }

    /**
     * 实现的线性查找是找到一个满足条件的值，就返回
     *
     * @param arr
     * @param value
     * @return
     */

    public static int seqSearch(int[] arr, int value) {
        //线性查找 发现有相同值，返回数组下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
