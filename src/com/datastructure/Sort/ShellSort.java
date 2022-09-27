package com.datastructure.Sort;

/**
 * @author binbin
 * @date 2022年09月27日  下午8:25
 */
public class ShellSort {
    public static void main(String[] args) {

    }

    /**
     * @author binbin
     * @date 2022/9/27 下午8:26
     * @param arr
     */
    public static void shellSort(int[] arr){
        int insertVal=0;
        int insertIndex=0;
        //使用一个循环来表示步长的变化
        for (int gap=arr.length/2;gap>0;gap/=2){
            //gap步长表示比较的小组的个数
          for (int i=gap;i<arr.length;i++){
              insertVal=arr[i];
              insertIndex=i-gap;
              while (insertIndex>=0 && arr[insertIndex]>insertVal){
                  arr[insertIndex+gap]=arr[insertIndex];
                  insertIndex-=gap;
              }
              if (insertIndex+gap!=i){
                 arr[insertIndex+gap]=insertVal;
              }
          }

        }

    }
}
