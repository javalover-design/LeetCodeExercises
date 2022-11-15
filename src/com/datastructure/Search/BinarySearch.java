package com.datastructure.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin
 * @date 2022年11月15日  下午8:41
 * 二分查找的数组必须要求是有序的
 */
public class BinarySearch {
    public static void main(String[] args) {
            int[] sortedArray={1,8,10,89,1000,1000,1234};
        List<Integer> list = binarySearchWithReturnArray(sortedArray, 0, sortedArray.length - 1, 1000);
        System.out.println(list);

    }

    /**
     * @author binbin
     * @date 2022/11/15 下午8:45
     * @param array 需要进行二分查找的数组
     * @param left 左边界（会随着递归的深入不断变化）
     * @param right 右边界（会随着递归的深入而不断变化）
     * @param findValue  需要查找的值
     * @return int 返回待查找值的下标（找到）
     * 针对单一数值的查找
     */
    public static int binarySearch(int[] array,int left,int right,int findValue){
        //找到中间值的下标
        int mid=(left+right)/2;
        int midValue=array[mid];
        //如果left比right大，则需要跳出递归，即出现了不合理的情况
        if (left>right){
            return -1;
        }
        //向右递归
        if (findValue>midValue){
            return binarySearch(array,mid+1,right,findValue);
        }
        //向左递归
        if (findValue<midValue){
            return binarySearch(array,left,mid-1,findValue);
        }
        //如果相等，则直接返回下标
        return mid;
    }


    /**
     * @author binbin
     * @date 2022/11/15 下午9:12
     * @param array
     * @param left
     * @param right
     * @param findValue
     * @return int[] 返回符合下标值的数组，没有返回为null
     */
    public static List<Integer> binarySearchWithReturnArray(int[] array, int left, int right, int findValue){
        //找到中间值的下标
        int mid=(left+right)/2;
        int midValue=array[mid];
        List<Integer> indexs = new ArrayList<>();
        //如果left比right大，则需要跳出递归，即出现了不合理的情况
        if (left>right){
            return new ArrayList<Integer>();
        }
        //向右递归
        if (findValue>midValue){
            return binarySearchWithReturnArray(array,mid+1,right,findValue);
        }
        //向左递归
        if (findValue<midValue){
            return binarySearchWithReturnArray(array,left,mid-1,findValue);
        }
        //此时表示mid对应的值和要找值相等
        //向左移动
        int tempLeft=mid-1;
        while (true){
            if (tempLeft<0 || array[tempLeft]!=findValue){
                //此时表示不满足条件的情况：小于0或者对应值不符合
                break;
            }
            indexs.add(tempLeft);
            tempLeft--;
        }
        indexs.add(mid);
        int tempRight=mid+1;
        while (true){
            if (tempRight>array.length-1 || array[tempRight]!=findValue){
                break;
            }
            indexs.add(tempRight);
            tempRight++;
        }
        return indexs;
    }
}
