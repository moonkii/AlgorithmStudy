package codingTest;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S5 {

    /* 테이블 주어질 때 두 테이블을 조인 한 결과 도출하는 문제 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t1 = sc.nextInt();

        String[] header1;
        Hashtable<Integer,String[]> table1;




        for(int i=0; i<t1 ; i++){

            if(i==0){
                sc = new Scanner(System.in);
                String h1 = sc.nextLine();
                header1 = h1.split(" ");


            }else{

                sc = new Scanner(System.in);
                String d1 = sc.nextLine();
                String[] data = d1.split(" ");




            }
        }


        int t2 = sc.nextInt();
        String[] header2;
        for(int j=0; j<t1 ; j++){

            if(j==0){
                sc = new Scanner(System.in);
                String h2 = sc.nextLine();
                header2 = h2.split(" ");

            }else{



            }
        }




    }


}
