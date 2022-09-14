package com.datastructure.LinkedList;

/**
 * @author binbin
 * @date 2022年09月14日  下午4:42
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        System.out.println("双向链表测试～");
        ListNode2 node1 = new ListNode2(1, "A", "A");
        ListNode2 node2 = new ListNode2(2, "B", "B");
        ListNode2 node3 = new ListNode2(3, "C", "C");
        ListNode2 node4 = new ListNode2(5, "D", "D");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addNodeToLast(node1);
        doubleLinkedList.addNodeToLast(node2);
        doubleLinkedList.addNodeToLast(node3);
        doubleLinkedList.addNodeToLast(node4);
        doubleLinkedList.addWithSort(new ListNode2(4,"",""));
       // doubleLinkedList.addWithSort(new ListNode2(4,"",""));
       // doubleLinkedList.addWithSort(new ListNode2(4,"",""));
        doubleLinkedList.addWithSort(new ListNode2(5,"",""));
        doubleLinkedList.addWithSort(new ListNode2(5,"",""));
        doubleLinkedList.list();
        //System.out.println("修改之后的角色～");
        //doubleLinkedList.modifyOneNode(new ListNode2(4,"E","E"));
        //doubleLinkedList.list();
        //System.out.println("删除之后的内容～");
        //doubleLinkedList.deleteOneNode(4);
        //doubleLinkedList.list();

    }
}

/***
 * @author binbin
 * @date 2022/9/14 下午4:44
 * 创建一个双向链表类，用于描述双向链表的单个节点
 */
class ListNode2{
    private int no;
    private String name;
    private String nickName;
    private ListNode2 next;
    private ListNode2 pre;

    public ListNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
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

    public ListNode2 getNext() {
        return next;
    }

    public void setNext(ListNode2 next) {
        this.next = next;
    }

    public ListNode2 getPre() {
        return pre;
    }

    public void setPre(ListNode2 pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}


class DoubleLinkedList{
    /**初始化头节点*/
    private ListNode2 headNode=new ListNode2(0,"","");

    /**
     * @author binbin
     * @date 2022/9/14 下午4:53
     * @return com.datastructure.LinkedList.ListNode2
     * 返回头节点的方法
     */
    public ListNode2 getHeadNode() {
        return headNode;
    }

    /**
     * @author binbin
     * @date 2022/9/14 下午4:55
     * 遍历双向链表的元素，与单链表一样
     */
    public void list(){
        if (headNode.getNext()==null){
           throw new RuntimeException("当前链表为空，无法进行遍历！");
        }
        //定义一个辅助变量来遍历链表
        ListNode2 temp=headNode.getNext();
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.getNext();
        }

    }


    /**
     * @author binbin
     * @date 2022/9/14 下午4:59
     * @param node  要添加到末尾的节点
     * 表示添加元素到链表的末尾
     */
    public void  addNodeToLast(ListNode2 node){
        //定义一个临时节点用来遍历，从头节点开始
        ListNode2 temp=headNode;
        while (true){
            if (temp.getNext()==null){
                //表明已经到链表的最后了
                break;
            }
            temp=temp.getNext();
        }
        //当退出while循环的时候，temp就指向了最后一个节点,
        //形成一个双向链表
            temp.setNext(node);
            node.setPre(temp);

    }

    /**
     * @author binbin
     * @date 2022/9/14 下午5:05
     * @param node  要修改的节点
     * 修改某个节点的信息
     */
    public void modifyOneNode(ListNode2 node){
        if (headNode.getNext()==null){
            throw new RuntimeException("当前链表为空，无法更改节点信息！");
        }

        ListNode2 temp=headNode.getNext();
        //表示是否查找到节点
        boolean flag=false;
        while (true){
            if (temp==null){
                //表示遍历完毕
                break;
            }

            if (temp.getNo()==node.getNo()){
                flag=true;
                break;
            }

            temp=temp.getNext();
        }

        if (flag){
            temp.setName(node.getName());
            temp.setNickName(node.getNickName());
        }else{
            System.out.println("无此节点信息，请检查后重试！");
        }
    }


    /**
     * @author binbin
     * @date 2022/9/14 下午5:12
     * @param no  待删除节点的编号
     * 从双向链表中删除一个节点
     */
    public void deleteOneNode(int no){

        if (headNode.getNext()==null){
            throw new RuntimeException("当前链表为空，无法删除节点!");
        }

        ListNode2 temp=headNode.getNext();
        boolean flag=false;
        while (true){
            if (temp==null){
                break;
            }
            if (temp.getNo()==no){
                flag=true;
                break;
            }
            temp=temp.getNext();
        }

        if (flag){
            //表示找到了
            temp.getPre().setNext(temp.getNext());
            //此处如果是最后一个节点，则下面的语句将出现异常，因此需要加一个条件判断
            if (temp.getNext()!=null) {
                temp.getNext().setPre(temp.getPre());
            }
        }else {
            System.out.println("当前节点并不存在，请仔细检查！");
        }
    }


    /**
     * @author binbin
     * @date 2022/9/14 下午9:10
     * @param node  待添加的节点
     *  有序的添加节点信息
     */
    public void addWithSort(ListNode2 node){
            ListNode2 temp=headNode.getNext();
            boolean isExists=false;
            while (true){
                if (temp==null){
                    break;
                }
                if (temp.getNext()==null){
                    break;
                }
                if (temp.getNo()==node.getNo()){
                    isExists=true;
                    break;
                }
                if (temp.getNext().getNo()>node.getNo()){
                    break;
                }

                temp=temp.getNext();
            }
            if (isExists){
                throw new RuntimeException("该节点已经存在。无法添加");
            }else {
                if (temp==null){
                    temp=node;
                }else if (temp.getNext()==null){
                    temp.setNext(node);
                    node.setPre(temp);
                }else{
                        node.setNext(temp.getNext());
                        temp.getNext().setPre(node);
                        node.setPre(temp);
                        temp.setNext(node);
                }
            }


    }
}
