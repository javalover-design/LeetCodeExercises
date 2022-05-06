package com.leetcode.ArraySolution;

/**
 * @author lambda
 * 找到所有数组中消失的数字
 * 给定一个含n个整数的数组num，其中mum[i]在1-n之间
 * 找出所有在1-n之间，但是没有出现在num数组中的所有数字，并以数组形式返回
 * 例如： 4 3 2 7 8 2 3 1 （1-8）
 * 需要返回的就是5，6
 */
public class LeetCodeFindNumArray {

   public static int[]  findDisappearedNum(int[] nums){
       //
       int[] results=new int[]{};
       if (nums==null){
           return results;
       }

       for (int i=0;i<nums.length;i++){
           if (nums[i]-1<nums.length){
              nums[nums[i]-1]=-nums[nums[i]-1];
              //nums[nums[i]-1]=nums[nums[i]-1]>0 ? -nums[nums[i]-1] : 0;
           }
       }

       int i=0;
       for (int j=0;j<nums.length;j++){
           if (nums[j]>0){
                results[i++]=j+1;
           }
       }

       return results;
   }


    //public static void main(String[] args) {
    //   int[] nums=new int[]{4 ,3 ,2, 7, 8, 2, 3, 1};
    //    int[] disappearedNum = LeetCodeFindNumArray.findDisappearedNum(nums);
    //    for (int i: disappearedNum){
    //        System.out.println(disappearedNum[i]);
    //    }
    //}

}
