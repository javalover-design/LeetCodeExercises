package com.datastructure.Search;

import java.util.Arrays;

/**
 * @author binbin
 * @date 2022年11月27日  下午12:50
 */
public class FibonacciSearch {

    /**定义一个最大值*/
    public static final int MAX_SIZE=20;
    public static void main(String[] args) {
        int[] arr=new int[]{1,8,10,89,1000,1234};
        System.out.println(fibonacciSearch(arr, 10));

    }

    /**
     * @author binbin
     * @date 2022/11/27 下午12:56
     * @param
     * @return int[]
     *由于中间值mid的求解方法需要使用到斐波那契数列，因此需要先获取一个*/
    public static int[] fib(){

        int[] fib=new int[MAX_SIZE];
        fib[0]=1;
        fib[1]=1;
        for (int i = 2; i <MAX_SIZE ; i++) {
            fib[i]=fib[i-1]+fib[i-2];
        }

        return fib;
    }

/**
 * @author binbin
 * @date 2022/11/27 下午12:57
 * @param arr 查找的数组
 * @param findValue  待查找的值
 * @return int 返回对应的下标，若不存在则为-1
 */
    public static int fibonacciSearch(int[] arr,int findValue){
        //表示左边
        int low=0;
        //表示右边
        int high=arr.length-1;
        //表示在斐波那契数列中分割数值的下标志
        int k=0;
        //表示中间值
        int mid=0;
        //获取对应的斐波那契数列
        int[] f=fib();

        //需要将k取到对应的位置，只有当fib（k）-1大于等于high的时候才能利用k进行查找
        while (high>=f[k]-1){
            k++;
        }
        //由于斐波那契查找的时候可能存在数组长度小于斐波那契数列的长度，因此需要对数组进行扩容,f[k]表示的是
        //获取到分割值k时候的总长度，该长度可能大于等于数组长度length
        int[] temp= Arrays.copyOf(arr,f[k]);
        for (int i=high+1;i<f[k];i++){
            temp[i]=arr[high];
        }
        //使用while循环来查找
        while (low<=high){
            //mid的值表示
            mid=low+f[k-1]-1;
            if (findValue<temp[mid]){
                //表示在mid的左边，需要将high进行移动，并变化k的值,因为mid的变化受k的影响
                high=mid-1;
                k--;
                //k--是因为f[k]=f[k-1]+f[k-2]  因此f[k-1]=f[k-2]+f[k-3],
            }else if (findValue>temp[mid]){
                low=mid+1;
                k-=2;
                //k-=2是因为f[k]=f[k-1]+f[k-2]  因此f[k-2]=f[k-3]+f[k-4],
            }else{
                //如果相等还需要判断是否mid小于等于high
                if (mid<=high){
                    return mid;
                }else{
                    return high;
                }
            }

        }
        return -1;
    }
}
