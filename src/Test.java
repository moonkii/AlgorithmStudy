import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {



    public static void main(String[] args){

        int size =5;
        int[][] combi = new int[size+1][size+1];

        for(int y=0; y <=size ; y++){
            for(int x=0; x<y+1; x++){

                if(y==0 || x==0 | y==x){
                    combi[y][x]=1;
                }else{
                    combi[y][x] = combi[y-1][x-1] + combi[y-1][x];
                }
            }
        }
//
//        for(int i=0; i<=size; i++){
//            for(int j=0; j<=size; j++){
//                if(combi[i][j]!=0){
//                    System.out.print(combi[i][j]+" ");
//                }
//            }
//
//            System.out.println();
//        }
        System.out.println(Math.pow(0.75,0));

        }
    }

