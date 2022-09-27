package com.datastructure.Sort;

import java.util.Arrays;

/**
 * @author binbin
 * @date 2022年09月27日  下午7:33
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={3,9,-1,10,-2,5,-4,-9};
        insertSelect(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * @author binbin
     * @date 2022/9/27 下午7:34
     * @param arr  
     */
    public static void insertSelect(int[] arr){

       for (int i=1;i<arr.length;i++){
           //表示从第二个元素开始进行插入，直到最后一个元素
           //待插入的值是第二个元素开始，依次向后推
           int insertVal=arr[i];
           //待插入的下标是插入值的前一个元素
           int insertIndex=i-1;
           while (insertIndex>=0 && insertVal<arr[insertIndex]){
               //需要满足插入的下标是大于等于0,表示不会越界，同时待插入的值小于其前一个元素，之后两者进行交换
               //表示待插入下标位置的元素（即待插入值的前一个元素）将插入到待插入元素的位置，并且，插入的下标继续向前移动
               //并且需要满足下标不小于0
               arr[insertIndex+1]=arr[insertIndex];
               insertIndex--;

           }
           //当while循环结束之后，需要彻底交换元素(+1是因为出while循环insertIndex小于0了)
           if (insertIndex+1!=i) {
               arr[insertIndex + 1] = insertVal;
           }

       }
        
    }
}
