package com.leetcode.exercises;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @author binbin
 * @date 2022年06月10日  下午7:52
 */
public class Out {


    public static void main(String[] args) {
        char[] set = new Out().set(new char[8], "ECUT520\"");
        for (char c : set) {
            System.out.println(c);
        }
        System.out.println("=============");
        System.out.println(set.length);
    }





    public char[] set(char[] chars,String instances){
        if (chars.length!=8 || instances==null){
            return null;
        }
        for (int i=0;i<instances.length();i++){
            chars[i]=instances.charAt(i);
        }
        return chars;

    }

}
