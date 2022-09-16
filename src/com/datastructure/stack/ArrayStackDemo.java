package com.datastructure.stack;

/**
 * @author binbin
 * @date 2022年09月16日  下午7:53
 */
public class ArrayStackDemo {
    public static void main(String[] args) {

    }
}

/**
 * @author binbin
 * @date 2022/9/16 下午7:53
 * 定义一个类表示栈结构
 */
class ArrayStack{

    /**栈的最大容量*/
    private int maxSize;
    /**使用数组来模拟栈*/
    private int[] array;
    /**栈顶指针，初始状态为-1*/
    private int top=-1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array=new int[this.maxSize];
    }

    /**
     * @author binbin
     * @date 2022/9/16 下午7:58
     * @return boolean
     * 判断栈满的方法，如果top与maxSize-1的值相等，则表示栈满
     */
    public boolean isFull(){
        return top==maxSize-1;
    }

    /**
     * @author binbin
     * @date 2022/9/16 下午7:59
     * @return boolean
     * 判断栈空的方法，如果top==-1则表示栈为空
     */
    public boolean isEmpty(){
        return top==-1;
    }


    /**
     * @author binbin
     * @date 2022/9/16 下午8:01
     * @param num
     * 入栈的方法，首先指针后移一位，将数据赋值即可
     */
    public void push(int num){
        if (isFull()){
            throw new RuntimeException("栈已经满，无法再加入数据");
        }
        top++;
        array[top]=num;
    }


    /**
     * @author binbin
     * @date 2022/9/16 下午8:03
     * @return int
     * 出栈的方法
     */
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈暂时为空，无法删除数据元素");
        }

        int value=array[top];
        top--;
        return value;
    }

    public void listStack(){
        if (isEmpty()){
            throw new RuntimeException("栈暂时为空，无法进行遍历");
        }
        //栈的遍历需要从栈顶开始，依次显示数据
        for (int i= top;i>=0;i--){
            System.out.println("栈的元素为："+array[i]);

        }
    }
}
