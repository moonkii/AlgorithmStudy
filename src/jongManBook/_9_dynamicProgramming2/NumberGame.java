package jongManBook._9_dynamicProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NumberGame {


    public static int getResult( boolean[] boardCheck,int[] board, int[][] memo, int method, int order, int score){


        for(boolean check : boardCheck){
            if(check){
                break;
            }
        }

        return 0;

    }


    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //게임판 길이
        boolean[] boarddCheck;
        int board[];
        int memo[][];
        ArrayList<Integer> result;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            board = new int[n];
            memo = new int[n][n];
            boarddCheck = new boolean[n];


            for(int i=0; i<c ; i ++){
                result = new ArrayList<>();

                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    board[j] = Integer.parseInt(st.nextToken());
                }



            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
