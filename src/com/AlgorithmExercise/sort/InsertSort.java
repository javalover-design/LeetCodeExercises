package com.AlgorithmExercise.sort;

/**
 * @author binbin
 * @date 2022年09月09日  下午8:00
 * 插入排序：
 * 思路分析：
 * 1.定义两个变量，一个是初始的插入的值insertValue（后续可能会改变，利用该变量来保存）。，一个是初始的插入的值的下标insertIndex（也可能会变）
 * 2.从数组的第i个元素开始进行遍历，即最开始和第i-1个数比较，如果比第i-1个数小，则将较大的数赋值到insertIndex的位置（即i），并
 * 且将插入的位置insertIndex前移（insertIndex--），继续进行比较，直到循环结束
 * 3.循环结束后将原先保存的变量的值赋值到insertIndex的位置，一轮则找到了最小的数，放在第一位。
 * 4.之后进行下一轮，重复将insertValue和insertIndex进行赋值，进行下一轮插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr=new int[]{1,5,6,9,7};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }


    }


    /**
     * @author binbin
     * @date 2022/9/9 下午8:31
     * @param arr
     * 选择排序算法
     */
    public static void insertSort(int[] arr){
        //首先设置要进行选择排序的次数，次数为n-1次，n表示数组长度，从下标1开始遍历（0下标无法与前一个数比较）
        for (int i=1;i<arr.length;i++){
            //每次进行新一轮插入排序，需要设置插入的下标与位置
            int insertIndex=i;
            int insertValue=arr[i];
            //进行循环比较，从insertIndex位置开始向前挨个比较，遇到大的，将改值后移，插入下标前移动一位
            while (insertIndex-1>=0 && insertValue<arr[insertIndex-1]){
                //需要保证插入的下标的前一个位置是不能小于0的，如果小于0之后，insertIndex会越界
                //将较大值后移，同时，插入下标前移动一位
                arr[insertIndex]=arr[insertIndex-1];
                insertIndex--;
            }
            //当一轮循环结束之后，需要将原先保存的需要插入的值，赋值到insertIndex的位置
            arr[insertIndex]=insertValue;
            //此时选择排序完成

        }

    }
}
