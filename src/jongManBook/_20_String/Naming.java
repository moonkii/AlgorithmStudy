package jongManBook._20_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Naming {


    public static void getPi(char[] word, int[] pi){

        for(int i=0; i<word.length; i++){

            int max=0;
            for(int j=0; j< word.length -i ; j++){

                if(word[i+j] != word[j]){
                    break;
                }else{
                    max +=1 ;
                }

                if(j==word.length-i-1){

                    pi[i] = max;
                }

            }


        }
    }

    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String father = br.readLine();
            String mother = br.readLine();

            String fullName = father+mother;
            char[] word = new char[fullName.length()];
            int[] pi = new int[fullName.length()];

            for(int i=0; i<fullName.length(); i++){
                word[i] = fullName.charAt(i);

            }

            getPi(word,pi);

            for(int result = pi.length-1 ; result >=0 ; result--){
                if(pi[result] != 0){
                    System.out.print(pi[result]+" ");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
