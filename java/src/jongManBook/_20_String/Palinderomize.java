package jongManBook._20_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palinderomize {

    public static void main(String[] args){

        int c; //테스트 케이스

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());

            for(int i=0; i<c ; i ++){

                String input = br.readLine();
                char[] word = input.toCharArray();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
