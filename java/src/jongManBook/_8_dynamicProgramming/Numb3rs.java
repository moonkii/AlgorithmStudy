package jongManBook._8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Numb3rs {


    public static double getProb(int[][] v, double[] prob, int prev,int next, int day,int p){

        if(day==1){

            if(v[prev][p] ==0 ){
                return 0;
            }else{
                return prob[prev];
            }
        }


        double countP =0;
        for(int i=0; i< v.length; i++){


            if(v[prev][i] != 0){
                countP += getProb(v,prob,prev,i,day-1,p);
            }
        }

        return prob[prev] * getProb(v,prob,prev,0,day-1,p);



    }


    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //마을 수 ( [2,50] )
        int d; //지난 일 수 ( [1,100] )
        int p; //교도서가 있는 마을 번호 ( [0,n) )



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                StringTokenizer st = new StringTokenizer(br.readLine());

                n = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());


                int[][] v = new int[n][n];
                double[] probability = new double[n];

                //경우의 수 행렬 입력 받기
                for(int y=0; y<n; y++){

                    st = new StringTokenizer(br.readLine());

                    int x =0;  //
                    int numberP=0; //각 마을에서 이동할 수 있는 총 마을 수
                    while (st.hasMoreTokens()){

                        int temp = Integer.parseInt(st.nextToken());
                        v[y][x] = temp;
                        x++;

                        if(temp == 1){
                            numberP += 1;
                        }
                    }

                    probability[y] = 1/numberP;
                }


                //답을 구해야하는 마을 번호 입력 받기
                st = new StringTokenizer(br.readLine());
                int resultCount = Integer.parseInt(st.nextToken());

                int[] resultNumber = new int[resultCount];

                st = new StringTokenizer(br.readLine());
                for(int r = 0; r<resultCount; r++){
                    resultNumber[r] = Integer.parseInt(st.nextToken());
                }


                //순서를 거꾸로 계산
                for(int day=1; day <= d; day++){

                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
