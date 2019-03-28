package _8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*##############
 *     완료
 * #############*/

public class TrianglePath {

    public static int max(int a, int b){
        if(a>=b){
            return a;
        }else{
            return b;
        }
    }


    public static int getPathSum(int[][] triangle,int[][] cache, int y, int x){



        if(y>=triangle.length || triangle[y][x]==0){
            //아래나 오른쪽 아래로 갈 수 없을 때
            return 0;
        }


        if(y==(triangle.length-1)){
            //마지막 줄에 도달 했을 때
            return triangle[y][x];


        }else{


            if(cache[y][x] != 0){
                //해당 위치부터 최대값이 메모이제이션 되어있는 경우
                return cache[y][x];

            }else{

                //가장 아래줄 부터 거슬러 올라가면서 합이 최대인 경우를 구함(구해진 경우 메모이제이션)
                int result = max(getPathSum(triangle,cache,y+1,x),getPathSum(triangle,cache,y+1,x+1));
                cache[y][x] = result+triangle[y][x];

                return result + triangle[y][x];
            }


        }


    }


    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //삼각형 크기
        int[][] triangle;
        int[][] cache;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                n = Integer.parseInt(br.readLine());
                triangle = new int[n][n];
                cache = new int[n][n];


                for(int j=0; j<n; j++){
                    StringTokenizer st = new StringTokenizer(br.readLine());

                    int index=0;
                    while(st.hasMoreTokens()){

                        triangle[j][index]=Integer.parseInt(st.nextToken());
                        index +=1;

                    }

                }

                System.out.println(getPathSum(triangle,cache,0,0));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
