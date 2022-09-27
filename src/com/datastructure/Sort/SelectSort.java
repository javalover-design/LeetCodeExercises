package com.datastructure.Sort;

import java.util.Arrays;

/**
 * @author binbin
 * @date 2022年09月27日  下午6:32
 */
public class SelectSort {
    public static void main(String[] args) {
        //int[] arr={3,9,1,5,2,15,-5};
        //selectSort(arr);
        //System.out.println(Arrays.toString(arr));
        int[] arr=new int[80000];
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*80000);
        }
        System.out.println("排序前.......");
        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("排序后耗费时间："+(end-start)+"ms");
    }


    /**
     * @author binbin
     * @date 2022/9/27 下午7:42
 * @param arr
     */
    public static void selectSort(int[] arr){
        int selectIndex=0;
        int selectNum=0;
        for (int i=0;i<arr.length-1;i++){
            selectIndex=i;
            selectNum=arr[i];
            for (int j=i+1;j<arr.length;j++){
                //从i+1开始比较，一直比到arr.length-1的位置
               if (selectNum>arr[j]){
                   selectIndex=j;
                   selectNum=arr[j];
               }

            }
            if (selectIndex!=i){
                arr[selectIndex]=arr[i];
                arr[i]=selectNum;
            }

        }
    }
}
