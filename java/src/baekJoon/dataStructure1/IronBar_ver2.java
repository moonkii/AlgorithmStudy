package baekJoon.dataStructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronBar_ver2 {

    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            //입력값 받기
            String line = br.readLine();
            char[] input = line.toCharArray();

            //열린 괄호의 인덱스 번호 담는 스택
            Stack<Integer> openStack = new Stack<>();


            int total=0;

            for(int i=0; i<input.length; i++){

                if(input[i] =='('){

                    if(i+1 < input.length && input[i+1] == ')'){

                        if(!openStack.empty()){
                            total += openStack.size();
                        }

                        i++;

                    }else{
                        //열린 괄호인 경우 해당 인덱스를 스택에 저장
                        openStack.push(i);
                        total+=1;
                    }


                }else if(input[i] == ')'){
                    openStack.pop();
                }
            }

            System.out.println(total);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
