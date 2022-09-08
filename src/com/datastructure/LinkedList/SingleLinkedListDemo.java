package com.datastructure.LinkedList;

/**
 * @author binbin
 * @date 2022年09月08日  下午4:30
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

    }
}

/**
 * @author binbin
 * @date 2022/9/8 下午4:30
 * 定义一个链表的单个节点的结构
 */
class ListNode{
    /**表示人物的具体序号*/
    private int no;
    /**表示人物的名字*/
    private String name;
    /**表示人物的昵称*/
    private String nickName;
    /**表示节点的下一个节点*/
    private ListNode next;

    /**
     * @author binbin
     * @date 2022/9/8 下午4:34
     * @param no
     * @param name
     * @param nickName
     * 表示初始化该链表节点
     */
    public ListNode(int no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    /**
     * @author binbin
     * @date 2022/9/8 下午4:36
     * @return java.lang.String
     * 为了方便显示节点的内容，重写toString方法
     */
    @Override
    public String toString() {
        return "ListNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'';
    }
}

/**
 * @author binbin
 * @date 2022/9/8 下午4:38
 * 定义一个单链表类，用来创建单链表
 */
class SingleLinkedList{
    /**初始化头节点,并且需要保证头节点保持不动，不存放具体数据*/
    private ListNode headNode=new ListNode(0,"","");

    /**
     * @author binbin
     * @date 2022/9/8 下午4:41
     * @param node  要添加的节点
     * 添加节点到链表的方法
     *  当不考虑顺序的时候，
     * 1.首先需要找到链表的最后一个节点
     * 2.将最后一个节点的next域指向新加入的节点
     */
    public void addNode(ListNode node){
        //由于头节点的特殊性，我们需要使用辅助变量
        ListNode temp=headNode;
        //此时需要利用辅助变量来遍历整个链表找到链表的最后一个节点
        while (true){
            if (temp.getNext()==null){
                //如果temp节点的下一个节点为null，则表示temp此时已经是最后的节点了。
                break;
            }
            //如果没有找到最后，则向后移动temp
            temp=temp.getNext();
        }
        //当退出while循环的时候，temp就是最后一个节点
        //此时将最后一个节点指向新传入的节点即可
        temp.setNext(node);


    }

    /**
     * @author binbin
     * @date 2022/9/8 下午5:00
     * 通过遍历来显示链表
     * 1.首先判断链表是否为空
     * 2.不为空，则表示链表中有元素，则使用辅助变量来遍历链表，从链表的第一个元素开始，
     * 即 ListNode temp=headNode.getNext();
     * 3.遍历终止条件为临时变量为null，此时退出循环
     */
    public void list(){
        //如果头节点的下一个节点为null则表示为空
        if (headNode.getNext()==null){
            throw new RuntimeException("链表为空，无法遍历！");
        }

        //如果不为空，由于头节点的特殊性，此时需要使用辅助变量来遍历链表
        ListNode temp=headNode.getNext();
        while (true){
            //如果遍历到了最后，则temp为空
            if (temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp=temp.getNext();
        }
    }

}