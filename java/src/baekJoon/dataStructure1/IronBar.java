package baekJoon.dataStructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;


/* 풀이법
 * 1. 입력받은 괄호값을 0부터 순서대로 인덱스 값을 부여한다.
 * 2. 스택을 생성하여 입력받은 값이 열린괄호의 값인 경우 스택에 해당 괄호의 인덱스 값을 저장한다.
 * 3. 입력받은 값이 닫힌괄호의 경우 스택의 가장 상단 인덱스값과 짝인 수이다.
 * 4. 닫힌괄호의 인덱스 값과 열린괄호의 인덱스 값을 각각 배열에 저장한다. 이때 스택에 저장된 열린괄호의 인덱스 값은 pop() 해준다.
 * 5. 닫힌괄호의 인덱스 값과 열린괄호의 인덱스 값의 차이가 1 인경우 레이저이므로 별도의 어레이리스트에 레이저의 열린괄호 인덱스 값을 저장해준다.
 * 6. for 문을 돌면서 레이저의 시작 인덱스값이 열린괄호 인덱스 배열과 닫힌괄호 인덱스 배열 범위 안에 있으면 +1 씩 카운트 해준다. ( 기본적으로 레이저가 아니면 쇠막대의 수는 1 이다.)
 *
 * */

public class IronBar {

    public static void main(String[] args){

        int c; //테스트 케이스

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            //입력값 받기
            String line = br.readLine();
            char[] input = line.toCharArray();

            //괄호 짝의 시작과 끝 인덱스 번호 담는 배열
            int[] startIndex = new int[input.length/2];
            int[] endIndex = new int[input.length/2];
            ArrayList<Integer> laser = new ArrayList<>();
            int order = 0;


            //열린 괄호의 인덱스 번호 담는 스택
            Stack<Integer> openStack = new Stack<>();


            for(int i=0; i<input.length; i++){

                if(input[i] =='('){
                    //열린 괄호인 경우 해당 인덱스를 스택에 저장
                    openStack.push(i);
                }else if(input[i] == ')'){
                    //닫힌 괄호인 경우 스택 pop 의 값을 시작번호 담는 배열에 넣어주고, 해당 인덱스를 끝번호 담는 배열에 넣어줌
                    startIndex[order] = openStack.pop();
                    endIndex[order] = i;

                    //레이저의 경우 열린 괄호의 인덱스 값 저장
                    if(endIndex[order] - startIndex[order] == 1){
                        laser.add(startIndex[order]);
                    }

                    order += 1;
                }
            }


            int total = 0;

            for(int s=0; s<startIndex.length; s++){
                int count = 0;
                int startNum = startIndex[s];
                int endNum = endIndex[s];

                //레이저가 아닌 경우에만 카운트
                if(endNum - startNum !=1 ){

                    count = 1;
                    for(int l =0; l<laser.size(); l++){
                        if (startNum < laser.get(l) && endNum > laser.get(l) ){
                            count += 1;
                        }
                    }
                }

                total += count;

            }

            System.out.println(total);




        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
