package com.study.books.algorithm.sort;

//@todo 八大排序算法之一
//@todo 冒泡排序(原理：比较两个相邻的元素，将值大的元素交换至右端)

//@todo 冒泡排序：一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
//@todo 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

//@todo 分解步骤
//@todo 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
//@todo 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
//@todo 针对所有的元素重复以上的步骤，除了最后一个。
//@todo 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

//@todo 时间复杂度
//@todo 正序：所需的比较次数C和记录移动次数M均达到最小值，即：Cmin=n-1;Mmin=0;所以，冒泡排序最好的时间复杂度为O(n)。
//@todo 反序：每趟排序要进行n-i次比较(1≤i≤n-1)，且每次比较都必须移动记录三次来达到交换记录位置。在这种情况下，比较和移动次数均达到最大值，那可以知道冒泡排序的最坏时间复杂度为：O(n2)：

import java.util.Arrays;

public class BubbleSort {
    public static int[] sort(int[] array) {//外层循环控制排序趟数
        for (int i = 0; i < array.length - 1; i++) {//内层循环控制每一趟排序多少次
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};
        System.out.println("排序前："+ Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后："+ Arrays.toString(arr));
    }
}
