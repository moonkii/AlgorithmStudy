package _8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Snail {

    public static void combination(int[][] combi, int size){

        for(int y=0; y <=size ; y++){
            for(int x=0; x<y+1; x++){

                if(y==0 || x==0 | y==x){
                    combi[y][x]=1;
                }else{
                    combi[y][x] = combi[y-1][x-1] + combi[y-1][x];
                }
            }
        }

    }

    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //우물의 깊이 ( [1,1000])
        int m; //장마 길이 ( [1,1000] )

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                StringTokenizer st= new StringTokenizer(br.readLine());

                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());

                int[][] combi = new int[m+1][m+1];
                combination(combi,m);
                double probability=0;

                for(int j=0; j<=m ; j++){

                    if( (2*j) + (m-j) >= n){

                        probability += ( Math.pow(0.75,j) * Math.pow(0.25,m-j) * combi[m][m-j] );
                    }
                }


                System.out.println(probability);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
