package _7_divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*##############
 *      완료
 * #############*/


/* 풀이 기록
 * 1. 재귀함수에서 리턴값으로 문자열과 순서 index 를 동시에 받아와야하는 문제
 *  1-1) 원인 : 재귀함수에서 처리한 문자값은 문자값대로 계속 추가해줘야하고 순서 index 도 계속 반영해서 추가해 나가야 문제 해결 가능
 *  1-2) 해결책 : 결과 문자열과 순서 index 를 배열에 담아서 각각 다음으로 리턴해줌
 * */
public class QuadTree {



    public static String[] getResult(int order, int size ,String tree){


        if(order >= size){
            //문자열 끝에 도착
            return null;
        }else{


            /* 기저사례
             * tree 의 order 번째 글자가 w 나 b이면 글자 그대로 값과 order+1 값을 담은 배열 리턴
             * ( order+1 은 그다음번 검사할 문자열을 번호 )
             * */
            if(tree.charAt(order)=='w'){

                int next = order+1;
                String[] r = {"w",String.valueOf(next)};

                return r;

            }else if(tree.charAt(order)=='b'){

                int next = order+1;
                String[] r = {"b",String.valueOf(next)};

                return r;



            }else{
                // 문자가 x 일때 (재귀로 순서대로 문자열을 체크하고 다음으로 검사할 순서값을 계산해서 리턴해줌)

                //왼쪽 위
                String[] ul = getResult(order+1,size,tree);
                String upperLeft  = ul[0];

                //오른쪽 위
                String[] ur = getResult(Integer.parseInt(ul[1]),size,tree);
                String upperRight = ur[0];

                //왼쪽 아래
                String[] ll =  getResult(Integer.parseInt(ur[1]),size,tree);
                String lowerLeft = ll[0];

                //오른쪽 아래
                String[] lr = getResult(Integer.parseInt(ll[1]),size,tree);
                String lowerRight = lr[0];

                //마지막에 쿼트 트리를 뒤집어줌 ( 1,3 / 2,4 위치 바꿔줌)
                String[] last = {"x"+lowerLeft+lowerRight+upperLeft+upperRight, lr[1]};

                return last;

            }


        }


    }


    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());   //테스트 케이스

        for(int i=0; i<c; i++){

            String tree = br.readLine();

            //결과
            String[] output = getResult(0,tree.length(),tree);

            //출력
            System.out.println(output[0]);


        }


    }



}
