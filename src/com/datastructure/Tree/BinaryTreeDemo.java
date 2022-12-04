package com.datastructure.Tree;

/**
 * @author binbin
 * @date 2022年12月03日  下午4:04
 * 实现二叉树的前序、中序和后序遍历
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

    }
}

class HeroNode{
    private Integer no;
    private String name;
    /**左节点*/
    private HeroNode left;
    /**右节点*/
    private HeroNode right;

    public HeroNode(Integer no, String name) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * @author binbin
     * @date 2022/12/3 下午4:25
     * 进行前序 遍历，先输出当前节点，再前序遍历左子树，最后前序遍历右子树
     */
    public void preOrder(){
        //先输出当前父节点
        System.out.println(this);

        //递归左子树
        if (this.left!=null){
            this.left.preOrder();
        }
        //递归右子树
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    /**
     * @author binbin
     * @date 2022/12/3 下午4:32
     * 中序遍历，即先遍历左子树，再输出当前节点，最后遍历右子树
     */
    public void infixOrder(){
        //先递归左子树
        if (this.left!=null){
            this.left.infixOrder();
        }
        //直接输出当前父节点
        System.out.println(this);

        //递归右子树
        if (this.right!=null){
            this.right.infixOrder();
        }

    }

    /**
     * @author binbin
     * @date 2022/12/3 下午4:56
     * 后序遍历，首先遍历左子树，再遍历右子树，最后输出父节点
     */
    public void postOrder(){
        //遍历左子树
        if (this.right!=null){
            this.left.postOrder();
        }

        //遍历右子树
        if (this.right!=null){
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    /**
     * @author binbin
     * @date 2022/12/4 下午2:15
     * @param no 待查找节点的no
     * @return com.datastructure.Tree.HeroNode 找到了就返回，没找到就返回null
     * 前序遍历查找
     */
    public HeroNode preOrderSearch(int no){
        //判断当前的信息是否与待查找的信息相同
        if (this.no==no){
            return this;
        }
        //定义一个局部变量来表示查找的结果，如果左遍历找到了，则将结果返回即可
        HeroNode resultNode=null;
        //向左递归
        if (this.left!=null){
            resultNode=this.left.preOrderSearch(no);
        }
        if (resultNode!=null){
            return resultNode;
        }

        //如果上面的resultNode仍然为空，则表示当前的左遍历没有找到对应的节点
        if (this.right!=null){
            resultNode=this.right.preOrderSearch(no);
        }
        //此处右遍历的结果无论是否为空，最后都需要返回了
        return resultNode;
    }

    /**
     * @author binbin
     * @date 2022/12/4 下午2:21
     * @param no 待查找节点的no信息
     * @return com.datastructure.Tree.HeroNode  查找的结果
     * 使用中序遍历查找
     */
    public HeroNode infixOrderSearch(int no){
        HeroNode resultNode=null;
        //向左中序遍历查找
        if (this.left!=null){
            resultNode=this.left.infixOrderSearch(no);
        }
        if (resultNode!=null){
            return resultNode;
        }

        //比较当前节点信息
        if (this.no==no){
            return this;
        }
        //向右中序遍历查找
        if (this.right!=null){
            resultNode=this.right.infixOrderSearch(no);
        }
        return resultNode;

    }

    /**
     * @author binbin
     * @date 2022/12/4 下午2:25
     * @param no 待查找节点的no信息
     * @return com.datastructure.Tree.HeroNode 返回的查找结果
     * 后序遍历查找
     */
    public HeroNode postOrderSearch(int no){
        HeroNode resultNode=null;
        //向左遍历查找
        if (this.left!=null){
            resultNode=this.left.postOrderSearch(no);
        }
        if (resultNode!=null){
            return resultNode;
        }

        //向右遍历查找
        if (this.right!=null){
            resultNode=this.right.postOrderSearch(no);
        }
        if (resultNode!=null){
            return resultNode;
        }
        //与当前节点比较
        if (this.no==no){
            return this;
        }
        return resultNode;
    }

    /**
     * @author binbin
     * @date 2022/12/4 下午3:15
     * @param no  待删除节点的信息
     *            递归删除节点，本方法默认使用递归的方式进行删除
     */
    public void deleteNode(int no){

        //首先判断当前节点的左子节点是否为空，若不为空则与no比较(进入该方法默认是当前节点不为空的)
        if (this.left!=null && this.left.getNo()==no){
            this.left=null;
            return;
        }

        //判断当前节点的右子节点是否为空
        if (this.right!=null && this.right.getNo()==no){
            this.right=null;
            return;
        }

        //上述都未删除成功的话，则递归左子树
       if (this.left!=null) {
           //递归的时候需要判断节点是否为空
           this.left.deleteNode(no);
       }
       if (this.right!=null) {
           this.right.deleteNode(no);
       }
    }

}

/**@author binbin
 * 定义了一棵二叉树
 * */
class BinaryTree{
    /**二叉树最为重要的是根节点*/
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * @author binbin
     * @date 2022/12/3 下午5:09
     * 前序遍历
     */
    public void preOrder(){
        if (this.root!=null){
            //从根节点出发遍历
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法继续遍历");
        }
    }

    /**
     * @author binbin
     * @date 2022/12/3 下午5:12
     * 中序遍历
     */
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法继续遍历");
        }
    }

    /**
     * @author binbin
     * @date 2022/12/3 下午5:12
     * 后序遍历
     */
    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法继续遍历");
        }
    }


    /**
     * @author binbin
     * @date 2022/12/4 下午2:37
     * @param no 待查找节点的信息
     * @return com.datastructure.Tree.HeroNode
     * 前序遍历查找
     */
    public HeroNode preOrderSearch(int no){
        if (this.root!=null){
            return root.preOrderSearch(no);
        }
        return null;
    }

    /**
     * @author binbin
     * @date 2022/12/4 下午2:40
     * @param no 待查找节点的信息
     * @return com.datastructure.Tree.HeroNode
     * 中序遍历查找
     */
    public HeroNode infixOrderSearch(int no){
        if (this.root!=null){
            return root.infixOrderSearch(no);
        }
        return null;
    }

    /**
     * @author binbin
     * @date 2022/12/4 下午2:41
     * @param no 待查找节点的信息
     * @return com.datastructure.Tree.HeroNode
     * 后序遍历查找
     */
    public  HeroNode postOrderSearch(int no){
        if (this.root!=null){
            return root.postOrderSearch(no);
        }
        return null;
    }


    /**
     * @author binbin
     * @date 2022/12/4 下午3:13
     * @param no  待删除节点的信息
     *            递归删除指定no信息的节点
     *            如果是叶子节点，则直接删除该节点，如果不是，则删除整个子树
     */
    public void deleteNode(int no){
            if (this.root!=null){
                //判断root是否是要进行删除的
                if (this.root.getNo()==no){
                    //此处表示直接将根节点置为空，即将整棵树置为空
                    root=null;
                }else{
                    //如果root不是要删除的节点，此时进行向左或者向右递归
                    root.deleteNode(no);
                }
            }else {
                System.out.println("空树无法进行删除操作");
            }
    }
}