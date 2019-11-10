package com.wx;

public class RecursionTest {

    public int factorial(int n){
        if(n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }

    public int f2(int n){
        if(n==1 || n==2){
            return 1;
        }else{
            return f2(n-1)+f2(n-2);
        }
    }

    public static void moveDish(int level, char from, char inter, char to) {

        if (level == 1) { // 递归终止条件
            System.out.println("从" + from + " 移动盘子" + level + " 号到" + to);
        } else {
            // 递归调用：将level-1个盘子从from移到inter(不是一次性移动，每次只能移动一个盘子,其中to用于周转)
            moveDish(level - 1, from, to, inter); // 递归调用，缩小问题的规模
            // 将第level个盘子从A座移到C座
            System.out.println("从" + from + " 移动盘子" + level + " 号到" + to);
            // 递归调用：将level-1个盘子从inter移到to,from 用于周转
            moveDish(level - 1, inter, from, to); // 递归调用，缩小问题的规模
        }
    }


    public static void main(String args[]){
        RecursionTest res = new RecursionTest();
        int nDisks = 4;
        moveDish(nDisks, 'A', 'B', 'C');
    }

}
