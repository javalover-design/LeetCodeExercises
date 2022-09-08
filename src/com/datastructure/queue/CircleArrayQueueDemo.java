package com.datastructure.queue;

/**
 * @author binbin
 * @date 2022年09月07日  下午7:48
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {


    }
}

class CircleArray{
    private int maxSize;
    /**指向队列的头，即队列的第一个元素*/
    private int front;
    /**指向队列的尾的后一个位置*/
    private int rear;
    private int[] array;

    public CircleArray(int arraySize){
        maxSize=arraySize;
        array=new int[maxSize];
        front=0;
        rear=0;
    }

    /**
     * @author binbin
     * @date 2022/9/7 下午7:55
     * @return null
     判断队列是否为空*/
    public boolean isEmpty(){
        return front==rear;
    }

    /**
     * @author binbin
     * @date 2022/9/7 下午7:55
     * @return boolean
     * 判断队列是否是满的
     */
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }


    /**
     * @author binbin
     * @date 2022/9/7 下午8:03
     * @param value
     * 将数据添加到队列中
     */
    public void addElement(int value) {
        if (isFull()) {
            System.out.println("队列已满，无法再添加元素了！");
            return;
        }
        //如果不满，则直接将元素赋值到rear位置即可
        array[rear] = value;
        //此时需要对rear进行取模运算，即rear变为其后移动一位模上最大值即可
        rear = (rear + 1) % maxSize;
    }

    /**
     * @author binbin
     * @date 2022/9/7 下午8:12
     * @return int
     * 获取队列中的元素
     */
    public int getElement(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取出数据！");
        }

        //首先需要使用一个临时变量来保存值，之后对指针进行后移动操作
        int v=array[front];
        front=(front+1)%maxSize;
        return v;
    }

    /**
     * @author binbin
     * @date 2022/9/7 下午8:15
     * @return int
     * 获取到有效元素的个数，用于元素的遍历
     */
    public int elementNumber(){
        return (rear+maxSize-front)%maxSize;
    }


    /**
     * @author binbin
     * @date 2022/9/7 下午8:18
     * 遍历整个队列
     */
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法遍历");
        }
        //此处的遍历表示从front开始，经历有效数据个数的遍历最后求队列的遍历
        for (int i= front;i<front+elementNumber();i++){
            //此处的i%maxSize是因为i有可能会超过maxSize
            System.out.println(array[i%maxSize]);
        }
    }

    /**
     * @author binbin
     * @date 2022/9/7 下午8:21
     * @return int
     * 获取队列的头元素
     */
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法找到头元素");
        }
        return array[front];
    }

}