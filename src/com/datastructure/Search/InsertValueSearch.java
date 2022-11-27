package com.datastructure.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author binbin
 * @date 2022年11月27日  上午11:45
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        //int[] arr=new int[100];
        //for (int i = 0; i <arr.length ; i++) {
        //    arr[i]=i+1;
        //}
        //
        //int index=insertValueSearchWithReturnOneValue(arr,0,arr.length-1,100);
        //System.out.println(index);
        int [] arr=new int[]{1,2,2,2,6,9,98};
        List<Integer> list = insertValueSearchWithReturnValues(arr, 0, arr.length - 1, 2);
        System.out.println(list.toString());
    }

    /**
     * @author binbin
     * @date 2022/11/27 上午11:49
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return int
     */
    public static int insertValueSearchWithReturnOneValue(int[] arr,int left,int right,int findValue){
        if (left>right|| findValue<arr[0]|| findValue>arr[arr.length-1]){
           return -1;
        }

        int mid=left+(right-left)*((findValue-arr[left])/(arr[right]-arr[left]));
        int midValue=arr[mid];
        if (findValue>midValue){
            return insertValueSearchWithReturnOneValue(arr,mid+1,right,findValue);
        }else if (findValue<midValue){
            return insertValueSearchWithReturnOneValue(arr,left,mid-1,findValue);
        }else{
            return mid;
        }
    }

    /**
     * @author binbin
     * @date 2022/11/27 下午12:06
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return java.util.List
     */
    public static List<Integer> insertValueSearchWithReturnValues(int[] arr,int left,int right,int findValue){
        List<Integer> integers = new ArrayList<>();
        if (left>right || findValue<arr[0] || findValue>arr[arr.length-1]){
            integers.add(-1);
            return integers;
        }
        int mid=left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
        int midValue=arr[mid];
        if (findValue>midValue){
            return insertValueSearchWithReturnValues(arr,mid+1,right,findValue);
        }else if (findValue<midValue){
            return insertValueSearchWithReturnValues(arr,left,mid-1,findValue);
        }else{
            integers.add(mid);
            //此时需要进行前后查找是否有相同的数
            int tempLeft=mid-1;
            while (true){
                if (tempLeft<0 || arr[tempLeft]!=findValue){
                    break;
                }
                integers.add(tempLeft);
                tempLeft--;
            }
            int tempRight=mid+1;
            while (true){
                if (tempRight>arr.length-1||arr[tempRight]!=findValue){
                    break;
                }
                integers.add(tempRight);
                tempRight++;
            }

            return integers;
        }

    }
}
