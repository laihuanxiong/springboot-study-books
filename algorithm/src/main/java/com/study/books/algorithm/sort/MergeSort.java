package com.study.books.algorithm.sort;

import java.util.Arrays;

//@todo 八大排序算法之七
//@todo 归并排序(分治法)

//@todo 归并排序是建立在归并操作上的一种有效的排序算法，1945年由约翰·冯·诺伊曼首次提出。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用，且各层分治递归可以同时进行。
//@todo 时间复杂度O(logn2),空间复杂度O(n)

public class MergeSort {

    //归并排序
    public static int[] sort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);//归并
        }
        return array;
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int i = low;//指针，前一个序列的头指针
        int j = mid + 1;//指针，后一个序列的头指针
        int[] temp = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {//从头比较两个序列，小的放入临时数组temp
                temp[k++] = array[i++];//前一个序列指针后移一位
            } else {
                temp[k++] = array[j++];//后一个序列指针后移一位
            }
        }
        //最后只会剩下一组序列
        while (i <= mid) {
            temp[k++] = array[i++];//把前一个指针剩余的数字放入临时数组
        }
        while (j <= high) {
            temp[k++] = array[j++];//把后一个指针剩余的数字放入临时数组
        }
        for (int m = 0; m < high - low + 1; m++) {
            array[low + m] = temp[m];
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 6, 9, 7, 5};
        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
