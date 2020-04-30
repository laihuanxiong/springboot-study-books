package com.study.books.algorithm.sort;

//@todo 八大排序算法之三
//@todo 选择排序(每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，直到所有元素排完为止​​​​​​​。)

//@todo for循环进行比较，定义一个第三个变量temp，首先前两个数比较，把较小的数放在temp中，然后用temp再去跟剩下的数据比较，如果出现比temp小的数据，就用它代替temp中原有的数据。
//@todo 无论数组原始排列如何，比较次数是不变的；对于交换操作，在最好情况下也就是数组完全有序的时候，无需任何交换移动时间复杂度，在最差情况下，
//@todo 也就是数组倒序的时候，交换次数为n-1次。综合下来，时间复杂度为O(n2)。不需要额外的空间，空间复杂度为O(1)。

public class SelectionSort {

    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[k]){
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,3,2,45,65,33,12};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
