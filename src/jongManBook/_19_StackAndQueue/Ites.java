package jongManBook._19_StackAndQueue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*##############
 *     완료
 * #############*/


/* 풀이 기록
 * 1. 입력값이 올바르지 않는 에러
 *  1-1) 원인 : 공식은 제대로 넣었으나 변수 타입을 long 로 해야 정확한 값이 나옴 (처음에 int 를 사용해서 에러 발생)
 *  1-2) 해결책 : 자릿수 확인하고 int(32비트) 변수를 long(64비트)변수로 바꿔줌 (자바에는 unsignedInt 가 없기 때문에 long 을 사용해야 함 )
 *
 * 2. 동일한 입력값을 넣어도 결과가 다르게 나오는 에러
 *  2-1) 원인 : 큐를 전역변수로 선언해서 초기화가 되지 않아 계속 이전 테스트 케이스가 다음 테스트 케이스에 영향을 미침
 *  2-2) 해결책 : 큐를 테스트 케이스 for 문 안에다가 넣어줌 (그외 sum 이나 preNumber 변수 등도 주의!)
 * */

public class Ites {

    //i 번째 입력 신호 만드는 메서드
    public static long getSignal(long input){
        return input%10000+1;
    }

    //i 번째 입력 신호를 만들기 위한 A[i] 만드는 메서드
    public static long setAi(long pre){

        return Double.valueOf((pre*214013+2531011)%Math.pow(2,32)).longValue(); // A[i] 번째 입력
    }

    public static void main(String args[]){

        int c=0;     // 테스트 케이스 ( [1,20] )
        int[] count; // 케이스 별 조건 성립하는 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = null;

        try {
            //테스트 케이스 입력
            String testCase=br.readLine();
            c = Integer.parseInt(testCase);


        } catch (IOException e) {
            e.printStackTrace();
        }


        //테스트 케이스 수 만큼 결과값 배열 할당
        count = new int[c];

        for(int i=0; i<c; i++){
            //테스트 케이스만큼 루프

            try {
                Queue<Long> queue = new LinkedList<>();  //입력담는 큐
                stringTokenizer = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(stringTokenizer.nextToken());     // 합 ( [1,5000000] )
                int n = Integer.parseInt(stringTokenizer.nextToken());     // 신호의 길이 ( [1,50000000] )

                long sum = 0;   //케이스 누적합 초기화
                long preNumber = 1983;     //A[i-1] 수

                    for(int j=0; j<n; j++){
                        //신호 길이만큼 루프

                        long signal; //입력신호

                        if(j==0){
                            //A[0] 입력과 시그널 구하기
                            signal = getSignal(preNumber);
                            preNumber=setAi(preNumber);
                            queue.offer(signal);
                            sum = signal;


                        }else{
                            //A[1]부터 입력과 시그널 구하기
                            signal = getSignal(preNumber);
                            preNumber = setAi(preNumber);
                            queue.offer(signal);
                            sum += signal;
                        }


                        //값이 구하려는 합의 값보다 적으면 for 문을 넘아것 다음 합을 구하고, 구하려는 값보다 크거나 같으면 큐의 제일 첫번 째 값을 제거해주면서 답을 찾아감
                            while(sum>=k){

                                if(sum ==k){
                                    count[i] += 1;

                                }

                                if(!queue.isEmpty())
                                    sum -= queue.poll();

                            }


                    }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        //마지막 결과값 출력
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for(int result : count){
                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.flush();
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
