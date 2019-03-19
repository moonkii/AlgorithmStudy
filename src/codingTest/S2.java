package codingTest;

import java.util.ArrayList;
import java.util.Scanner;

public class S2 {
    /* 원소 표기 문제
    *  예를들어 CO12 -> CO2 (숫자 1일 생략)
    *  대문자+소문자면 한쌍으로 간주함  원소와 숫자 개수가 일치하지않으면 에러 발생 */
    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);


        String input = sc.next();
        String[] w = input.split("");
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> num = new ArrayList<>();

        for(int i=0; i<input.length(); i++) {

            char s = input.charAt(i);

            if(Character.isUpperCase(s)){
                //대문자
                words.add(Character.toString(s));
            }else if(Character.isLowerCase(s)){
                //소문자
                words.set(words.size()-1,words.get(words.size()-1)+s);
            }else if(Character.isDigit(s)){
                //숫자
                num.add(Character.toString(s));
            }

        }


        if(words.size() != num.size()){
            System.out.println("error");
        }else{
            for(int j=0; j<words.size(); j++){

                if(num.get(j).equals("1")){
                    System.out.print(words.get(j));
                }else{
                    System.out.print(words.get(j)+num.get(j));
                }

            }
        }


    }
}
