package Algorithm.binaryserch;

public class binarysearch {
    public static void main(String[] args) {
        //二分查找非递归
        int[] arr = {1, 3, 4, 5, 6, 7};
        int index = binarySearch(arr, 7);
        System.out.println(index);
    }

    /**
     * @param arr    查询数组
     * @param target 查找数值
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            //说明继续查找
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;//向左查找
            } else {
                left = mid + 1;//向右查找
            }
        }
        return -1;
    }

}
