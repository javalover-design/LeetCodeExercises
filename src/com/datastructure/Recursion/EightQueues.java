package com.datastructure.Recursion;

/**
 * @author binbin
 * @date 2022年09月25日  下午2:26
 * 八皇后问题：
 * 这是一个古老著名的问题，是回溯算法的经典案例，
 * 在8x8格的国际象棋上摆放八个皇后，使其不能互相攻击。
 * 即：任意两个皇后不能处于同一行、同一列或同一斜线上，问有多少种摆法？
 */
public class EightQueues {
    /**定义皇后的个数*/
    private static final int MAX=8;
    /**定义保存皇后位置的一维数组*/
    int[] array=new int[MAX];
    /**定义一个静态的计数器*/
    private static int count=0;

    public static void main(String[] args) {
        EightQueues eightQueues = new EightQueues();
        eightQueues.check(0);
        System.out.printf("一共有%d种解法",count);
    }


    /**
     * @author binbin
     * @date 2022/9/25 下午2:30
     * 该方法用于打印保存皇后位置的数组信息
     */
    private void printResult(){
        count++;
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    /**
     * @author binbin
     * @date 2022/9/25 下午2:56
     * @param n 表示第几个皇后
     * @return boolean  表示是否冲突
     * 查看放置的第n个皇后是否与之前的所有皇后发生了冲突
     */
    public boolean judge(int n){
        //表示从第一行开始进行遍历，直到n-1行
        for (int i = 0; i < n; i++) {
            //array[i]==array[n]表示第n个皇后与前面n-1个皇后是否在同一列
            //Math.abs(n-i)==Math.abs(array[n]-array[i])表示是否在同一斜线上。
            if (array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;

    }


    /**
     * @author binbin
     * @date 2022/9/25 下午3:10
     * @param n  表示放置第n+1个皇后
     */
    private void check(int n){
        if(n==MAX){
            //此时n=8,表示的是放第九个皇后，与题意不符合，直接打印结果并返回
            printResult();
            return;
        }
        //接着依次将第n+1个皇后放置在第n行的0-7列
        for (int i=0;i<MAX;i++){
            //首先把当前的n+1个皇后放置在第i列（i在0-7之间）
            array[n]=i;
            //接着判断是否冲突
            if (judge(n)){
                //如果不冲突，则放置下一个皇后
                check(n+1);
                //如果冲突则移动列，表示换一列再次进行判断
            }
        }

    }
}
