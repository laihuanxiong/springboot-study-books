package com.study.books.algorithm.sort;

//@todo 八大排序算法之二
//@todo 快速排序(每次排序的时候设置一个基准点，将小于等于基准点的数全部放到基准点的左边，将大于基准点的数全部放到基准点的右边)

//@todo 简述
//@todo 快速排序，看这名字就知道这是一种很快的排序方法，实际上也是如此。快速排序属于分治法的一种，就是说通过把数据分成几部分来同时处理的一种算法。

import java.util.Arrays;

//@todo 时空复杂度
//@todo 快速排序的最差时间复杂度和冒泡排序是一样的都是O(n2)
//@todo 不需要额外的空间，空间复杂度为O(1)
//@todo 快速排序算法的稳定性取决于和基准值交换的那个数的大小，如果它们相等的话，那么稳定性就被破坏了，所以快速排序是一种不稳定的排序方法。
public class QuickSort {


    public static void quickSort(int[] array) {
        int len;
        if (array == null || (len = array.length) == 0 || len == 1) {
            return;
        }
        sort(array, 0, len - 1);
    }

    //@todo 快排核心算法，分治法，递归实现
    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        //base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            //顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            //再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            //上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        //将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        //递归，继续向基准的左右两边执行和上面同样的操作
        //i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }


    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println("排序前："+ Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后："+ Arrays.toString(arr));
    }
}
