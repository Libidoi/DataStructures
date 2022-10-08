package DataStructures.linear;

public class SequenceList<T> {
    //存储元素的数组
    public T[] eles;
    //记录当前顺序表中的元素个数
    private int N;

    //初始化
    public SequenceList(int apacity) {
        //初始化数组
        this.eles = (T[]) new Object[apacity];
        this.N = 0;
    }

    //置为空表
    public void clear() {
        this.N = 0;
    }

    //判断是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //获取线性表长度
    public int length() {
        return N;

    }

    //获取指定位置元素
    public T get(int i) {
        return eles[i];
    }

    //添加元素
    public void insert(T t) {
        eles[N++] = t;
    }

    //重载insert，往指定位置添加元素
    public void insert(T t, int i) {
        //先将i索引处元素及其后面元素一次后移
        for (int index = N - 1; index > i; index--) {
            eles[index] = eles[index - 1];
        }
    }
}

