package com.datastructure.LinkedList;

import java.util.Stack;

/**
 * @author binbin
 * @date 2022年09月08日  下午4:30
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNode(new ListNode(4,"12","1"));
        singleLinkedList.addNodeWithSort(new ListNode(1,"Jack","J"));
        //singleLinkedList.addNodeWithSort(new ListNode(5,"Mike","M"));
        singleLinkedList.addNodeWithSort(new ListNode(5,"Mike","M"));
        singleLinkedList.addNodeWithSort(new ListNode(2,"Sarch","S"));
        singleLinkedList.list();
        //System.out.println(SingleLinkedList.getListLength(singleLinkedList.getHeadNode()));

        //singleLinkedList.update(new ListNode(2,"hhh","45"));
        //System.out.println("=================");
        //singleLinkedList.list();
        System.out.println("===============");
        System.out.println(SingleLinkedList.getIndexNode(singleLinkedList.getHeadNode(), 5));


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
    private final ListNode headNode=new ListNode(0,"","");

    public ListNode getHeadNode() {
        return headNode;
    }


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
    
    /**
     * @author binbin
     * @date 2022/9/11 下午6:51
     * @param node  
     */
    public void addNodeWithSort(ListNode node){
        //基本思路依旧是利用一个辅助变量对链表进行遍历，因为头节点是不可变化
        ListNode temp=this.getHeadNode();
        //定义一个标志，如果编号已经存在，那么给出提示信息
        boolean isExists=false;
        //循环遍历查找
        while (true){
            if (temp.getNext()==null){
                //说明到末尾了，直接中断
                break;
            }
            if (temp.getNext().getNo()>node.getNo()){
                //temp下一个节点的数值大于要插入节点的数值，则表示找到了位置，表示node将插在temp和temp.next之间
                break;
            }else if (node.getNo()==temp.getNo()){
                //相等则表明已经存在了
                isExists=true;
                break;
            }
            //如果以上条件均未满足，则直接下一个进行遍历
            temp=temp.getNext();
        }

        //出循环表示遍历有结果了
        if (isExists){
            throw new RuntimeException("编号已经存在，请重新输入");
        }else{
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        
    }

    /**
     * @author binbin
     * @date 2022/9/12 下午8:19
     * @param updateNode  要进行修改的单链表的某个节点
     * 根据传入节点的no来进行修改即可
     *
     */
    public void update(ListNode updateNode){
        if (headNode.getNext()==null){
            System.out.println("链表为空！");
            return;
        }
        //首先还是需要定义一个辅助节点来进行遍历
        ListNode temp=headNode.getNext();
        //定义标志，表示是否找到节点，找到设为true
        boolean flag=false;
        while (true){
            if (temp.getNext()==null){
                //表示temp已经到达链表的末尾了
                break;
            }
            //如果遍历的节点的NO与传入的No相等，表示找到了
            if (temp.getNo()==updateNode.getNo()){
                flag=true;
                break;
            }

            //如果都没有那么将temp向后移动
            temp=temp.getNext();
        }

        //出循环之后，如果flag
        if (flag){
            //表示找到了可以进行相应修改（此时temp已经移动到特定的位置了）
            temp.setName(updateNode.getName());
            temp.setNickName(updateNode.getNickName());
        }else{
            //此处表示没有找到
            System.out.println("没有找到对应编号的信息！");
        }

    }

    /**
     * @author binbin
     * @date 2022/9/12 下午8:41
     * @param no  待删除节点的no
     * 1.首先利用辅助变量进行链表的遍历
     * 2.其次使得temp.next节点的no与待传入节点的no比较（因为需要遍历到当前元素的前一个元素）
     */
    public void deleteNode(int no){
            if (headNode.getNext()==null){
                System.out.println("单链表为空，无法删除！");
                return;
            }

            //temp节点为头节点的下一个节点
            ListNode temp=headNode.getNext();
            //如果找到，则设置标识即可
            boolean flag=false;
            while (true){
                if (temp.getNext()==null){
                    break;
                }
                //如果相等，则表示寻找到了
                if (temp.getNext().getNo()==no){
                    flag=true;
                    break;
                }
                //将变量向后移动
                temp=temp.getNext();
            }

            if (flag){
                //表示找到了待删除节点
                temp.setNext(temp.getNext().getNext());
            }else {
                System.out.println("该节点可能不存在哦");
            }

    }


    /**
     * @author binbin
     * @date 2022/9/12 下午9:01
     * @param head 传入链表的头节点
     * @return int 返回链表的长度（除去头节点）
     */
    public static  int getListLength(ListNode head){
        if (head.getNext()==null){
            System.out.println("空链表");
            return 0;
        }

        ListNode temp=head;
        int count=0;
        while (true){
            if (temp.getNext()==null){
                return count;
            }else {
                count++;
            }

            temp=temp.getNext();

        }

    }

    /**
     * @author binbin
     * @date 2022/9/13 下午8:02
     * @param headNode 头节点
     * @param index  查找指定位置的节点
     * @return com.datastructure.LinkedList.ListNode 返回查找的节点
     * 1. 查找倒数第k个节点需要传入链表的头节点以及需要寻找的节点位置index
     * 2. 首先从头节点开始遍历该链表，获取链表的长度length
     * 3. 然后从头节点开始遍历到（length-index+1）的位置
     * 4. 如果找到了返回节点，如果没有找到返回null
     */
    public static ListNode getIndexNode(ListNode headNode,int index){
        if (headNode.getNext()==null){
            //则表明链表为空，返回空
            return null;
        }
        //接着遍历链表的长度
        int listLength = getListLength(headNode);
        if (index<=0 || listLength<index){
            //表明index的位置不对需要返回null
            return null;
        }

        //接着定义临时变量用于遍历到index节点
        ListNode temp=headNode.getNext();
        for (int i=1;i<listLength-index+1;i++){
            //如果长度为5,index=2,则i需要遍历到4才能找到
            //本方法中由于temp指向的第一个节点，因此，循环体内temp始终要比i的位置大1
            temp=temp.getNext();
        }

        return temp;

    }

    /**
     * @author binbin
     * @date 2022/9/13 下午8:31
     * @param headNode 要反转链表的头节点
     *  1. 首先创建一个辅助反转头节点，是一个新定义的节点
     * 2. 其次遍历整个链表，每遍历一个节点，就将该节点取出连接在反转节点的最前面的位置（即reverseNode的next指针域）
     * 3. 最后将原来节点与reverseNode创建的链表连接（head.next=reverseNode.next）即可完成链表的反转
     */
    public static  void reverseListNode(ListNode headNode){
                if (headNode.getNext()==null || headNode.getNext().getNext()==null){
                    //表示空链表或者第一个节点为空
                    return;
                }
                //定义反转链表的头指针
                ListNode reverseNode=new ListNode(0,"","");
                //定义遍历原链表的辅助变量
                ListNode temp=headNode.getNext();
                //定义辅助变量的下一个节点，用来保存当前temp的下一个节点。因为temp一旦移除，需要找到其下一个节点
                ListNode next=null;
                //遍历整个链表并且取出节点
                while (temp!=null){
                    //先找到当前temp的下一个节点，即记录保存下一个节点
                    next=temp.getNext();
                    //表示temp的下一个节点指向反转链表头节点的最前端（头节点的下一个节点）
                    temp.setNext(reverseNode.getNext());
                    //将temp节点指向反转头节点
                    reverseNode.setNext(temp);
                    //之后再将temp指向下一个节点
                    temp=next;
                }
                //遍历完之后将head的下一个节点设置为反转头节点的下一个节点
                headNode.setNext(reverseNode.getNext());
    }

    /**
     * @author binbin
     * @date 2022/9/13 下午9:41
     * @param headNode  头节点
     * 利用栈的数据结构将链表逆序打印
     */
    public  static void reversePrint(ListNode headNode){
        if (headNode.getNext()==null){
            return;
        }
        //创建一个栈，并将各个节点压入栈中
        Stack<ListNode> listNodes = new Stack<>();
        //利用一个辅助变量来遍历链表
        ListNode temp=headNode.getNext();
        while (temp!=null){
            //只要当前节点不为空，则直接入栈
            listNodes.push(temp);
            temp=temp.getNext();
        }
        //遍历完后将栈中的节点进行打印即可
        while(listNodes.size()>0){
            System.out.println(listNodes.pop());
        }

    }

}