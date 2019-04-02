package _8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class AsymTiling {

    public static void getTilingCount(){

    }


    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //사격형의 너비 ( [1,100] )
        double[] tiling;   //너비 별 타일을 채울수 있는 총 경우의 수
        double mod = 1000000007;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                n = Integer.parseInt(br.readLine());
                tiling = new double[n+1];

                for(int j=1; j<=n ; j++){

                    if(j==1){
                        tiling[j] = 1;
                    }else if(j==2){
                        tiling[j] = 2;
                    }else{
                        tiling[j] = tiling[j-1] + tiling[j-2];
                    }
                }

                double result=0;

                if(n==1) {

                }else if(n==2){

                }else{

                    if( (n % 2) == 1){
                        //n이 홀수
                        result = tiling[n] - tiling[ (n-1)%2 ];

                    }else{
                        result = tiling[n] - tiling[ (n-2)/2 ] - tiling [ n/2 ];

                    }

                }


                System.out.println((long) (result % mod ));




            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
