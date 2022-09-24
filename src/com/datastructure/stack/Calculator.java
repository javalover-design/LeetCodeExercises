package com.datastructure.stack;

/**
 * @author binbin
 * @date 2022年09月23日  下午2:40
 * 利用栈来实现一个计算器，计算一个表达式的值
 */
public class Calculator {

    public static void main(String[] args) {
        //要计算的表达式
        String expression="30+2*6-2";
        //创建两个栈，一个是数栈，一个是符号栈
        ArrayStack2 numberStack = new ArrayStack2(10);
        ArrayStack2 operatorStack = new ArrayStack2(10);
        //定义相关的变量
        int index=0;
        int num1=0;
        int num2=0;
        int operator=0;
        int result=0;
        //将每次扫描到的字符char存入ch中
        char ch=' ';
        //定义一个字符串用来拼接扫描到的数字
        String keepNum="";
        //使用while语句循环扫描expression
        while (true){
            //依次得到字符串中的每一个字符 ,前者表示取出一个字符，后者将该字符串的第一个位置转为字符
            ch=expression.substring(index,index+1).charAt(0);
            //如果是一个操作符，则进行相关操作
            if (operatorStack.isOperator(ch)) {
                //如果当前的符号栈不为空，则继续进行比较，首先比较优先级
                if (!operatorStack.isEmpty()) {
                    if (operatorStack.priority(ch) <= operatorStack.priority(operatorStack.peek())) {
                        //如果栈顶的优先级大于等于即将入栈的优先级，则需要弹出元素并进行运算后在进行入栈
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        operator = operatorStack.pop();
                        //将弹出的元素与符号进行运算，再将结果入数栈
                        result = numberStack.calculator(num1, num2, operator);
                        numberStack.push(result);
                        //将当前的符号入符号栈
                        operatorStack.push(ch);
                    } else {
                        //如果当前符号的优先级大于栈顶符号的优先级，直接入栈
                        operatorStack.push(ch);
                    }

                }else{
                    //如果符号栈为空，则进行直接入栈
                    operatorStack.push(ch);
                }
            }else{
                ////由于扫描到的是字符，根据ASCII码表，字符和数字相差48,即字符+48为数字
                //numberStack.push(ch-48);
                keepNum+=ch;
                //如果需要入数字栈需要判断是否是多位数的，如果是多位数，则需要一直扫描，直到遇见符号为止。
                if (index==expression.length()-1){
                    //如果当前的字符位置在最后一位，则可以直接入数栈，不需再看后面一位
                    numberStack.push(Integer.parseInt(keepNum));
                }else {
                    //如果当前字符的下一个字符为操作符号，则表示可以入栈
                    if (operatorStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        //真正要存入数栈的是和ch字符结合的字符串
                        numberStack.push(Integer.parseInt(keepNum));
                        //keepnum需要清空
                        keepNum="";

                    }
                }
            }


            //index++，并判断是否扫描到最后一个元素了
            index++;
            if (index>=expression.length()){
                //如果index大于等于字符串长度，表示已经到最后了，
                // 直接退出循环（之所以等于，是因为index从0开始，最大扫描到length-1为末尾）
                break;
            }
        }
        //入栈操作结束之后，可以将所有元素弹出进行运算
        while (true){
            if (operatorStack.isEmpty()){
                //如果符号栈为空，则表示已经运算结束了,数栈中只有一个结果
                break;
            }
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            operator = operatorStack.pop();
            //将弹出的元素与符号进行运算，再将结果入数栈
            result = numberStack.calculator(num1, num2, operator);
            numberStack.push(result);

        }
        System.out.printf("%s=%d",expression,numberStack.pop());



    }
}

class ArrayStack2{
    /**栈的最大容量*/
    private int maxSize;
    /**使用数组来模拟栈*/
    private int[] array;
    /**栈顶指针，初始状态为-1*/
    private int top=-1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        array=new int[maxSize];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }


    /**
     * @author binbin
     * @date 2022/9/23 下午2:43
     * @return boolean
     * 判断数栈是否已满
     */
    public boolean isFull(){
        return top==maxSize-1;
    }

    /**
     * @author binbin
     * @date 2022/9/23 下午2:44
     * @return boolean
     * 判断数栈是否为空
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * @author binbin
     * @date 2022/9/23 下午2:46
     * @param num
     * 向栈中追加元素
     */
    public void push(int num){
        if (isFull()){
            throw new RuntimeException("栈已经满了，无法再加入元素");
        }

        top++;
        array[top]=num;
    }

    /**
     * @author binbin
     * @date 2022/9/23 下午2:47
     * @return int
     * 从栈中弹出一个元素
     */
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空，无法弹出元素");
        }
        int value=array[top];
        top--;
        return value;
    }

    /**
     * @author binbin
     * @date 2022/9/23 下午2:49
     * 遍历栈内的所有元素
     */
    public void listStack(){
        if (isEmpty()){
            throw new RuntimeException("栈为空，无法进行遍历元素");
        }
        for (int i=top;i>=0;i--){
            System.out.println("栈内的元素有："+array[top]);
        }
    }


    /**
     * @author binbin
     * @date 2022/9/23 下午3:13
     * @return int
     * 查看当前栈顶元素的值，并不是真正的出栈
     */
    public int peek(){
        return array[top];
    }

    /**
     * @author binbin
     * @date 2022/9/23 下午2:52
     * @param operator
     * @return int
     * 定义一个方法用于判断符号的优先级，用数字来表示优先级，数字越大，表明优先级越高
     */
    public int priority(int operator){
        //在java中，int和char在进行运算的时候char会转成int
        if (operator=='*' || operator=='/'){
            return 1;
        }else if (operator=='+' || operator=='-'){
            return 0 ;
        }else{
            return -1;
        }
    }

    /**
     * @author binbin
     * @date 2022/9/23 下午2:56
     * @param operator
     * @return boolean
     * 判断这个字符是否为操作符
     */
    public boolean isOperator(char operator){
        return operator=='+'|| operator=='-' || operator=='*' || operator=='/';
    }

    /**
     * @author binbin
     * @date 2022/9/23 下午2:58
     * @param num1
     * @param num2
     * @param operator
     * @return int
     * 定义一个计算的方法，用于扫描过程中两数的计算
     */
    public int calculator(int num1,int num2,int operator){
        int result=0;
        switch (operator){
            case '+':
                result=num1+num2;
                break;
            case '-':
                result=Math.abs(num2- num1);
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num2/num1;
                break;
            default:
                break;
        }
        return result;
    }
}