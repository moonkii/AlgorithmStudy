package jongManBook._10_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/* 풀이법
 * 1. 각 팀의 레이팅 점수를 어레이리스트에 저장
 * 2. 어레이리스트를 오름차순으로 정렬
 * 3. 오름차순이기 때문에 양 팀의 가장 낮은 레이팅 부터 비교
 * 4. 한국팀이 러시아 팀의 레이팅을 최대한 낮은 레이팅으로 이길 수 있도록 배치
 * 5. 한국팀이 이길 수 없는 러시아 팀의 레이팅 중 가장 높은 레이팅 값에는 한국팀의 가장 낮은 레이팅 값을 할당 ( 여기서는 이까지 안해줘도 답 구할 수 있음 )
 * */

public class MatchOrder {

    public static void main(String[] args){

        int c; //테스트 케이스 ( [0,50] )
        int n; //각팀 선수 수 ( [1,100] )
        ArrayList<Integer> russia;
        ArrayList<Integer> korea;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                n = Integer.parseInt(br.readLine());

                russia = new ArrayList<>();
                korea = new ArrayList<>();

                //러시아팀 레이팅
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int r =0; r<n; r++){
                    russia.add(Integer.parseInt(st.nextToken()));
                }

                //한국팀 레이팅
                st= new StringTokenizer(br.readLine());
                for(int k =0; k<n; k++){
                    korea.add(Integer.parseInt(st.nextToken()));
                }


                //양 팀 레이팅 오름차순 정렬
                Collections.sort(russia);
                Collections.sort(korea);

                int winCount=0;
                for(int rr=0; rr<n; rr++){
                    for(int kk=0; kk<korea.size(); kk++){

                        if(russia.get(rr) <= korea.get(kk)){
                            winCount++;
                            korea.remove(kk);
                            break;
                        }

                    }
                }

                System.out.println(winCount);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
