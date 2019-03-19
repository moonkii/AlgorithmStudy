package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Eureka {


    public static int getTn(int n){

        return n*(n+1)/2;
    }

    public static int check(int pre, int k){


//        if(int a = 0; a< )

        int n=1;

        while(pre+getTn(n)<=k){


        }




        int count=0;

        return count;
    }

    public static void main(String[] args){


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c; //테스트 케이스
        int k; //입력 수
        int[] num = {1,1,1};

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c; i++){

                StringTokenizer st = new StringTokenizer(br.readLine());

                while(st.hasMoreTokens()){
                    k=Integer.parseInt(st.nextToken());


                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
