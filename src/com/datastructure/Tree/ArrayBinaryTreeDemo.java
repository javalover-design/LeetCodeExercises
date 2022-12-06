package com.datastructure.Tree;

/**
 * @author binbin
 * @date 2022年12月06日  下午7:51
 * 实现一个顺序存储二叉树
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};

        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
     //   arrayBinaryTree.preOrder(0);
        arrayBinaryTree.infixOrder(0);
    }
}

class ArrayBinaryTree{
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * @author binbin
     * @date 2022/12/6 下午7:57
     * @param index  表示数组的下标 满足位置为index的节点，其左子节点坐标为index*2+1,其右子节点坐标为index*2+2
     * 顺序存储二叉树的前序遍历，因为数组下标决定了要输出的值是多少
     */
    public void preOrder(int index){
        if (arr==null || arr.length==0){
            System.out.println("数组为空，无法进行遍历");
        }
        //前序遍历首先输出父节点
        System.out.println(arr[index]);
        //向左进行遍历,接着看其左子节点的坐标
        if ((index*2+1)<arr.length){

            preOrder(index*2+1);
        }

        //向右进行遍历
        if ((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }

    /**
     * @author binbin
     * @date 2022/12/6 下午8:07
     * @param index  表示数组的下标 满足位置为index的节点，其左子节点坐标为index*2+1,其右子节点坐标为index*2+2
     *  顺序存储二叉树的中序遍历，因为数组下标决定了要输出的值是多少
     */
    public void infixOrder(int index){
        if (arr==null || arr.length==0){
            System.out.println("数组为空，无法进行遍历");
        }

        //向左遍历
        if ((index*2+1)<arr.length){
            infixOrder(index*2+1);
        }

        System.out.println(arr[index]);

        //向右遍历
        if ((index*2+2)<arr.length){
            infixOrder(index*2+2);
        }
    }
    /**
     * @author binbin
     * @date 2022/12/6 下午8:10
     * @param index  表示数组的下标 满足位置为index的节点，其左子节点坐标为index*2+1,其右子节点坐标为index*2+2
     *               顺序存储二叉树的后序遍历，因为数组下标决定了要输出的值是多少
     */
    public void postOrder(int index){
        if (arr==null || arr.length==0){
            System.out.println("数组为空，无法进行遍历");
        }
        //向左遍历
        if ((index*2+1)<arr.length){
            infixOrder(index*2+1);
        }
        //向右遍历
        if ((index*2+2)<arr.length){
            infixOrder(index*2+2);
        }
        System.out.println(arr[index]);
    }
}
