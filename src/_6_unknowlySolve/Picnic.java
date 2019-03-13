package _6_unknowlySolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Picnic {

    /* 풀이 기록
     * 1. 결과값 에러
     *  1-1) 원인 : 입력이 오름차순이 아니고, 입력 받은대로 좌표를 넣어서 친구인지 true/false 로 할 경우 모든 경우의 수를 체크하지 못함 (중복문제)
     *  1-2) 해결책 : 2차원 배열에서 y,x 의 위치좌표값이 같은 대각선을 기준으로 한쪽 면에서 체크하기 때문에 입력받은 값의 좌표를 y,x / x,y 로 바꿔가며 모두 입력
     *              ( 가장 작은 수 0 을 기준으로 경우의 수를 체크함 )
     *
     * 2. 기저사례
     *  2-1) 원인 : 모든 경우의 수를 만족한 경우 기저 사례를 추가해야함
     *  2-2) 해결책 : 시작 기준이 되는 숫자값을 -1 로 주고 값의 변화가 없으면 모든 경우의 수를 체크한 것으로 간주하여 return 1 해줌
     *
     * */
    public static int getCount(boolean[][] friendArr ,boolean[] studentNum){

        int firstNum=-1;//짝을 찾는 학생 번호

        //짝을 찾는 번호가 가장 작은 학생 찾기
        for(int num=0; num<studentNum.length; num++){
            if(!studentNum[num]){
                firstNum = num;
                break;
            }
        }

        //모든 학생이 짝을 다 찾은 경우 return 1 로 count 증가
        if(firstNum==-1){
            return 1;
        }


        int count=0; //경우의 수 (제일 처음 0을 기준으로해서 count 는 계속 누적됨)

        //짝을 찾는 학생과 매칭될 짝
        for(int j=firstNum+1; j<studentNum.length; j++){
            if(!studentNum[j] && friendArr[firstNum][j]){

                //짝 찾은 경우 해당 번호 학생들 경우의 수 지워주기 ( F -> T )
                studentNum[j]=true;
                studentNum[firstNum]=true;

                //재귀를 통해 계속 탐색
                count += getCount(friendArr,studentNum);

                //경우의 수 되돌리기
                studentNum[firstNum]=false;
                studentNum[j] = false;

            }

        }


        return count;
    }


    public static void main(String[] args) {

        int c; //테스트 케이스
        int n; //학생 수
        int m; //친구 쌍 수

        int[] result;   //출력 결과

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer stringTokenizer = null;

        try {
            c = Integer.parseInt(br.readLine());
            result = new int[c];

            for(int i=0; i<c; i++){


                stringTokenizer = new StringTokenizer(br.readLine());
                n = Integer.parseInt(stringTokenizer.nextToken());
                m = Integer.parseInt(stringTokenizer.nextToken());

                boolean[][] friends = new boolean[n][n];      //학생들 간 친구 쌍 모든 경우의 수
                boolean[] number = new boolean[n];            //학생 번호

                //친구 쌍 입력 받기
                stringTokenizer = new StringTokenizer(br.readLine());
                while(stringTokenizer.hasMoreTokens()){

                    int x = Integer.parseInt(stringTokenizer.nextToken());
                    int y = Integer.parseInt(stringTokenizer.nextToken());

                    //친구 쌍 입력이 오름차순이 아닌 경우도 있기 때문에 x,y / y,x 순으로 등록
                    friends[y][x] = true;
                    friends[x][y] = true;


                }


                result[i] = getCount(friends,number);

            }


            //결과 모두 출력
            for(int r : result){
                System.out.println(r);
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