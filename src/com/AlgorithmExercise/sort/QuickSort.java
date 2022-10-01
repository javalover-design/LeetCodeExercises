package com.AlgorithmExercise.sort;

/**
 * @author binbin
 * @date 2022年09月10日  下午7:48
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr=new int[]{1,5,6,9,7,-9,5,-6};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }


    /**
     * @author binbin
     * @date 2022/9/10 下午7:49
     * @param arr 需要排序的数组
     * @param left 数组的第一个元素位置
     * @param right 数组第二个元素位置
     * 快速排序
     * 基本思路：使用递归来实现排序
     * 1. 首先在初始数组中定义左右两个边界，即left和right
     * 2.在进行比较的时候永远从右指针r（初始情况下是等于right，后续移动）开始进行比较，如果右指针所指向的那个大于等于left所指向的那个数，
     * 那么将右指针（r）进行左移动，如果小于left所指向的哪个数，则保持不动。此时对左指针（l，初始值为left，后续移动）进行操作，如果左
     * 指针（l）指向的数小于等于left的数，则将左指针（l）向右移，如果大于left的数，则l不动，此时l不等于r（左指针不等于右指针）
     * 将左右指针指向的数进行交换，之后再与left指向的数进行比较，直到l与r重合为止，重合之后将left所指的数与l（或r）指向的数进行
     * 互换，此时l（r）左边都是比其本身小的数，右边都是比其本身大的数
     * 3.最后使用递归再次对其进行排序，分成两部分，以此次l（或r）为分界，左右各进行递归
     * 并且左边以第一个位置为基准，右边以最后一个位置为基准
     */
    public static void quickSort(int[] arr,int left,int right){
        //递归终止的条件是：左边大于等于右边,因为如果重合，此次快排中只有一个元素
        while (left>=right){
            return;
        }
        //定义左右两个指针,初始为left和right
        int l=left;
        int r=right;
        while (l<r){
            //循环的条件是左指针始终要小于右指针，如果等于，则需要跳出循环，进行与left元素互换
            //内层需要定义两个循环来移动左右指针
            while (l<r && arr[r]>=arr[left]) {r--;}
            while (l<r && arr[l]<=arr[left]){l++;}
            //进行移动之后，左右指针重合，则需要将该位置的数与left位置的数进行互换
            int temp=0;
            if (l==r){
                 temp=arr[r];
                arr[r]=arr[left];
                arr[left]=temp;
            }else{
                //如果左右指针此时都不能移动了，但是并没有重合，此时需要交换两个的位置
                temp=arr[r];
                arr[r]=arr[l];
                arr[l]=temp;
            }
        }
        //此时如果左右指针重合，需要将left的数与指针指向的数交换顺序，同时也意味着本次循环结束
        //需要再次使用递归来对l或r位置左右两边的数进行同样的排序
        quickSort(arr,left,l-1);
        quickSort(arr,r+1,right);
    }
}
