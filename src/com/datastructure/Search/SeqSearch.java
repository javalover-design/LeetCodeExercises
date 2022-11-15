package com.datastructure.Search;

/**
 * @author binbin
 * @date 2022年11月13日  下午9:43
 */
public class SeqSearch {
    public static void main(String[] args) {
            int[] arr={1,9,11,-1,34,89};
        System.out.println(seqSearchForValues(arr, 1));

    }

    /**
     * @author binbin
     * @date 2022/11/13 下午9:50
     * @param arr 数组
     * @param value 值
     * @return int
     * 此处实现的线性查找是找到一个值就直接返回该值对应的下标
     */
    public static int seqSearchForValues(int[] arr,int value){
        //线性查找是指逐一比对，发现有相同的结果则直接返回对应的下标即可
        int i;
        for ( i = 0; i < arr.length; i++) {
            if (arr[i]==value){
                //查找到直接返回对应的下标
                return i;
            }
        }
        //没有找到则直接返回-1
     return -1;
    }

}
