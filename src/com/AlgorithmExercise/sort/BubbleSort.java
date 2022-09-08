package com.AlgorithmExercise.sort;

/**
 * @author binbin
 * @date 2022年09月08日  下午7:56
 * 冒泡排序算法：
 * 1. 从数组的第一个元素开始，跟其后面一个元素比较，如果大于后面一个元素，则交换位置，如果小于或者等于，则保持位置不变。
 * 2.需要用到两层循环，外层循环控制冒泡的轮数，如果数组的大小是maxSize，则冒泡次数为maxSize-1次。内层循环表示正式的冒泡
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr=new int[]{1,5,6,9,7};
        bubbleSortPlus(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }


    /**
     * @author binbin
     * @date 2022/9/8 下午8:12
     * @param arr
     * 冒泡排序算法
     */
    public static void bubbleSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            //表示循环的轮数
            for (int j=0;j<arr.length-1-i;j++){
                //表示一次冒泡要比较的比较的次数 假设5个数参与排序
                //i =0 j=0,1,2,3  4   比较4次
                //i=1 j=0，1,2     4-i=4-1=3    比较3次
                if (arr[j]>arr[j+1]){
                    //如果前一个元素大于后一个元素，则交换位置
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
             }

        }
    }

    /**
     * @author binbin
     * @date 2022/9/8 下午8:36
     * 冒泡排序的优化
     * 如果在某一轮比较中没有进行过一次交换元素，则说明该数组已经是有序的，则无序再进行后续的冒泡
     */
    public static void  bubbleSortPlus(int[] arr){
        //定义一个标志，用于验证是否进行了元素交换顺序
        boolean flag=true;
        //表示冒泡的论次，依旧保持不变
        for (int i=0;i<arr.length-1;i++){

            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    flag=false;
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            //如果冒泡过程中没有交换过元素的顺序，那么证明已经是有序的了，可以直接退出循环，避免重复循环
            if (flag){
                break;
            }


        }
    }
}