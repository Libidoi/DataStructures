package Algorithm.KMP.kmp;

public class kmpAlgorithm {
    public static void main(String[] args) {
        String str1 = "ABCDFENININOFENININjihioh";
        String str2 = "ENININO";
    }

    //获取到一个字符串（子串）的部分匹配值
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串是长度为1 部分匹配值就是0
        for (int i = 1, j = 0; i < dest.length(); i++) {

        }
        return next;
    }


}
