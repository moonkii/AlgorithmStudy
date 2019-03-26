package _8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/* 풀이 기록
 * 입력받은 배열의 크기만 큼 동일한 배열을 새로 생성해서 동일한 인덱스로 길이 값을 저장해줌
 * 자기 자신을 길이 +1 해주고, 입력 받은 숫자보다 작으면서, 이전에 위치해 있는 숫자들 중 증가 부분수열의 길이가 가장 긴 값만큼 자신의 길이에 더해줌
 * 배열 { 1,   5,       8,       3,       2,            4,       9 }
 * 길이 { 1, 2(1+1),  3(1+2),  2(1+1),    2(1+1),     3(1+2),   4(1+3) }
 *
 * */
public class Lis {


    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int c = Integer.parseInt(br.readLine());    //테스트 케이스 ( [0,50] )

            for(int i=0; i<c ; i ++){

                int n = Integer.parseInt(br.readLine()); //수열의 원소 수( [0,500] )
                int[] array = new int[n];   //입력 받은 숫자 배열
                int[] check = new int[n];   //배열의 각 자리 숫자가 가질 수 있는 증가부분수열의 최대 길이

                StringTokenizer st = new StringTokenizer(br.readLine());

                int index=0;    //입력받는 숫자의 인덱스

                while (st.hasMoreTokens()){


                    array[index] = Integer.parseInt(st.nextToken());
                    check[index] += 1;  //자기 자신을 길이에 포함하기 때문에 +1

                    int maxSum=0; //이전 숫자 중 증가부분수열의 최대 길이 ( 입력받은 숫자 보다 작아야함)

                    //입력받은 숫자 보다 작으면서 배열에서 이전에 위치한 숫자들의 증가부분수열의 길이 확인
                    for(int j=index-1; j>=0; j--){
                        if(array[j] < array[index]){
                            if(maxSum < check[j]){
                                maxSum = check[j];
                            }
                        }
                    }

                    check[index] += maxSum;

                    index +=1;


                }


                int max=0;
                for(int r = 0; r < n; r++){
                    if(check[r] >= max){
                        max = check[r];
                    }


                }

                System.out.println(max);



            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
