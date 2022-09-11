package com.AlgorithmExercise.sort;

import java.util.Arrays;

/**
 * @author binbin
 * @date 2022年09月11日  下午3:49
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr=new int[]{1,3,5,9,6,4,1};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * @author binbin
     * @date 2022/9/11 下午3:50
     * @param arr  要进行基数排序的数组
     * 基数排序的思路：
     *  1. 设置0-9的十个桶，同时对数组中的所有元素进行遍历，找到最高位，最高位决定桶排序的次数
     *  2.在进行一次桶排序之后，就需要对数组进行重新赋值，按照桶的元素的顺序来排
     *  3.依次类推，直到获得正确的顺序
     */
    public  static void radixSort(int[] arr){
            //定义一个二维数组,其中10表示桶的总数，arr.length-1表示的是每个桶最大的容量（可以存储的最大元素）
        int[][]bucket=new int[10][arr.length-1];
        //表示实际每个桶所存的元素个数（索引表示第几个桶，其值表示该桶的元素个数）
        int[] bucketElementCounts=new int[10];

        //获取数组中的最大数
        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if (max<arr[i]){
                max=arr[i];
            }
        }

        //获取最大数之后，获取要桶排序的次数
        int maxCount=(max+"").length();
        //获取排序次数之后进行排序
        for (int i=0;i<maxCount;i++){
            //表示入桶的次数
            //其次需要遍历整个数组
            for (int k=0;k<arr.length;k++) {
                //首先需要获取的是要比较的数的位权，比如是个位还是百位
                int value=arr[k]/(int)Math.pow(10,i)%10;
                //第一个位置表示的是要存的第几个桶，第二个表示要存入的是第几个位置（默认初始化为0）
                bucket[value][bucketElementCounts[value]]=arr[k];
                //添加一个元素之后需要移动到下一个位置
                bucketElementCounts[value]++;
            }

            //定义要存放到数组的索引
            int index=0;
            for (int k=0;k<bucketElementCounts.length;k++){
                //此处判断表示的是某个位置的桶的元素个数不为0才会去遍历
                if(bucketElementCounts[k]!=0) {
                    //k表示第几个桶，bucketElementCounts.length表示的是到第几个桶为止，因为桶有10个，bucketElementCounts
                    //的索引也有10个（长度为10）
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        //j表示第k个桶的第几个元素，其最大值不能超过该桶所存元素的个数bucketElementCounts.length
                        arr[index]=bucket[k][j];
                        index++;
                    }
                }

                //便利完之后将该桶清空
                bucketElementCounts[k]=0;

            }


        }
    }
}
