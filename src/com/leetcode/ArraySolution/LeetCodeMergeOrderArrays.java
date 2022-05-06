package com.leetcode.ArraySolution;

/**
 * @author lambda
 * 给定两个非递减排序的整数数组num1和num2，另有两个整数m和n分别表示num1和num2的数组元素个数
 * 请合并num2到num1中，使合并后的数组同样采用非递减顺序排列
 * 最终合并后的数组不应该由函数返回，而是存储在num1中，为了应对这种情况，初始num1的长度为m+n，
 * 其中m个元素表示应该合并的元素，后n个元素为0，应该忽略，num2的长度为n
 */
public class LeetCodeMergeOrderArrays {


    /**
     *
     * @param nums1
     * @param m nums1数组长度
     * @param nums2
     * @param n nums2数组长度
     */
    public void merge(int[] nums1,int m,int[] nums2,int n){
        //首先产生m+n大小的数组
        int k=m+n;
        int[] temp=new int[k];

        //之后设置mums1和mums2的两个指针，nums1Index和mums2Index，都是从0开始
        //并且循环变量index必须要小于临时数组的长度
        for (int index=0,nums1Index=0,nums2Index=0;index<k;index++){
            //如果nums1数组的值取完，直接取nums2的数即可直接赋值
            if (nums1Index>=m){
                temp[index]=nums2[nums2Index++];
                //如果nums2的数组值2取完，直接取nums1的即可
            }else if (nums2Index>=n){
                temp[index]=nums1[nums1Index++];
                //如果nums1中的元素小于nums2中的元素，直接将nums1中元素存入临时数组
            }else if (nums1[nums1Index]<nums2[nums2Index]){
                //此处需要自增是因为存入之后，指针需要向后移动
                temp[index]=nums1[nums1Index++];
                //如果nums2的元素小于nums1元素，则将nums2元素直接存入临时数组中
            }else {
                temp[index]=nums2[nums2Index++];
            }

        }

        for (int j=0;j<k;j++){
            nums1[j]=temp[j];
        }



    }

}
