package com.leetcode.ArraySolution;

/**
 * @author lambda
 * 给定一个数组num，编写一个函数将该数组中的0元素移动到数组的末尾，并且同时保持非0元素的
 * 相对顺序
 * 例如：数组mum：{1，0,2,6，0}，排序后变为{1,2,6,0,0}
 */
public class LeetCodeMoveZeroArray {

    public  void moveZero(int[] nums){
        if (nums==null){
            return;
        }

        //定义一个局部变量从0开始
        int j=0;
        //定义一个变量i也从0开始遍历，要小于数组的长度
        //并且j记录的是非0元素的个数，只要nums[i]非0,则直接赋值给nums[j++]，并且赋值完成后j++
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[j++]=nums[i];
            }
        }

        //赋值完成后，将从j开始到最后的元素都赋值为0
        for (int k=j;k<nums.length;k++){
            nums[k]=0;
        }
    }


}
