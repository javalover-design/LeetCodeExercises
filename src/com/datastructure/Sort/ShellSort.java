package com.datastructure.Sort;

import java.util.Arrays;

/**
 * @author binbin
 * @date 2022年09月27日  下午8:25
 */
public class ShellSort {
    public static void main(String[] args) {
        //int[] arr={1,9,8,6,4,-4};
        int[] arr=new int[800000];
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000);
        }
        System.out.println("==============排序前=========");
        long start=System.currentTimeMillis();
       // shellSortWithExchange(arr);
        shellSort(arr);
        long end=System.currentTimeMillis();
        System.out.println("用时"+(end-start)+"ms");
        //System.out.println(Arrays.toString(arr));
    }

    /**
     * @author binbin
     * @date 2022/9/27 下午8:26
     * @param arr
     * 使用交换法完成希尔排序
     */
    public static void shellSortWithExchange(int[] arr){
        int temp=0;
        for(int gap=arr.length/2;gap>0;gap/=2){
            //此层循环表示定义对应的分组的步长，步长的计算方式为取半
            for (int i=gap;i<arr.length;i++){
                //此层循环表示从对应的步长开始一直到数组的末尾（为了向前寻找对应的数）;即组中相对靠后的数
                for (int j=i-gap;j>=0;j-=gap){
                    //内层循环表示从对应i开始的位置向前寻找gap位置的数，将其与之后的数进行比较；即组中相对靠前的元素
                    if (arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }

            }
        }

    }

    /**
     * @author binbin
     * @date 2022/9/30 下午3:37
     * @param arr
     */
    public static void shellSort(int[] arr){
        for (int gap=arr.length/2;gap>0;gap/=2){
            //定义对应的步长规范
            for (int i=gap;i<arr.length;i++){
                //表示循环从gap位置开始向后进行循环
                //定义两个变量，用来保存初始位置的下标与值
                int index=i;
                int temp=arr[index];
                if (arr[index]<arr[index-gap]){
                    //如果当前位置的数小于其前步长个单位的数，则需要进行移动
                    while (index-gap>=0 && temp<arr[index-gap]){
                        //当index-gap向前移动不越界以及对应的temp始终小于其之前n个步长的数
                        //满足的将index之前的数赋值给index（靠后的数）
                        arr[index]=arr[index-gap];
                        //同时将index前移动gap个位置
                        index-=gap;
                    }
                    //当循环中断表明找到了temp的位置，此时下标为index（index始终向前移动步长个位置）
                    arr[index]=temp;
                }

            }
        }
    }
}
