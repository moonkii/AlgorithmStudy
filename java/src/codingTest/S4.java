package codingTest;

import java.util.Scanner;

public class S4 {

    /* 나잡아봐라 (브라우니가 코니 따라 잡는) 문제 코니는 매번 이전 이동거리 +1 만큼 가속력을 얻음
    *  브라우니는 현재위치(b) 일 때 b-1 , b+1, 2*b 만큼 이동 가능
    *  둘의 위치가 일치하면 잡힘
    *  둘의 위치가 일치할 때 최소의 턴 수 구하기*/
    public static int getPosition(int method, int prev){

        if(method==0){
            return prev-1;
        }else if (method==1){
            return  prev+1;

        }else if(method==2){
            return  prev*2;
        }

        return 0;

    }

    public static int bMove(int turn, int now, int prev, int goal){


        if(prev == goal){
            return goal;
        }

        int temp =prev;
        for(int i=0; i<now; i++){


            for(int j=0; j<3 ; j++){

                temp += bMove(turn,i,prev,goal);

            }

        }

        return temp;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c;      //코니 위치
        int speed=1;//코니 가속도
        int b;      //브라우니 위치
        int turn=0; //순서
        boolean isGame=true;

        boolean[] bm = new boolean[3];



        c = sc.nextInt();
        b = sc.nextInt();


        while(isGame || c<200000){

            turn += 1;
            c = c + speed;
            speed++;



            for(int i=0; i<turn; i++){

                int temp = b;
                for(int j=0; j<3; j++){

                    temp = getPosition(j,b);

                    if(c==temp){
                        isGame=false;
                    }
                }

            }


        }

    }


}
