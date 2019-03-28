import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {


    public static int getTiling(int[] memo ,int n){


        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else if (n==2){
            return 2;
        }

        if(memo[n] != 0){
            return memo[n];
        }else{

            memo[n] = getTiling(memo,n-1) + getTiling(memo,n-2);
            return memo[n];
        }




    }


    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //사각형 높이
        int[] memo;
        int div = 1000000007;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                memo = new int[101];

                n = Integer.parseInt(br.readLine());

                long temp = getTiling(memo,n);
                System.out.println(Math.floorMod(temp,div));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
