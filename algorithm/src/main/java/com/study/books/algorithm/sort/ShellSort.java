package com.study.books.algorithm.sort;

//@todo 八大排序算法之五
//@todo 希尔排序(将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；每次再将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序。)

//@todo 直接插入排序算法的一种更高效的改进版本,又称“缩小增量排序”,是非稳定排序算法。该方法因D.L.Shell于1959年提出而得名。
//@todo 希尔排序的时间复杂度与增量(即，步长gap)的选取有关。例如，当增量为1时，希尔排序退化成了直接插入排序，此时的时间复杂度为O(N²)，
//@todo 而Hibbard增量的希尔排序的时间复杂度为O(N3/2)。空间复杂度O(1)。

public class ShellSort {

    public static void sort(int[] arr) {
        //增量每次都/2
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //从增量那组开始进行插入排序，直至完毕
            for (int i = 0; i < arr.length - 1; i++) {
                int j;
                int temp = arr[i];
                // j - step 就是代表与它同组隔壁的元素
                for (j = i; j - step > 0 && arr[j - step] > temp; j = j - step) {
                    arr[j] = arr[j - step];
                }
                arr[j] = temp;
            }
        }
    }

    public static void shellSort(int[] arrays) {
        //增量每次都/2
        for (int step = arrays.length / 2; step > 0; step /= 2) {
            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < arrays.length; i++) {
                int j = i;
                int temp = arrays[j];
                // j - step 就是代表与它同组隔壁的元素
                while (j - step >= 0 && arrays[j - step] > temp) {
                    arrays[j] = arrays[j - step];
                    j = j - step;
                }
                arrays[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,6,5,7};
        for (int i : arr) {
            System.out.printf(i+" ");
        }
        System.out.println();
        sort(arr);
        for (int i : arr) {
            System.out.printf(i+" ");
        }
    }
}
