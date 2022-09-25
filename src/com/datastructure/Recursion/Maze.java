package com.datastructure.Recursion;

import java.util.HashMap;

/**
 * @author binbin
 * @date 2022年09月24日  下午7:17
 * 迷宫问题
 */
public class Maze {
    public static void main(String[] args) {
        //首先利用二维数组来模拟迷宫(8行7列)
        int[][] maze=new int[8][7];
        //其中在数组中用1表示此路径不可走，表示墙(第0行和第7行所有的列均为1)
        for (int i=0;i<7;i++){
            maze[0][i]=1;
            maze[7][i]=1;
        }
        //左右也全部重置为1
        for (int i=0;i<8;i++){
            maze[i][0]=1;
            maze[i][6]=1;
        }
        maze[3][1]=1;
        maze[3][2]=1;
        maze[1][2]=1;
        maze[2][2]=1;
        //输出地图
        System.out.println("初始的地图如下：");
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
        //使用方法模拟小球路径.因为maze是个引用类型，传递的是引用，递归能够对同一张地图进行更改。
        setWay2(maze,1,1);

        System.out.println("走过后的地图样式");
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }


    /**
     * @author binbin
     * @date 2022/9/24 下午7:28
     * @param map 地图
     * @param i 对应起始位置的横坐标
     * @param j 对应起始位置的纵坐标
     * @return boolean 是否找到的信号量
     * 使用递归回溯给小球找路
     * map表示对应的地图
     * ij表示地图的起始位置 起始位置为（1,1）
     * 如果小球能够到达map[6][5]，则表示通路已经找到
     * 当map[i][j]=0的时候表示该点没有测试过（没有走过），当为1的时候,则表示是个墙，无法通行，如果为2的时候，
     * 则表示是个通路，可以走。3表示该点走过，但是无法通行。
     * 在走迷宫的时候，有一定的策略，方向的顺序按照下右上左的顺序来走。如果该点走不通，再回溯
     *
     */
    public static boolean setWay(int[][] map,int i, int j){
        if (map[6][5]==2){
            //通路65的坐标为2,表示已经找到
            return true;
        }else{
            //如果当前的路还没走过
            if (map[i][j]==0){
                //没有走过，此时可以按照下右上左的行走策略进行操作
                //假定该点可以走，是个通路,若不通，可以回溯
                map[i][j]=2;
                //表示向下走，行i+1表示向下走，递归调用
                if (setWay(map,i+1,j)){
                    //如果能走通，则返true
                    return true;
                    //如果走不通，则继续向右走
                }else if (setWay(map,i,j+1)){
                    //能走通，返回true
                    return true;
                }else if (setWay(map,i-1,j)){
                    //能走通，则返回true
                    return true;
                }else if (setWay(map,i,j-1)){
                    //能走通，则返回true
                    return true;
                }else{
                   //如果下右上左均走不通，则需要将该点置为3,表示是个死路
                    map[i][j]=3;
                    //返回假，表示该路是无法走通的
                    return false;
                }
            }else{
                //如果map[i][j]不为0的时候，则表示该点有3种情况，1表示为墙，2表示为已经走过的路，3表示走过，但是无法
                // 走通，直接返回false
                return false;
            }
        }


    }

    /**
     * @author binbin
     * @date 2022/9/25 下午1:54
     * @param map
     * @param i
     * @param j 
     * @return boolean 
     */
    public static boolean setWay2(int[][]map,int i, int j){
        if (map[6][5]==2){
             return true;
        }else{
            if (map[i][j]==0){
                map[i][j]=2;
                if (setWay2(map,i-1,j)){
                    return true;
                }else if (setWay2(map,i,j+1)){
                    return true;
                }else if (setWay2(map,i+1,j)){
                    return true;
                }else if (setWay2(map,i,j-1)){
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else{
                return false;
            }
        }

    }
}
