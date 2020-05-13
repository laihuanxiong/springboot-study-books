package com.study.books.algorithm.sort;

import java.util.Arrays;

//@todo 八大排序算法之六
//@todo 堆排序(选择排序的一种：子结点的键值或索引总是小于(或者大于)它的父节点)

//@todo 此处以大顶堆为例，堆排序的过程就是将待排序的序列构造成一个堆，选出堆中最大的移走，再把剩余的元素调整成堆，找出最大的再移走，重复直至有序。
//@todo 由于堆排序中初始化堆的过程比较次数较多, 因此它不太适用于小序列。 同时由于多次任意下标相互交换位置, 相同元素之间原本相对的顺序被破坏了, 因此, 它是不稳定的排序。
//@todo 时间复杂度为O(nlgn),空间复杂度O(1)
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 9, 6, 8};
        System.out.println("排序前：" + Arrays.toString(a));
        sort(a);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    public static void sort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            max_heapify(a, i);
            //堆顶元素(第一个元素)与Kn交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
        }
    }

    /***
     *  将数组堆化
     *  i = 第一个非叶子节点。
     *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
     *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
     */
    public static void max_heapify(int[] a, int n) {
        int child;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            //左子节点位置
            child = 2 * i + 1;
            //右子节点存在且大于左子节点，child变成右子节点
            if (child != n && a[child] < a[child + 1]) {
                child++;
            }
            //交换父节点与左右子节点中的最大值
            if (a[i] < a[child]) {
                int temp = a[i];
                a[i] = a[child];
                a[child] = temp;
            }
        }
    }
}
