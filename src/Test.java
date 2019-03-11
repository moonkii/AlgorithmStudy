import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Test {

    //i 번째 입력 신호 만드는 메서드
    public static double getSignal(double input){
        return input%10000+1;
    }

    //i 번째 입력 신호를 만들기 위한 A[i] 만드는 메서드
    public static double setAi(double pre){

        return (pre*214013+2531011)%Math.pow(2,32); // A[i] 번째 입력
    }


    //i 번째 입력 신호 만드는 메서드
    public static long getSignal(long input){
        return input%10000+1;
    }

    //i 번째 입력 신호를 만들기 위한 A[i] 만드는 메서드
    public static long setAi(long pre){

        return Double.valueOf((pre*214013+2531011)%Math.pow(2,32)).longValue(); // A[i] 번째 입력
    }



    public static void main(String[] args){



        for(int i=0; i<2; i++){
            System.out.println("case"+i);
            long preNumber = 1983;
            for(int j=0; j<5; j++) {


                //신호 길이만큼 루프

                long signal; //입력신호

                if (j == 0) {
                    //A[0] 입력과 시그널 구하기
                    signal = getSignal(preNumber);
                    System.out.println(signal);
                    preNumber = setAi(preNumber);



                } else {
                    //A[1]부터 입력과 시그널 구하기
                    signal = getSignal(preNumber);
                    System.out.println(signal);
                    preNumber = setAi(preNumber);

                }

            }









        }
    }
}
