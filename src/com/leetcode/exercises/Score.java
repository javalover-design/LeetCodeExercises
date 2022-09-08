package com.leetcode.exercises;

/**
 * @author binbin
 * @date 2022年06月10日  下午8:08
 */
public class Score {
    public static void main(String[] args) {
        System.out.println(new Score().judgeScore(450));
    }


    public String judgeScore(Integer n){
        String str="";
        if (n<0 || n>500){
            str="换一个试试？";
            return str;
        }
        if (n<300){
            str="考不上就二战";
        }else if (n>=300 && n<320){
            str="东华理工欢迎你";
        }else if (n>=320 && n<380){
            str="双一流学校欢迎你";
        }else {
            str="清北欢迎你";
        }
       return str;
    }
}
