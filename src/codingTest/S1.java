package codingTest;

import java.util.ArrayList;
import java.util.Scanner;

public class S1 {

    //넓이가 주어진 직사각형의 (가로-세로) 절대값 중 최소값 구하기 문제

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long min =0;

        ArrayList<Long> arr= new ArrayList<>();

        //약수 구하기
        for(long i=1; i<=n ; i++){

            if(n%i ==0){
                arr.add(i);
            }
        }

        if(arr.size() % 2 ==0){

            for(int s=0; s<arr.size()/2; s++){

                if(s==0){
                    min = Math.abs(arr.get((arr.size()-1)-s)-arr.get(s));
                }else{
                    long temp = Math.abs(arr.get((arr.size()-1)-s)-arr.get(s));
                    if(temp < min){
                        min = temp;
                    }
                }
            }

        }else{

            min =0;

        }


        System.out.println(min);





    }
}
