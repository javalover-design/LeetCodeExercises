package com.datastructure.Sort;

import java.util.Arrays;

/**
 * @author binbin
 * @date 2022年10月01日  下午10:13
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2};
        int[] temp=new int[arr.length];
        System.out.println("排序前");
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }

    /**
     * @author binbin
     * @date 2022/10/1 下午10:58
     * @param arr 待排序的数组
     * @param left 左边界
     * @param right 右边界
     * @param temp  临时数组
     *  对数组进行拆分之后进行合并
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left<right){
            //只要左指针始终小于右指针，则表示可以继续分
            //取左右两个中间的索引
            int mid=(left+right)/2;
            //向左进行递归分解
            mergeSort(arr,left,mid,temp);
            //向右进行递归分解
            mergeSort(arr,mid+1,right,temp);
            //分解之后就进行合并
            merge(arr,left,mid,right,temp);

        }

    }
    /**
     * @author binbin
     * @date 2022/10/1 下午10:18
     * @param arr 合并的数组
     * @param left 左边有序数组的左指针
     * @param mid 中间索引 (右边有序数组的前一个位置)
     * @param right 右边有序数组的右指针
     * @param temp  临时数组
     * 编写合并的方法
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        //i表示左边有序数组的初始索引（后续会变化）
        int i=left;
        //j表示右边有序数组的初始索引（后续会变化）
        int j=mid+1;
        //t表示临时数组temp的下标
        int t=0;

        //将左右两边有序数组的所有值都拷贝到temp数组中，终止条件是左右两边有一方处理完毕为止
        while (i<=mid && j<=right){
            //此时表示没有结束
            if (arr[i]<=arr[j]){
                //如果左边元素小于等于右边元素，则将左边元素放入temp中，并移动指针
                temp[t]=arr[i];
                i++;
                t++;
            }else{
                temp[t]=arr[j];
                j++;
                t++;
            }
        }

        //如果有剩余则将后续的值全部拷贝到temp数组中去即可
        while (i<=mid){
            //如果i小于等于mid，则将剩余元素填充到数组中
            temp[t]=arr[i];
            i++;
            t++;
        }
        while (j<=right){
            temp[t]=arr[j];
            j++;
            t++;
        }

        //将temp数组重新拷贝到arr中去即可(需要注意的是并不是每次拷贝8个)
        //将数组下标初始化为0,用来拷贝到arr中去
        t=0;
        //表示待拷贝数组的下标
        int tempLeft=left;
        while (tempLeft<=right){
            //只要从左边开始的索引一直没有超过数组的边界，则可以继续拷贝
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }




    }
}
