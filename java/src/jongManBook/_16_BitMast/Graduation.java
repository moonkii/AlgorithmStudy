package jongManBook._16_BitMast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*##############
 *     해결중
 * #############*/

public class Graduation  {

    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //전공 과목수 ( [1,12] )
        int k; //들어야할 과목수 ( [0,n] )
        int m; //학기 수 ( [1,10] )
        int l; //한 학기 최대로 들을 수 있는 과목 수 ( [1,10] )


        int[] semeter;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());

            for(int i=0; i<c; i++){

                StringTokenizer st = new StringTokenizer(br.readLine());

                    n = Integer.parseInt(st.nextToken());
                    k = Integer.parseInt(st.nextToken());
                    m = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());

                     semeter = new int[m];

                      for(int j=0; j<m; j++){
                         int temp =  Integer.parseInt(st.nextToken());
                         semeter[j]=0;
                      }





            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
