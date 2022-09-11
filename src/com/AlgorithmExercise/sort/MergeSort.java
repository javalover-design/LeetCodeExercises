package com.AlgorithmExercise.sort;

import java.util.Arrays;

/**
 * @author binbin
 * @date 2022年09月11日  下午2:58
 */
public class MergeSort {
    public static void main(String[] args) {

        int[] arr=new int[]{1,3,5,9,6,4,1};
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * @author binbin
     * @date 2022/9/11 下午2:59
     * @param arr
     * @param left
     * @param right
     * @param temp
     * 归并排序的基本思路：
     * 1. 该算法的基本思路是循环利用中间值（mid）将数组分成左右两部分，最后再将分的部分进行排序合并，最后得到有序的数组，
     * 并且该算法需要使用到临时数组temp
     * 2.获取中间值的算法是mid=(left+right)/2
     * 3.最后进行合并
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
     if (left<right){
     //需要始终保证数组左右边界保持左小于右
     //获取中间值
     int mid=(left+right)/2;
     //递归调用进行拆分
         //左边部分进行分解
         mergeSort(arr,left,mid,temp);
         //右边部分继续分解
         mergeSort(arr,mid+1,right,temp);

         //递归分解结束后进行合并操作
         merge(arr,left,mid,right,temp);

     }

    }

    /**
     * @author binbin
     * @date 2022/9/11 下午3:22
     * @param arr 要合并的数组
     * @param left 数组的左边界
     * @param mid 数组的中间值，是分解合并的依据
     * @param right 数组的右边界
     * @param temp  临时数组，用于存储合并后的数据
     * 思路：
     *  1.首先定义两个指针i和j，分别指向要合并两部分的元素
     *  2.i和j进行比较，小的放进临时数组中
     *  3.如果进行合并完还多一个元素，直接加入数组中即可
     */
    public  static void merge(int[] arr,int left,int mid,int right,int[] temp){
        //定义左右两部分的起始比较元素
        int i=left;
        int j=mid+1;
        //定义临时数组的下标，为0
        int t=0;
        while (i<=mid && j<=right){
            //循环条件表示i和j都不能越界
            if (arr[i]<=arr[j]){
                //如果i位置的元素小于等于j位置的元素，那么将i位置元素存入数组，左边指针后移
                temp[t]=arr[i];
                i++;
                t++;
            }else{
                temp[t]=arr[j];
                j++;
                t++;
            }
        }

        //如果上面循环结束之后仍旧有空出的元素，直接加入数组中即可
        //此时表示左边有剩余元素
        while (i<=mid){
           temp[t]=arr[i];
           i++;
           t++;
        }
        //此时表示右边有剩余元素
        while (j<=right){
            temp[t]=arr[j];
            j++;
            t++;
        }

        //将数据都存入临时数组之后，将临时数组中的元素依次存入arr真实数组中即可（覆盖）
        //数组的下标
        t=0;
        //原数组的起始位置，会随着赋值的过程移动。
        int tempLeft=left;
        while (tempLeft<=right){
            //只要左指针小于等于右边界
            arr[tempLeft]=temp[t];
            tempLeft++;
            t++;
        }

    }
}
