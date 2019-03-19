package _18_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Josephus {

    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //사람수
        int k; //순서 간격

        ArrayList<Integer> people = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = br.read();

            for(int i=0; i<c; i++){

                StringTokenizer st = new StringTokenizer(br.readLine());

                n = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());

                for(int j=0; j<n ; j++){

                    people.add(j+1); // 사람마다 번호 부여 ( 1 부터시작)

                }

                boolean isFinish = false;
                int order=0;
                while(!isFinish){


                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
