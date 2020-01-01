package jongManBook._10_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/* 풀이법
 * 1. 먹는시간을 내림차순을 정렬 ( 데우는 시간과 한 쌍 )
 * 2. 먹는 시간이 같은 경우 데우는 시간이 큰 경우가 우선 순위
 * 3. 정렬된 상태에서 인덱스 순차별로 데우는 시간의 누적합 + 해당 인덱스의 먹는 시간의 합 중 가장 큰값이 점심 시간의 최소값
 *
 * 예) 정렬 후 상태
 *  index   | 0  1  2  3
 *  hitTime | 1  6  5  3
 *  eatTime | 20 18 3  1
 *  result  | 21 25 15 16   => 25가 답
 * */

public class LunchBox {


    public static void main(String[] args){

        int c; //테스트 케이스 ( [0,300] )
        int n; //도시락 수 ( [1,10000] )

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());

            for(int i=0; i<c ; i ++){

                n = Integer.parseInt(br.readLine());
                TimePack[] timePacks = new TimePack[n];


                //도시락 데우는 시간 입력
                StringTokenizer ht = new StringTokenizer(br.readLine());

                //도시락 먹는 시간 입력
                StringTokenizer et = new StringTokenizer(br.readLine());

                for(int j=0; j<n ; j++){
                    timePacks[j] = new TimePack(Integer.parseInt(ht.nextToken()), Integer.parseInt(et.nextToken()));
                }

                //내림차순으로 정렬
                Arrays.sort(timePacks);

                int hitTimeSum=0;
                int resultTime = 0;
                for(int r =0; r<timePacks.length; r++){
                    hitTimeSum += timePacks[r].getHitTime();
                    int temp = hitTimeSum + timePacks[r].getEatTime();
                    if(resultTime < temp){
                        resultTime = temp;
                    }
                }

                System.out.println(resultTime);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

class TimePack implements Comparable<TimePack>{
    private int hitTime;
    private int eatTime;


    public TimePack(int hitTime, int eatTime) {
        this.hitTime = hitTime;
        this.eatTime = eatTime;
    }

    public int getHitTime() {
        return hitTime;
    }

    public int getEatTime() {
        return eatTime;
    }

    @Override
    public int compareTo(TimePack o) {

        //크기가 같을 경우 0 리턴 , 비교대상(매개변수)가 작을 경우 음수 리턴, 비교대상(매개변수)가 클 경우 양수 리턴

        if( eatTime == o.eatTime){
            return 0;
        }

        //내림차순 정렬
        return o.eatTime - eatTime;
    }
}
