package com.datastructure.Sort;

import java.util.Arrays;

/**
 * @author binbin
 * @date 2022年09月27日  下午2:15
 */
public class BubbleSort {

    public static void main(String[] args) {
        //int[] arr={3,9,-1,10,-2,5,-4,-9};
        //    bubbleSort(arr);
        //System.out.println(Arrays.toString(arr));

        int[] arr=new int[80000];
        for (int i=0;i<arr.length;i++){
                arr[i]=(int)(Math.random()*80000);
        }
        System.out.println("排序前.......");
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("排序后耗费时间："+(end-start)+"ms");

    }


    /**
     * @author binbin
     * @date 2022/9/27 下午7:50
 * @param arr
     */
    public static void bubbleSort(int[] arr){
        //作为临时变量
        int temp=0;
        //判断是否已经有序了
        boolean flag=false;
        for (int i=0;i<arr.length-1;i++){
            //总共进行arr.length-1次冒泡
            for (int j=0;j<arr.length-1-i;j++){
                //每进行过一次排序就获取了最大的值，对应只需要比较上次的次数减少1
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if (!flag){
                break;
            }else{
                //进行重置，否则一旦进行一次换位之后就会一直是true
                flag=false;
            }
        }
    }

}
