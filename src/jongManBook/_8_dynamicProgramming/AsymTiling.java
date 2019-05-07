package jongManBook._8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/*##############
 *     완료
 * #############*/

public class AsymTiling {


    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //사격형의 너비 ( [1,100] )
        int[] tiling;   //너비 별 타일을 채울수 있는 총 경우의 수
        int mod = 1000000007;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                n = Integer.parseInt(br.readLine());
                tiling = new int[n+1];

                for(int j=1; j<=n ; j++){

                    if(j==1){
                        tiling[j] = 1;
                    }else if(j==2){
                        tiling[j] = 2;
                    }else{
                        tiling[j] = ( tiling[j-1] + tiling[j-2] ) % mod;
                    }
                }

                int result=0;

                if(n==1) {

                }else if(n==2){

                }else{

                    if( (n % 2) == 1){
                        //n이 홀수
                        result = (tiling[n] - tiling[ (n-1)/2 ] + mod) % mod;

                    }else {
                        //n이 짝수 ( 이부분 이해 안됨)
                        result = tiling[n];
                        result = (result  - tiling[(n - 2) / 2] +mod )%mod;
                        result = (result - tiling[n / 2] +mod )%mod;
                    }


                }


                System.out.println(result);




            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
