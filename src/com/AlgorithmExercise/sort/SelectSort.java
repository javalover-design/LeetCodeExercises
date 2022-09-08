package com.AlgorithmExercise.sort;

/**
 * @author binbin
 * @date 2022年09月08日  下午9:00
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr=new int[]{1,5,6,9,7};
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }


    /**
     * @author binbin
     * @date 2022/9/8 下午9:01
     * @param arr
     * 选择排序算法
     * 思路：
     * 利用两个变量min和minIndex，一个表示最小的数，一个表示最小的数的下标
     * 基本过程：从数组的第一个元素开始，将其作为min，其位置作为minIndex，将min与后续的元素进行比较，如果存在比min还小的元素
     * 那么将min与该数进行交换位置，之后再将min与后续的进行比较，直到比到最后一个元素
     * 主要分两层循环，外层循环表示选择排序的次数，内层循环表示进行一轮选择排序
     * 内层循环中如果存在比min还小的元素，则将其进行交换，如果不存在比min还小的元素，则不用进行交换，继续下一轮排序，minIndex+1
     */
    public static void selectSort(int[] arr){
        //n个数则需要进行n-1轮选择排序
        for (int i=0;i<arr.length-1;i++){
            //定义变量表示最小的数和最小数的下标
            int min=arr[i];
            int minIndex=i;
            for (int j=i+1;j<arr.length;j++){
                //表示一次选择排序，j初始为i的下一个元素，即min的下一个元素
                if (min>arr[j]){
                    //如果存在比min小的则，将min设置为该数
                    min=arr[j];
                    minIndex=j;
                }

            }
            //如果一轮内层循环结束后，i与最小值下标不一致，则证明进行了互换，需要将两个数位置互换,需要始终保证最小的数在前面
            if (i!=minIndex){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }

    }
}
