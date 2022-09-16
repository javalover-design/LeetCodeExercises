package com.datastructure.LinkedList;

/**
 * @author binbin
 * @date 2022年09月15日  上午12:31
 * 单向环形链表能够解决约瑟夫问题：
 * 设编号为1,2,3….n的n个人围坐在一圈，约定编号为k（1<=k<=n）的人从1开始报数，
 * 数到m的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，由此产生一个出队编号的序列
 */
public class OneWayRingLinkedListDemo {
    public static void main(String[] args) {
        OneWayRingLinkedList oneWayRingLinkedList = new OneWayRingLinkedList();
        oneWayRingLinkedList.addNodes(5);
        oneWayRingLinkedList.traverseList();

        System.out.println("出链表～");
        oneWayRingLinkedList.countSequence(1,2,5);

    }
}

/**
 * @author binbin
 * @date 2022/9/15 上午12:35
 * 创建环形链表类
 */
class OneWayRingLinkedList{
    /**首先创建一个first节点，类似于头节点，赋予空，后续修改为对应的值，因为此时并不知道谁是第一个节点*/
    private Node first=null;

    /**
     * @author binbin
     * @date 2022/9/15 上午12:38
     * @param nums  要构建的节点的总数量，不能是非法值
     */
    public void addNodes(int nums){
        if (nums<1){
            //表示添加节点，至少需要一个节点
            throw new RuntimeException("传入的nums的值有误，请重新传入！");
        }

        //定义一个辅助变量来实现节点的加入
        Node cur =null;
        //使用for循环创建环形链表
        for (int i=1;i<=nums;i++){
            //根据编号i创建对应的节点
            Node node= new Node(i);
            //由于第一个节点比较特殊（会指向自己）
            if (i==1){
                //即将first指向了编号为1的节点
                first=node;
                //第一个节点会自己指向自己，形成一个环形
                first.setNext(first);
                //将cur指针指向第一个节点
                cur=first;
            }else {
                //如果不是第一个节点，则需要利用cur来实现节点插入
                //当前节点的下一个节点是新节点
                cur.setNext(node);
                //新节点的下一个节点是first节点
                node.setNext(first);
                //将cur向后移动一个节点，即移动到新加入的节点上，以便后续的加入节点
                cur=node;
            }
        }
    }

    /**
     * @author binbin
     * @date 2022/9/15 上午1:00
     * 利用辅助指针来进行遍历，遍历的终止条件是temp.next=first
     */
    public void traverseList(){
        if (first==null){
            throw new RuntimeException("空环形链表，无法进行遍历");
        }
        //由于first的特殊性，我们需要使用辅助指针来完成遍历
        Node temp=first;
        while (true){
            System.out.printf("当前的编号为：%d\n",temp.getNo());
            if (temp.getNext()==first){
                //表明已经遍历完毕
                break;
            }
            temp=temp.getNext();
        }
    }


    /**
     * @author binbin
     * @date 2022/9/15 下午7:24
     * @param startNo 起始的序号
     * @param count 表示数几个
     * @param nums  节点数
     */
    public void countSequence(int startNo,int count,int nums){
        //需要首先对数据进行校验
        if (first==null || startNo<1 || startNo>nums){
            //first指针为空，开始序号小于1,开始的序号大于总数均为不合理
            throw new RuntimeException("数据不合法，请重新试试！");
        }
        //创建一个辅助指针
        Node helper=first;
        //需要将helper指向链表的最后一个
        while (true){
            //通过遍历来实现
            if (helper.getNext()==first){
                //表示helper指向了最后一个节点
                break;
            }
            helper=helper.getNext();
        }

        //进行报数前将first和helper移动（startNo-1）次，表示的是要从那里开始遍历出链表
        for (int j=0;j<startNo-1;j++){
            first=first.getNext();
            helper=helper.getNext();
        }

        //当开始报数的时候，移动(count-1)次，然后出圈
        while (true){
            //当helper和first相等的时候，说明圈中只有一个节点
            if (helper==first){
                break;
            }
            //此时让first和helper一起移动count-1次循环
            for (int j=0;j<count-1;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            //此时first指向的节点就是待删除的节点
            System.out.println("节点编号为："+first.getNo()+"的节点出列");
            //这时候将first指向的节点删除
            first=first.getNext();
            helper.setNext(first);

        }
        System.out.println("最后留在单向链表中的节点编号为："+first.getNo());



    }
}
/**
 * @author binbin
 * @date 2022/9/15 上午12:32
 * 定义一个节点类，是单向环形链表的基本组成单位
 */
class Node{

    /**编号*/
    private int no;
    /**指向下一个节点的指针域*/
    private Node next;

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }


}
