package com.datastructure.Tree;

/**
 * @author binbin
 * @date 2022年12月11日  下午8:07
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr=new int[]{4,6,8,5,9};



    }

    /**
     * @author binbin
     * @date 2022/12/11 下午8:11
     * @param arr  待排序的数组
     *             该方法用于将数组进行堆排序
     */
    public static void heapSort(int[] arr){
        int temp=0;
        //进行堆排序操作
        //首先利用一个for循环，将原先的无序数组组成一个大顶堆（升序）
        for (int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,0,arr.length);
        }

        //然后进行调整，将堆顶元素与末尾元素交换,即末尾为最大值，次末尾为次小值
        for (int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            //找到最大值之后进行交换，之后还需要继续调整成大顶堆(依旧从0开始将无序的排列成有序的，元素个数是j个之后不停减少)
            adjustHeap(arr,0,j);
        }

    }


    /**
     * @author binbin
     * @date 2022/12/11 下午8:13
     * @param arr  待处理的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少元素进行调整 是逐渐减少的
     *             将以i为索引的节点调整成大顶堆
     *             规则为：父节点的值始终大于等于其左右子节点，左右子节点并无明显的大小关系。
     */
    public static void  adjustHeap(int[] arr, int i ,int length){
        //首先保存非叶子节点的值（即以i为父节点的局部的值）
        int temp=arr[i];
        //利用for循环从i的位置向下找，找到比i索引更大的值之后进行交换
        for (int k= 2*i+1;k<length;k=k*2+1){
            //k表示从i位置的左节点开始进行寻找，只要当前的k小于length都是合法的，k=k*2+1表示依旧向左找
            if (k+1<length && arr[k]<arr[k+1]){
                //此时表示左子节点的值小于右子节点,此时k需要自增，到右子节点，继续进行比较
                k++;
            }

            if (arr[k]>temp){
                //此时表示找到了第一个比i位置的值大的节点了，需要进行交换
                arr[i]=arr[k];
                //此处十分关键，表示交换值之后，后续的遍历从k开始，而不是从原来的i值开始，因为如果i保持不变会陷入死循环
                i=k;
            }else{
                //如果小于temp则直接退出循环
                break;
            }
        }
        //for循环的结束表示将以i为父节点的树进行了调整
        //最后再将较小的值放到最大值的位置，因为i=k进行过调整，所以i此时指向的是k
        arr[i]=temp;


    }
}