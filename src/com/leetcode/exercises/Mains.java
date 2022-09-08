package com.leetcode.exercises;

import com.sun.org.apache.xpath.internal.operations.Lt;

import java.util.ArrayList;
import java.util.List;

public class Mains{
    //创建一个方法，使年份返回值为闰年
    public static int[] Year(int[] years) {
        int j=0;
        for(int i=1;i<=2000;i++) {
          if((i%400==0)||(i%4==0&&i%100!=0)) {
              years[j++] = i;

          }
        }

        return years;
        }

    public static void main(String[] args) {
        int[] years=new int[485];
        int[] year = Year(years);
        for (int i : year) {
            System.out.println(i);

        }

    }
}

