package com.datastructure.array;

/**
 * @author binbin
 * @date 2022年09月02日  下午10:00
 */
public class SparseArray {
    public static void main(String[] args) {
        //定义一个二维数组，11*11的
        int[][]chessArray=new int[11][11];
        //其中二维数组中在（1,2）（2,3）中存在非0值
        chessArray[1][2]=1;
        chessArray[2][3]=2 ;
        int sum=0;
        //遍历二维数组
        for (int[] row:chessArray){
           for (int item:row){
               if (item!=0){
                   sum++;
               }
                System.out.printf("%d\t",item);
           }
           System.out.println();
       }
        System.out.println("sum="+sum);

        System.out.println(chessArray.length);
        System.out.println(chessArray[0].length);
        System.out.println("===============================");


       //将二维数组转成稀疏数组
        //首先遍历有多少个有效数据 sum
        int[][]sparseArray=new int[sum+1][3];
        sparseArray[0][0]=chessArray.length;
        sparseArray[0][1]=chessArray[0].length;
        sparseArray[0][2]=sum;
        //count用于记录出现非0数值的次数
        int s=0;
        for (int i=0;i< chessArray.length;i++){
            for (int j=0;j<chessArray[0].length;j++){
                if (chessArray[i][j]!=0){
                    System.out.println("row:"+i);
                    System.out.println("column:"+j);
                        s++;
                        sparseArray[s][0]=i;
                        sparseArray[s][1]=j;
                        sparseArray[s][2]=chessArray[i][j];
                }

            }
        }
        for (int[] a:sparseArray){
            for (int b:a){

                System.out.printf("%d\t",b);
            }
            System.out.println();
        }
        System.out.println("=====================");

        //将稀疏数组还原成二维数组
        int[][]arr=new int[sparseArray[0][0]][sparseArray[0][1]];
      for (int m=1;m< sparseArray.length;m++){
          arr[sparseArray[m][0]][sparseArray[m][1]]=sparseArray[m][2];
      }

      for (int[] rows:arr){
          for (int i:rows){
              System.out.printf("%d\t",i);
          }
          System.out.println();
      }

    }
}
