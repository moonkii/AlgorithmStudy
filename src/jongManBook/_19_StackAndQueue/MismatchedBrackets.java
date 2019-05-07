package jongManBook._19_StackAndQueue;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


/*##############
 *     완료
 * #############*/


/* 풀이 기록
* 1. 런타임 에러
*  1-1) 원인 : 입력값이 여는 부호일 경우에만 값을 스택에 쌓기 때문에 처음에 입력값을 닫힌 부호로 입력했을 때 에러가 발생함
*  1-2) 해결책 : 입력값이 닫힌 부호로 시작될 때를 대비해서 스택에서 peek() 호출 전에 isEmpty() 로 스택이 비어있는지 먼저 확인
* */

public class MismatchedBrackets {
    public static void main(String[] args) {

        //짝이 맞지 않는 괄호 문제

        int c; // 테스트 케이스 ( 1 <= c <= 100 )
        String[] results; //결과값

        //입력 받는 버퍼 리더 ( .read() / .readLine() )
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer stringTokenizer = null;

        try{

            //테스트 케이스 입력 받기
            c = Integer.parseInt(bufferedReader.readLine());
            results = new String[c];

            for(int i=0; i<c; i++){

                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                //입력이 공백없이 주어지기 때문에 char 타입으로 한글자씩 스플릿해서 받아야함
                Stack<Character> stack = new Stack<>();

                while(stringTokenizer.hasMoreTokens()){

                    String bracket = stringTokenizer.nextToken();

                    for(int j=0; j<bracket.length() ; j++){
                        char temp = bracket.charAt(j);

                        if(temp=='(' || temp =='{' || temp =='['){
                            stack.push(temp);


                        }else if(temp==')'){

                            /* stack.isEmpty() 를 체크해주지 않으면 입력을 ')', '}', ']' 와 같이 닫는 괄호를 받았을 때
                            * 에러가 발생함 (스택이 비어있는 상태에서 peek() 을 호출하기 떄문에) */
                            if(!stack.isEmpty() && stack.peek()==('(')){
                                stack.pop();

                            }else{
                                stack.push(temp);


                            }

                        }else if(temp==('}')){
                            if(!stack.isEmpty() &&stack.peek()==('{')){
                                stack.pop();

                            }else{
                                stack.push(temp);

                            }

                        }else if(temp==']'){
                            if(!stack.isEmpty() &&stack.peek()==('[')){
                                stack.pop();
                            }else{
                                stack.push(temp);
                            }
                        }


                    }






                }

                if(stack.isEmpty()){
                    results[i] = "YES";
                }else{
                    results[i] = "NO";
                }


            }


            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            for(String r : results){

                bufferedWriter.write(r);
                bufferedWriter.flush();
                bufferedWriter.newLine();


            }


            bufferedReader.close();
            bufferedWriter.close();



        }catch(IOException e){

        }


    }

}
