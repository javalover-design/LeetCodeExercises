package com.datastructure.stack;

import com.sun.xml.internal.ws.api.model.CheckedException;

import java.util.List;

/**
 * @author binbin
 * @date 2022年09月16日  下午8:20
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {

        ListStack listStack = new ListStack();
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        listStack.push(4);
        listStack.push(5);
        listStack.pop();
        listStack.pop();
        listStack.pop();
        listStack.pop();
        listStack.listStack();


    }
}
class ListNode{
    /**链表的数据*/
    private int no;
    /**链表的下一个节点*/
    private ListNode next;

    private ListNode pre;
    public ListNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPre() {
        return pre;
    }

    public void setPre(ListNode pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "元素{" +
                "no=" + no +
                '}';
    }
}

class ListStack{
    private ListNode top=null;


    public void push(int num){
        ListNode node = new ListNode(num);
        if (top==null) {
           top=node;
        }else {
            node.setPre(top);
            top=node;
        }
        System.out.println("添加完毕"+num);

    }

    public void pop(){
        if (top==null){
            throw new RuntimeException("栈为空，无法弹出元素");
        }
        ListNode node=top;
        top=top.getPre();
        System.out.println("弹出信息为："+node.getNo());
    }

    public void listStack(){
        if (top==null){
            throw new RuntimeException("栈为空，无法遍历");
        }
        while (top!=null){
            System.out.println(top.getNo());
            top=top.getPre();
        }
        System.out.println("遍历完毕！");
    }
}