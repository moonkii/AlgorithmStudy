package jongManBook._17_partSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*##############
 *     해결중
 * #############*/


public class Christmas {


    public static void main(String[] args){

        int c; //테스트 케이스 ( [0,60] )
        int n; //인형 상자의 개수 ( [1,100000] )
        int k; //어린이 수 ( [1,100000] )

        //누적합 최대치는 (10^10)
        long[] sum; //상자 별 인형의 개수 누적합
        int[] sumModCount; //누적합을 k 로 나눈 후 나오는 나머지 개수 ( 인덱스가 나머지로 나올 수 있는 경우의 수 0~(k-1) 까지고 , 값은 해당 나머지 개수)
        int[] sumMod;   //누적합을 k 로 나눈 나머지 수
        boolean[] sumModCheck;

        long result1=0; //1번 답

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                StringTokenizer st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());

                sum = new long[n+1]; // 상자를 하나만 사는 경우를 체크하기 위해서 누적합을 0부터 시작
                sumMod = new int[n+1];
                sumModCheck = new boolean[n+1];
                sumModCount = new int[k];
                sumModCount[0] +=1;

                st = new StringTokenizer(br.readLine());

                for(int j=0; j<=n; j++){


                    //누적합 및 누적합을 k 로 나눈 나머지 개수 체크
                    if(j==0){
                        sum[j] = 0;
                        sumMod[0] = 0;
                        sumModCount[0] +=1;
                    }else{
                        int temp = Integer.parseInt(st.nextToken());
                        sum[j] = sum[j-1] + temp;

                        sumMod[j] = Math.floorMod(sum[j],k);

                        int remain = Math.floorMod(sum[j],k);

                        //누적합을 k로 나눈 나머지가 같은 경우 체크
                        result1 += sumModCount[remain];


                        //누적합을 k로 나눈 나머지 값의 개수 체크
                        sumModCount[Math.floorMod(sum[j],k)] +=1;

                    }

                }


                System.out.println(result1%20091101);




            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
