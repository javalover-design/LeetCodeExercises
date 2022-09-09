package com.AlgorithmExercise.sort;

/**
 * @author binbin
 * @date 2022年09月09日  下午8:42
 * 希尔排序与插入排序类似，插入排序的插入步长为1,而希尔排序的插入步长是不固定的，但最后都会变为1
 * 可以说插入排序是步长为1的希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {int[] arr=new int[]{1,5,6,9,7};
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }



    }


    /**
     * @author binbin
     * @date 2022/9/9 下午8:43
     * @param arr
     * public static void insertSort(int[] arr){
     *         //首先设置要进行选择排序的次数，次数为n-1次，n表示数组长度，从下标1开始遍历（0下标无法与前一个数比较）
     *         for (int i=1;i<arr.length;i++){
     *             //每次进行新一轮插入排序，需要设置插入的下标与位置
     *             int insertIndex=i;
     *             int insertValue=arr[i];
     *             //进行循环比较，从insertIndex位置开始向前挨个比较，遇到大的，将改值后移，插入下标前移动一位
     *             while (insertIndex>0 && insertValue<arr[insertIndex-1]){
     *                 //需要保证插入的下标大于0,因为如果等于0,第二个条件跟前一个数比较就会出现下标越界。
     *                 //将较大值后移，同时，插入下标前移动一位
     *                 arr[insertIndex]=arr[insertIndex-1];
     *                 insertIndex--;
     *             }
     *             //当一轮循环结束之后，需要将原先保存的需要插入的值，赋值到insertIndex的位置
     *             arr[insertIndex]=insertValue;
     *             //此时选择排序完成
     *
     *         }
     *
     *     }
     */
    public static void shellSort(int[] arr){
        //定义步长，即一次比较的大小
        for (int gap=arr.length/2;gap>0;gap=gap/2){
            //内层使用类似于简单选择排序的循环来进行排序，只不过需要换成对应的步长
            for (int i= gap;i<arr.length;i++){
                //从对应的步长开始，思路类似于简单插入排序
                    int insertIndex=i;
                    int insertValue=arr[i];
                    while (insertIndex-gap>=0 && insertValue<arr[insertIndex-gap]){
                        //循环中对应插入下标减去步长始终需要大于等于0,不能小于0（因为是移动gap个位置）
                        arr[insertIndex]=arr[insertIndex-gap];
                        insertIndex-=gap;
                    }
                    //当一次循环结束之后需要将原先保存的值填入到insertIndex的位置
                arr[insertIndex]=insertValue;
            }
        }

    }
}
