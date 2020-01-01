package jongManBook._8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*##############
 *     해결중
 * #############*/

public class WildCard {

    public static String getPair(String w  ,int order){

        if(order >= w.length()){
            return "";
        }else{

            if(w.charAt(order) != '*' && w.charAt(order) != '?'){

                return ""+w.charAt(order);
            }else{

                String temp = w.charAt(order)+getPair(w,order+1);

                return temp;

            }

        }

    }

    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int c = Integer.parseInt(br.readLine());

            for(int i=0; i<c ; i ++){


                //입력받은 와일드카드 파일명 분할 ( * , ? + 문자열 기준으로 )
                String wild = br.readLine();
                ArrayList<String> wArr = new ArrayList<>();
                String temp="";
                for(int j=0; j< wild.length(); j++){

                    char word = wild.charAt(j);

                    temp+=word;
                    if ( word != '*' && word !='?'){
                        temp="";
                        wArr.add(temp);
                    }

                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
