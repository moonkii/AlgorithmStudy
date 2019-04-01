package _8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*##############
 *     해결중
 * #############*/

public class TriangleCnt {


    public static int getMax(int a, int b){
        if(a>=b){

            return a;
        }else{
            return b;
        }
    }


    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //삼각형 높이
        int[][] cache;
        int[][] triangle;



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                n = Integer.parseInt(br.readLine());
                triangle = new int[n][n];
                cache = new int[n][n];

                for(int j=0; j<n; j++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int index =0;

                    while (st.hasMoreTokens()){
                        triangle[j][index]=Integer.parseInt(st.nextToken());
                        index++;

                    }

                }


                int r = 1;
                int check=0;
                for(int y =0; y<n; y++){

                    for(int x=0; x<r; x++){

                        if(y==0){
                            cache[y][x]=triangle[y][x];
                        }else if(x==0){
                            cache[y][x]=triangle[y][x]+cache[y-1][x];
                        }else{
                            cache[y][x] = triangle[y][x] + getMax(cache[y-1][x-1],cache[y-1][x-1]);

                        }

                    }

                    r++;
                }

                int max=0;
                int maxCount=0;

                for(int f =0; f<n; f++){
                    if(cache[n-1][f] > max) {
                        max = cache[n-1][f];
                        maxCount=1;
                    }else if(cache[n-1][f] == max){
                        maxCount+=1;
                    }
                }

                System.out.println(maxCount+check);





            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
