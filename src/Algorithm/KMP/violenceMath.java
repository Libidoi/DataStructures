package Algorithm.KMP;

public class violenceMath {
    public static void main(String[] args) {
        String str1 = "你好你好好爱好好";
        String str2 = "爱好";
        int index = violenceMath(str1,str2);
        System.out.println(index);
    }

    //暴力匹配
    public static int violenceMath(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1l = s1.length;
        int s2l = s2.length;

        int i = 0;//i 索引指向s1
        int j = 0;//j 索引指向s2
        while (i < s1l && j < s2l) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        //判断是否匹配成功
        if (j == s2l) {
            return i - j;
        } else {
            return -1;
        }
    }
}
