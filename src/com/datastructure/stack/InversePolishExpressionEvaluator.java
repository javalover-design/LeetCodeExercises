package com.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author binbin
 * @date 2022年09月24日  下午1:22
 */
public class InversePolishExpressionEvaluator {
    public static void main(String[] args) {
         //首先定义逆波兰表达式
        String suffixExpression="3 4 + 5 * 6 -";
        List<String> listString = getListString(suffixExpression);
        int calculate = calculate(listString);
        System.out.println(calculate);

    }

    /**
     * @author binbin
     * @date 2022/9/24 下午1:27
     * @param suffixExpression 逆波兰表达式
     * @return java.util.List<java.lang.String> 返回一个集合
     * 将逆波兰表达式中的所有内容都放入ArrayList中
     */
    public static List<String> getListString(String suffixExpression){
        //首先将逆波兰表达式按照空格分隔成为一个数组
        String[] s = suffixExpression.split(" ");
        List<String> expressionList=new ArrayList<>();
        for (String e:s){
            expressionList.add(e);
        }
        return expressionList;
    }

    /**
     * @author binbin
     * @date 2022/9/24 下午1:33
     * @param suffixExpressionToList 集合，存放逆波兰表达式的内容
     * @return int 返回的计算结果
     * 定义一个方法计算逆波兰表达式
     * 1.首先定义一个栈，用来存数
     * 2.从左至右扫描，只要遇到数字就入栈，遇到符号就将栈中的数字弹出两个（栈顶和次顶），结合符号运算，将结果入栈
     * 3.重复最后得到的结果即为计算的结果
     */
    public static  int  calculate(List<String> suffixExpressionToList){
            //创建一个存数的栈
        Stack<String> numberStack = new Stack<>();
        //遍历整个list集合，获取其中的元素
        for (String item : suffixExpressionToList) {
            //使用正则表达式来取出数
            if (item.matches("\\d+")){
                // \\d+表示匹配多位数，
                numberStack.push(item);
            }else{//此时表明是个符号了，需要进行多重循环判断
                //首先弹出两个数(后弹出的数减去前面弹出的数，下减上)
                int num1=Integer.parseInt(numberStack.pop());
                int num2=Integer.parseInt(numberStack.pop());
                int result=0;
                if (item.equals("+")){
                    result=num1+num2;
                }else if (item.equals("*")){
                    result=num1*num2;
                }else if (item.equals("-")){
                    result=num2-num1;
                }else if (item.equals("/")){
                    result=num2/num1;
                }else {
                    throw new RuntimeException("符号非法，请重新输入....");
                }

                numberStack.push(result+"");
            }
        }

        //最后留在栈中的就是数据的运算结果
        return Integer.parseInt(numberStack.pop());
    }
}
