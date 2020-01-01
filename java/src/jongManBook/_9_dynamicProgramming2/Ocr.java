package jongManBook._9_dynamicProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ocr {

    public static void main(String[] args){

        int m; //단어 수
        int q; //문장 수

        HashMap<String,Double> wordFist = new HashMap<>();
        ArrayList<String> words = new ArrayList<>(); //단어

        String[] input;
        double[][] nextTo;
        double[][] changeTo;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            StringTokenizer st= new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            nextTo = new double[m][m];
            changeTo = new double[m][m];

            //단어 입력
            st= new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                words.add(st.nextToken());
            }

            //첫단어 출현 확률
            st= new StringTokenizer(br.readLine());
            for(int f=0 ; f<m ; f++){
                wordFist.put(words.get(f),Double.valueOf(st.nextToken()));
            }


            // i 의 다음 단어가 j 일 확률
            for(int i=0; i<m ;i++){
                for(int j=0; j<m; j++){
                    st= new StringTokenizer(br.readLine());

                    nextTo[i][j] = Double.valueOf(st.nextToken());
                }
            }


            // i를 j 로 분류할 확률
            for(int i=0; i<m; i++){
                for(int j=0; j<m; j++){
                    st = new StringTokenizer(br.readLine());

                    changeTo[i][j] = Double.valueOf(st.nextToken());
                }
            }


            //문장 처리
            for(int r=0; r<q ; r++){
                st = new StringTokenizer(br.readLine());
                int countWords = Integer.parseInt(st.nextToken());
                input = new String[countWords];

                for(int n=0; n<countWords; n++){
                    input[n] = st.nextToken();
                }
            }








        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
