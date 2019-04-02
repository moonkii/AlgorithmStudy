import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {

    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //사각형 높이
        int[] memo;
        int mod = 1000000007;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                memo = new int[101];

                n = Integer.parseInt(br.readLine());

                for(int j=1; j<=n ; j++){

                    if(j==1){
                        memo[j] = 1;
                    }else if(j==2){
                        memo[j]= 2;
                    }else{

                        memo[j] = (memo[j-1] + memo[j-2]) % mod;
                    }
                }

                System.out.println(memo[n]);



            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
