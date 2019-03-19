package codingTest;

import java.util.Scanner;

public class S3 {

    /* 높이가 주어진 빌딩 사이에서 밧줄 연결 문제 (가장 긴 밧줄 길이 구하기 )
    *  빌딩은 주어진 대로 숫자 1부터 번호 부여받음
    *  시작빌딩에서 밧줄을 이어나가다가 시작빌딩의 높이와 같거나 큰 빌딩을 만나면 멈춤 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //빌딩 수

        int[] h = new int[n];   //빌딩 높이
        int[] r = new int[n];   //왼쪽부터 밧줄 길이
        int[] l = new int[n];   //오른쪽부터 밧줄 길이
        int[] result= new int[2];           //가장 긴 밧줄길이


        //빌딩 높이 입력
        for(int i=0; i<n ; i++){

            h[i] = sc.nextInt();

        }


        //왼쪽부터 밧줄 길이 구하기
        for(int f=0; f< n; f++){

            int max=0; //현재 빌딩 위치에서 밧줄 최대 길이
            for(int next =f+1; next< n; next++){

                max += 1;

                if(h[f]<=h[next]){
                    break;
                }

                if(max == n-1 && h[f]>h[next]){
                    max=0;
                }
            }

            r[f] = max;
        }


        //오른쪽부터 밧줄 길이 구하기
        for(int f = n-1; f > 0; f--){

            int max =0;
            for(int next = f-1 ; next>=0; next--){

                max +=1;

                if(h[f] <= h[next]){
                    break;
                }

                if(max == n-1 && h[f]>h[next]){
                    max=0;
                }
            }

            l[f] = max;
        }

        for(int j=0; j<n ; j++){
            if(result[0]<r[j]){
                result[0] = r[j];
            }

            if(result[1]<l[j]){
                result[1] = l[j];
            }

        }


        if(result[0]>result[1]){
            System.out.println(result[0]);
        }else{
            System.out.println(result[1]);
        }



    }
}
