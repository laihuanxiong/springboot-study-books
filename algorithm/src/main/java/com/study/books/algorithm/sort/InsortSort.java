package com.study.books.algorithm.sort;

//@todo 八大排序算法之四
//@todo 直接插入排序(顺序把待排序的数据元素按其关键字值的大小插入到已排序数据元素子集合的适当位置)

//@todo 直接插入的算法基本思想是：仅有一个元素的序列总是有序的，因此，对n个记录的序列，可从第二个元素开始直接到第n个元素，
//@todo 逐个向有序序列中执行插入操作，从而得到n个元素按关键字有序的序列。一般来说，在含有j-1个元素的有序序列中插入一个元素的方法是：
//@todo 从第j-1个元素开始依次向前搜索应当插入的位置，并且在搜索插入位置的同时可以后移元素，这样当找到适当的位置时，即可插入元素

import java.util.Arrays;

public class InsortSort {

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int num = a[i];
            int j;
            for (j = i; j > 0 && num < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = num;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5};
        System.out.println("排序前："+ Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后："+ Arrays.toString(arr));
    }
}
