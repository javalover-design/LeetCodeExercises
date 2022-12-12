package com.datastructure.Tree;

/**
 * @author binbin
 * @date 2022年12月06日  下午9:30
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

    }


}

class Node{
    private Integer no;
    private String name;
    private Node left;
    private Node right;
    /**值为0表示左子树，为1表示前驱节点*/
    private Integer leftType;
    /**值为0表示右子树，为1表示后继节点*/
    private Integer rightType;


    public Node(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getLeftType() {
        return leftType;
    }

    public void setLeftType(Integer leftType) {
        this.leftType = leftType;
    }

    public Integer getRightType() {
        return rightType;
    }

    public void setRightType(Integer rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

class ThreadedBinaryTree{
    private Node root;
    /**为了实现线索化，需要创建一个始终指向当前节点的前驱节点的指针，该指针始终指向当前节点的前驱节点（线索化需要向上找）*/
    private Node preNode=null;

    public ThreadedBinaryTree(Node root) {
        this.root = root;
    }

    public ThreadedBinaryTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * @author binbin
     * @date 2022/12/6 下午9:40
     * @param node  待中序线索化的节点（需要线索化的节点）
     *              使用中序线索化方法线索化二叉树
     */
    public void threadedInfixOrder(Node node){
        //判断当前节点是否为空
        if (node==null){
            return;
        }

        //由于是中序线索化
        //先递归线索化左子树
        threadedInfixOrder(node.getLeft());
        //线索化当前节点(线索化当前节点时候需要判断左右节点的类型，是树还是节点)
        //处理前驱节点
        if (node.getLeft()==null){
            //如果当前节点的左指针为空，则需要将其指向前驱节点，并设置类型为1
            node.setLeft(preNode);
            //表明左指针指向的是前驱节点而不是树
            node.setLeftType(1);
        }

        //处理后继节点（此处需要注意的是当前节点的后继节点的处理是在上一层递归开始的时候，待处理节点的前驱节点（当前node）的右指针进行操作）
        if (preNode!=null && preNode.getRight()==null){
            //表示当前节点的前驱节点的右指针不为空，则表示可以将当前节点进行线索化,即利用当前节点的前驱节点来进行操作
            preNode.setRight(node);
            preNode.setRightType(1);

        }

        //每处理一个节点，当前节点都是下一个节点的前驱节点
        preNode=node;
        //最后递归线索化右子树
        threadedInfixOrder(node.getRight());

    }

    /**
     * @author binbin
     * @date 2022/12/10 下午7:43
     * 遍历中序线索化二叉树
     * 1.从根节点出发，只要当前节点不为空，则循环遍历
     * 2。只要当前节点的左指针域类型为前驱节点类型，则直接输出当前节点，若不为节点类型，则直接循环移动到下一个节点，此举旨在找到中序线索遍历
     * 的第一个节点
     * 3.接着处理右节点，对于右节点而言，只要该节点的右指针域指向的是后继节点，则直接输出其后继节点，如果当前节点无后继节点了，则直接将当前节点
     * 向右移动，即处理为当前节点的右节点
     */
    public void threadedInfixList(){
        //需要定义一个节点，用来表示当前节点，从root开始
        Node node=root;
        //只要处理的节点不为空，则一直循环遍历
        while (node!=null){
            //遍历左边
            while (node.getLeftType()==0){
                //如果当前节点的左指针域指向的是左树，则继续寻找
                node=node.getLeft();
            }
            //出循环表示，当前节点的左指针域指向的不是树，直接输出当前节点
            System.out.println(node);

        //遍历右边，只要当前节点的右指针域指向的是节点，则直接输出，并接着判断
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);

            }

         //出循环表示该节点的右指针域指向的是树，则将当前节点继续向右移动
            node=node.getRight();

        }
    }

}