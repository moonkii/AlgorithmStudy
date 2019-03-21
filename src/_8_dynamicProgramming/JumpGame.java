package _8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpGame {

    public static int jump(int[][] b, boolean[][] cache , int y, int x){


        //기저 사례
        if(x >= b[0].length || y >= b.length ){
            return 0;
        }

        if( x ==(b[0].length - 1) && y == b.length-1){
            return 1;
        }

        if(cache[y][x]){
            //메모이제이션 체크 (true 일 경우 이미 체크한 경우이기 때문에 0은 리턴해도 상관없음)
            return 0;

        }else{
            //도착 좌표에 있는 값
            int v = b[y][x];

            //메모이제이션
            cache[y][x] = true;

            //오른쪽 , 아래 가는 경우 나누어줌
            int right = jump(b,cache,y,x+v);
            int down = jump(b,cache,y+v,x);

            int count = right + down;

            return count;
        }


    }


    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                int n = Integer.parseInt(br.readLine()); //격자 크기

                int[][] board = new int[n][n];
                boolean[][] cache = new boolean[n][n];

                //격자판 입력 배열에 저장
                for(int y=0; y<n; y++){

                    StringTokenizer st = new StringTokenizer(br.readLine());

                    for (int x=0; x<n; x++){
                        board[y][x] = Integer.parseInt(st.nextToken());
                    }
                }


                int result = jump(board,cache,0,0);

                if(result >= 1 ){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }





            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
