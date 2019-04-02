package _8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*##############
 *     완료
 * #############*/


/* 풀이 기록
 * 1. 출력할려는 경우의 수가 long 의 범위를 넘어서는 경우 ( double 로 할 경우 오차발생 )
 *  - 원인 : 경우의 수가 피보나치 수열로 증가하기 때문에 사각형 높이 값을 100 까지 입력할 경우 long 의 범위를 벗어남
 *  - 해결책 : 피보나치 수열을 구할 때 값들을 미리 mod 값(1000000007) 으로 나누어 나머지 값들에 대한 피보나치 수열을 구함
 * */

public class Tiling2 {
    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //사각형 높이
        int[] memo;
        int mod = 1000000007;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                memo = new int[101];

                n = Integer.parseInt(br.readLine());

                for(int j=1; j<=n ; j++){

                    if(j==1){
                        memo[j] = 1;
                    }else if(j==2){
                        memo[j]= 2;
                    }else{

                        memo[j] = (memo[j-1] + memo[j-2]) % mod;
                    }
                }


                System.out.println(memo[n]);



            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
