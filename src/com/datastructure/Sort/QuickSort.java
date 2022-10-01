package com.datastructure.Sort;

/**
 * @author binbin
 * @date 2022年09月30日  下午4:05
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr=new int[800000];
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*800000);
        }
        System.out.println("==============排序前=========");
        long start=System.currentTimeMillis();
        // shellSortWithExchange(arr);
        quickSort(arr,0,arr.length-1);
        long end=System.currentTimeMillis();
        System.out.println("用时"+(end-start)+"ms");
    }
    
    
 /**
  * @author binbin
  * @date 2022/9/30 下午4:07
  * @param arr 对应的数组
  * @param left 最左边索引
  * @param right   最右边索引
  */
    public static void quickSort(int[] arr,int left,int right){
        //使用两个变量来记录对应的左右边界
        int l=left;
        int r=right;
        //定义一个临时变量用于交换
        int temp=0;
        //定义一个中轴值
        int pivot=arr[(left+right)/2];
        //只要左索引小于右索引就可以一直循环
        while (l<r){
            //目的是将比pivot小的放左边，将比pivot大的放右边
            while (arr[l]<pivot){
                //表示从pivot左边找比pivot大于等于的数，找到就退出
                l++;
            }
            while (arr[r]>pivot){
                r--;
            }
            //如果左索引大于等于右索引，说明pivot左边已经是完全小于等于pivot的值了，
            // 右边全部是大于等于pivot的值了
            if (l>=r){
                break;
            }
            //如果找到了，则进行交换
               temp=arr[l];
               arr[l]=arr[r];
               arr[r]=temp;
               //如果交换完后左指针的值等于中轴值，那么右指针向前移动一位.如果值相等，则需要将对应未交换的值
            // 进行的指针移动
               if (arr[l]==pivot){
                   r--;
               }
               //同理，右指针的值也是如此
               if (arr[r]==pivot){
                   l++;
               }
        }
        //如果l和r相等，则一个自增，一个自减
        if (l==r){
            l++;
            r--;
        }
        //向左递归
        if (left<r){
            quickSort(arr,left,r);
        }
        if (right>l){
            quickSort(arr,l,right);
        }

    }
}
