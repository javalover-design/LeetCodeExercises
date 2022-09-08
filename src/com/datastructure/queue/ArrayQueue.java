package com.datastructure.queue;

import java.util.Scanner;

/**
 * @author binbin
 * @date 2022年09月06日  下午11:47
 * 使用数组模拟队列
 */
public class ArrayQueue {

    public static void main(String[] args) {

        //创建一个大小为3的队列
        QueueDemo queueDemo = new QueueDemo(3);
       //用字符类型表示用于输入的字母
        char key=' ';
        //此时使用键盘输入的形式来对队列进行操作。
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("输入a 表示向队列中添加数据");
            System.out.println("输入g 表示从队列中取出数据");
            System.out.println("输入h 表示看队列中的第一个数据");
            System.out.println("输入e 表示退出程序");
            System.out.println("输入s 表示展示队列");

            //表示获取字符的第一位字符
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    queueDemo.listQueue();
                        break;
                case 'a':
                    System.out.println("请输入要添加的数据：");
                    int val=scanner.nextInt();
                    queueDemo.addElement(val);
                    break;

                case 'g':
                    try {
                        int element = queueDemo.getElement();
                        System.out.println("获取的元素是："+element);
                        break;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                case 'h':
                    try {
                        int i = queueDemo.headQueue();
                        System.out.println("队列的头部元素是"+i);
                        break;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                case 'e':
                    loop=false;
                    break;
                default:
                    break;
            }

        }

    }
}
/**定义一个队列类，其中包含队列的长度，指向头的头指针，指向尾的尾指针以及存放数据的数组*/
class QueueDemo{
    /**队列的长度*/
    private int maxSize;
    /**队列的头指针*/
    private int front;
    /**队列的尾指针*/
    private int rear;
    /**存放数据的数组,即模拟队列*/
    private int[] arr;

    /**
     * @author binbin
     * @date 2022/9/7 上午12:10
     * @param maxArraySize
     * @return null
     */
    public QueueDemo(int maxArraySize){
        maxSize=maxArraySize;
        arr=new int[maxArraySize];
        front=-1; //指向队列头部，即队列第一个元素的前一个位置
        rear=-1; //指向队列的尾部，队列最后一个元素
    }

    /**
     * @author binbin
     * @date 2022/9/7 上午12:13
     * @return boolean
     * 定义一个方法判断队列是否已经满了，当尾指针=最大值-1表示已经到队尾了。
     */
    public boolean isFull(){
        return rear==maxSize-1;
    }


    /**
     * @author binbin
     * @date  上午12:15
     * @return boolean
     * 当头尾指针重合的时候表示队列为空
     */
    public boolean isEmpty(){
        return front==rear;
    }

    /**
     * @author binbin
     * @date 2022/9/7 上午12:19
     * @param element
     * 编写方法向队列中添加数据
     */
    public void addElement(int element){
        //首先判断队列是否满
        if (isFull()){
            System.out.println("队列已满，无法再加入了！");
            return;
        }
        //如果没有满，移动尾指针
        arr[++rear]=element;
    }


    /**
     * @author binbin
     * @date 2022/9/7 上午12:24
     * @return int
     * 获取队列的头部元素，此处需要注意如果为空则需要抛出异常，不能返回-1,会有歧义
     */
    public int getElement(){
        if (isEmpty()){
           throw new RuntimeException("队列已空，无法获取数据！");
        }
        return arr[++front];

    }


    /**
     * @author binbin
     * @date 2022/9/7 上午12:26
     * 遍历整个队列，查看队列中有哪些元素
     */
    public void listQueue(){
        //首先判断是否为空
        if (isEmpty()){
            System.out.println("队列为空，无法遍历！");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

/**
 * @author binbin
 * @date 2022/9/7 上午12:30
 * @return int
 * 编写方法查看队列的头数据
 */
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法查看头数据！");
        }
        return arr[++front];
    }

}
