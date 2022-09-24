package com.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author binbin
 * @date 2022年09月24日  下午2:30
 */
public class InfixToSuffix {
    public static void main(String[] args) {
        String infixExpression="1+((2+3)*4)-5";
        List<String> strings = infixToListString(infixExpression);
        System.out.println("中缀表达式："+strings);
        List<String> suffixList = infixListToSuffixList(strings);
        System.out.println("后缀表达式："+suffixList);
    }


    /**
     * @author binbin
     * @date 2022/9/24 下午2:31
     * @param infixExpression 中缀表达式字符串
     * @return java.util.List<java.lang.String> 返回的一个集合
     */
    public static List<String> infixToListString(String infixExpression){
        List<String> infixList=new ArrayList<String>();
        //表示一个指针，用来遍历整个字符串的
        int i=0;
        //定义一个字符串，用于多位数的拼接
        String str;
        //定义一个字符，用于存储每次遍历的字符
        char ch=' ';
        do {
            //如果ch不是一个数字，而是一个符号的话，则需要进行将其加入到集合中
            if ((ch=infixExpression.charAt(i))<48 || (ch=infixExpression.charAt(i))>57){
                //直接将符号人集合
                infixList.add(""+ch);
                i++;
            }else{
                str="";
                //表明是数字，此时仍旧需要判断是否是多位数
                while (i<infixExpression.length() && (ch=infixExpression.charAt(i))>=48 && (ch=infixExpression.charAt(i))<=57){
                        //表明是数字并且是多位数，则拼接
                    str+=ch;
                    i++;

                }
                infixList.add(str);
            }


        }while (i<infixExpression.length());
        return infixList;
    }

    /**
     * @author binbin
     * @date 2022/9/24 下午3:02
     * @param infixList 中缀表达式集合
     * @return java.util.List<java.lang.String> 后缀表达式集合
     * 利用一个方法将中缀表达式集合转为后缀表达式集合
     */
    public static List<String> infixListToSuffixList(List<String> infixList){
        //定义后缀表达式集合
        List<String> suffixList = new ArrayList<>();
        //定义一个栈，用于存储符号
        Stack<String> operatorStack = new Stack<>();
       //由于第二个存储临时变量的栈从未有过出栈操作，那么可以直接使用集合list来替代
        List<String> temp = new ArrayList<>();

        for (String item:infixList){
            //如果对应的项是一个数字，则直接进入集合即可
            if (item.matches("\\d+")){
                temp.add(item);
            }else if (item.equals("(") || operatorStack.isEmpty()){
                //如果是左括号，也直接进行入栈
                operatorStack.push(item);
            }else if (item.equals(")")){
                //如果是右括号，那么需要依次弹出符号栈的内容，压入到临时变量中去，直到遇到左括号
                while (!operatorStack.peek().equals("(")){
                        temp.add(operatorStack.pop());
                }
                //因为是遇到左括号弹出，因此最后循环结束也需要将左括号弹出
                operatorStack.pop();
            }else {
                //当item的优先级小于等于符号栈栈顶元素的优先级，则将符号栈栈顶元素弹出加入到temp中，并继续比较
                while (operatorStack.size()!=0 && Operation.getValue(operatorStack.peek())>=Operation.getValue(item)){
                    //此时需要将符号栈的内容弹出到temp中，循环进行直到栈顶元素小于item
                    temp.add(operatorStack.pop());
                }
                //最后循环结束还需要将当前的符号压入栈中
                operatorStack.push(item);
            }

        }
        //遍历完毕之后需要将符号栈中的内容依次加入temp中，使用while循环完成
        while (operatorStack.size()!=0){
            temp.add(operatorStack.pop());
        }
        suffixList=temp;
        return suffixList;
    }
}

class Operation{
    private static final int ADD=1;
    private static final int SUB=1;
    private static final int MUL=2;
    private static final int DIV=2;

    public static int getValue(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            default:
                System.out.println("不是对应的可运算符号");
                break;
        }
        return result;
    }
}
