package com.leetcode.ArraySolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lambda
 *
 * 给定一个整数数组和一个整数目标值，请在该数组中找出和为目标值的两个整数的下标,以数组的形式返回
 */
public class LeetCodeSumArray {

    /**
     * 此处使用hashmap的解法，利用一个指针指向这个数组的值，查看该值与target相差多少，之后在map
     * 集合中查找对应的差值，如果存在则返回该差值的下标，如果不存在，则将指针所指向的数组的值
     * 存入map集合中，将指针移动到下一位。
     * @param nums
     * @param target
     * @return
     */
    public static int[] sumForTarget(int[] nums,int target){
        /**
         * 定义一个集合来存放对应的数组中的值
         * 并且k表示具体的值
         * v表示在数组中的下标
         */
        Map<Integer, Integer> map=new HashMap<>();

        /**
         * 该数组用于存放符合要求（值和为target）的元素的下标
         */
        int[] results= new int[2];

        for (int i=0;i<nums.length;i++){
            //求出目标值与指针指向数组的值的差
            int another=target-nums[i];
            //返回该差值在集合中的value
            Integer anotherIndex=map.get(another);
            if (null!=anotherIndex){
                //如果差值在集合中存在，那么将差值的value赋值给数组
                results[0]=anotherIndex;
                //将指针指向数组值的下标赋值给数组
                results[1]=i;
            }else{
                //如果不存在，则将该指针所指的数组的值存为集合的key，下标存为集合的value
                map.put(nums[i],i);
            }
        }
        //最终返回这个集合。
        return results;
    }


    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int[] ints = LeetCodeSumArray.sumForTarget(nums, 6);
        System.out.println(ints[0]);
        System.out.println(ints[1]);

    }
}
