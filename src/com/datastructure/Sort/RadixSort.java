package com.datastructure.Sort;

import java.util.Arrays;

/**
 * @author binbin
 * @date 2022年10月30日  下午3:31
 * 基数排序（桶排序）
 * 由下标为0-9的容器桶组成，其中存放着数组中对应位置的数（例如1则放在对应下标为1的桶中）
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr={53,3,542,748,14,214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * @author binbin
     * @date 2022/10/30 下午3:36
     * @param array  待排序的数组
     */
    public static void radixSort(int[] array){
        //定义一个二维数组来表示桶，每一个桶都是一个一维数组,但是由于每个桶中对应的存放的数据有所不同，
        //因此为了保险起见，将每个桶的大小设置为数组的长度，这是典型的空间换时间的方式
        int[][] bucket=new int[10][array.length];

        //为了记录每个桶中实际存放的数据（取出数据是需要明确每个桶取出数据的个数），因此使用一个一维
        // 数组来表示每个桶中存放的数据个数，但是该数组的数据需时常更新
        int[] bucketElementCount=new int[10];

      //首先需要找到数组中最大的位数
        int max=array[0];
        for (int i=1;i<array.length;i++){
            if (array[i]>max){
                max=array[i];
            }
        }
        //得到最大数的位数
        int maxLength=(max+"").length();
        int digitCapacity=0;
        //最外层循环表示要进行排序的次数
        for (int i=0;i<maxLength;i++){
            digitCapacity=(int)Math.pow(10,i);
            //该循环表示遍历整个数组，依次寻找个位、十位、百位上等的数
            for (int j=0;j<array.length;j++){
                //取出每个元素的值并进行相应的处理
                int digit=array[j]/digitCapacity%10;
                //得到后放入对应的桶中(digit表示下标为digit的桶，放在下标为digit的桶的具体位置是由
                // bucketElementCount[digit]的数值来决定，如果为0,则表示第digit号桶的第1个位置
                // 放入后需要对对应的位置进行递增操作)
                bucket[digit][bucketElementCount[digit]++]=array[j];
            }
            //定义下标来取出元素
            int index=0;
            //存入元素之后再依次取出并重新赋值到原先的数组中(k表示对应位置的桶)
            for (int k=0;k<bucketElementCount.length;k++){
                if (bucketElementCount[k]!=0){
                    //如果对应下标为k的桶中有数据，则需要进行取数操作
                    //循环遍历该桶中的数据
                    for (int l=0;l<bucketElementCount[k];l++){
                        array[index++]=bucket[k][l];
                    }
                }
                //取出之后需要将该桶清空，以便后续的正常使用
                bucketElementCount[k]=0;
            }

        }
    }

}
