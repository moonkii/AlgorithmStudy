package _7_divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*##############
 *      완료
 * #############*/

public class Fence {


    //기준 판자에서 부터 왼쪽으로 너비 확장
    public static int getLeft(int[] h, int index){
        if(index==0){

            return 0;

        }else{
            int sum=0;
            for(int i=index-1; i>=0; i--){
                if(h[index] <= h[i] ){
                    sum+=1;
                }else{
                    break;
                }
            }

            return sum;
        }


    }

    //기준 판자에서 부터 오른쪽으로 너비 확장
    public static int getRight(int[] h, int index){

        if(index == h.length){
            return 0;
        }else{
            int sum=0;
            for(int i=index+1; i<h.length; i++ ){
                if(h[index] <= h[i]){
                    sum +=1;
                }else{
                    break;
                }
            }

            return sum;
        }

    }


    //기준 판자에서 생성할 수 있는 직사각형 최대 넓이
    public static int getMaxWidth(int[] h , int index){


        int horizontal = getLeft(h,index) + getRight(h, index) + 1;

        int vertical = h[index];


        return horizontal * vertical;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int c = Integer.parseInt(br.readLine());//테스트 케이스

            for(int i=0; i<c ; i++){


                int n = Integer.parseInt(br.readLine()); // 판자수 ( [1,20000] )
                int[] h = new int[n];                    // 판자 높이( [0,10000] )

                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j=0; j<n ; j++){
                    h[j] = Integer.parseInt(st.nextToken());
                }

                int tempMax =0;

                for(int f=0; f<n; f++){

                    int w = getMaxWidth(h,f);
                    if(tempMax < w ){
                        tempMax = w;
                    }

                }


                System.out.println(tempMax);
            }




        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
