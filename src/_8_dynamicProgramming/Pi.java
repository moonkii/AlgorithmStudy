package _8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pi {


//
//    public static int getLevel(int[] array, int a, int b){
//
//
//        for(int i=a+1; i<=b; i++){
//
//            if(array[a] == array[a-1]){
//
//            }
//        }
//
//    }


    public static void main(String[] args){

        int c; //테스트 케이스
        String n; //입력 라인
        int[] array;
        int[] cache = new int[10000];


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());
            n = br.readLine();
            array = new int[n.length()];
            for(int i=0; i<c ; i ++){

                for(int j=0; j<n.length() ; j++){

                    String temp ="";
                    temp += n.charAt(j);
                    array[j] = Integer.parseInt(temp);

                }





            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
