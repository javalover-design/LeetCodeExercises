package com.leetcode.LeetCodeRecursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lambda
 * 题目：假设需要爬楼梯，需要爬n阶才能到楼顶
 * 每次只能一步爬1阶或者2阶，有多少种不同的方法可以爬到楼顶？
 * 分析：
 * 当只有1层的时候，result=1 （1阶）
 * 当有2层的时候，result=2 （1阶+1阶，2阶）
 * 当有3层的时候，result=3 （1阶+1阶+1阶，1阶+2阶，2阶+1阶）
 * .......
 * 当最后只有一阶的时候，只有一种走法，1阶
 * 当最后只有两阶的时候，有两种走法，1阶段+1阶或者2阶
 *
 * 此题目主要考察递归的实现
 *
 */
public class ClimbStairs {

    /**
     * 集合用于存储已经计算过的n阶的总的走法
     */
    private Map<Integer, Integer> map=new HashMap<>();
    int result=0;
    public int climbStairs(int n){
        //如果是位于最后一阶或者最后二阶，则不再需要使用递归，直接返回
        if (n==1){return 1;}
        if (n==2){return 2;}
        //判断n是否在map集合中
        if (null!=map.get(n)){
            //在则直接返回
            return map.get(n);
        }else {
            //不在则计算之后放入map中，以便下次使用
            result=climbStairs(n-1)+climbStairs(n-2);
            map.put(n,result);
            return result;
        }
    }

    /**
     * 使用循环来实现爬楼梯
     * @param n
     * @return
     */
    public int climbStairs2(int n){
        if (n==1){return 1;}
        if (n==2){return 2;}
        int result=0;
        int pre=2;
        int perPre=1;
        for (int i=3;i<=n;i++){
            result=perPre+pre;
            perPre=pre;
            pre=result;
        }

        return result;
    }

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(5));
        System.out.println(new ClimbStairs().climbStairs2(3));

    }

}
