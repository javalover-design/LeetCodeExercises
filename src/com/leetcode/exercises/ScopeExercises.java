package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin
 * @date 2022年06月10日  下午8:00
 */
public class ScopeExercises {

    public static void main(String[] args) {
        System.out.println(new ScopeExercises().intIsEven(5));
        System.out.println("====================");
        List<Integer> even = new ScopeExercises().isEven(500);
        for (Integer integer : even) {
            System.out.println(integer);
        }
    }

    public boolean intIsEven(int n){
        //if (n%2==1){
        //    return false;
        //}
        //return true;
        return n%2==1? false:true;
    }

    public List<Integer> isEven(int n){
        List<Integer> list=new ArrayList<>();
        if (n%2==0){
            for (int i=0;i<=n;i++){
                if (i%2==0){
                    list.add(i);
                }
            }
            return list;

        }

        return null;
    }
}
