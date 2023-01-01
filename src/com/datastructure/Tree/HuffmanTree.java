package com.datastructure.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author binbin
 * @date 2023年01月01日  下午2:10
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr=new int[]{13,7,8,3,29,6,1};

    }

    /**
     * @author binbin
     * @date 2023/1/1 下午2:18
     * @param arr 数组
     * @return huffmanNode 返回赫夫曼树的根节点
     * 传入一个数组，返回对应赫夫曼树
     */
    public static HuffmanNode createHuffmanTree(int[] arr){
            //创建一个集合用于存放节点，同时利用集合进行排序
        List<HuffmanNode> huffmanNodes = new ArrayList<>();
        //遍历数组中的节点，将数组中的值创建成HuffmanNode节点，存入集合中
            for (int value:arr){
                huffmanNodes.add(new HuffmanNode(value));
            }

            //此时需要对集合中的所有节点进行处理，需要用到循环，只要集合中的元素个数等于1的时候就退出
        while (huffmanNodes.size()>1) {
            //利用集合进行从小到大排序（排序的实现依赖于Comparable接口的方法实现）
            Collections.sort(huffmanNodes);
            //取出权值最小的节点
            HuffmanNode leftNode=huffmanNodes.get(0);
            //取出权值第二小的节点
            HuffmanNode rightNode=huffmanNodes.get(1);
            //创建一个新的二叉树，根节点的值为权值最小和次小节点的和
            HuffmanNode parentNode=new HuffmanNode(leftNode.getValue()+rightNode.getValue());
            //同时设置新二叉树的左右节点
            parentNode.setLeft(leftNode);
            parentNode.setRight(rightNode);

            //将最小以及次小的节点从集合中删除，并将新二叉树存入集合中
            huffmanNodes.remove(leftNode);
            huffmanNodes.remove(rightNode);
            huffmanNodes.add(parentNode);

        }
        return huffmanNodes.get(0);

    }
}
/**
 * @author binbin
 * @date 2023/1/1 下午2:14
 * 为了让节点类能够进行排序，需要实现Comparable接口
 */
class HuffmanNode implements Comparable<HuffmanNode>{
    private int value;
    private HuffmanNode left;
    private  HuffmanNode right;

    public HuffmanNode(int value) {
        this.value = value;
    }

    public HuffmanNode() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                '}';
    }


    @Override
    public int compareTo(HuffmanNode o) {
        //此时表示从小到大进行排序
        return this.value-o.value;
    }
}