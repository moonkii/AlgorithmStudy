package jongManBook._6_unknowlySolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 풀이법
 * 1. 2차원 배열로 글자들을 저장하고 찾는 단어의 첫 번째 단어를 2차원 배열에서 찾는다.
 * 2. 첫 번째 단어를 찾으면 두 번째 글자부터 상하좌우 대각선을 돌면서 재귀함수로 찾는다.
 * 3. 재귀함수에서는 단어에서 글자의 순서(order) 와 2차원 배열에서의 위치 좌표값을 받는다.
 * 4. 상하좌우 대각선 8 방향으로 돌면서 다음 찾아야할 글자를 찾고 찾으면 true 를 못찾으면 false 를 빈환한다.
 * 5. 메모이제이션 배열을 만든다음 한번 지나간 경우의수의 경로는 다시 재탐색하지 않도록한다.
 *
 * */


public class Boggle {

    public static boolean findWord(char[][] board, int[] y, int[] x, char[] word, int order ,int nowY, int nowX, boolean[][] cache){

        //기저사례
        if(order+1==word.length){
            return true;
        }

        boolean r=false;

        //상하좌우, 대각선 단어 체크
        for( int j=0; j< 8; j++){

            int tempY = nowY + y[j];
            int tempX = nowX + x[j];

            //검사할 좌표가 배열 범위를 벗어나는지 체크
            if(tempY >= 0 && tempY < 5 && tempX >=0 && tempX < 5 ){

                if(word[order+1] == board[tempY][tempX] && !cache[tempY][tempX]){
                    r = findWord(board,y,x,word,order+1,tempY,tempX,cache);

                    cache[tempY][tempX] = true;
                    if(r){
                        return r;
                    }
                }



            }



        }

        return r;

    }


    public static void main(String[] args){

        int c; //테스트 케이스

        //글자의 위치좌표로 부터 상하좌우 대각선의 y,x 상대좌표
        int[] y = { -1, -1, -1, 0, 0, 1, 1, 1};
        int[] x = { -1,  0,  1,-1, 1,-1, 0, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                char[][] board = new char[5][5]; //입력받은 글자 저장하는 배열

                //문자 입력 받기
                for(int j=0; j<5; j++){
                    String line = br.readLine();

                    for(int w=0; w<line.length(); w++){
                        board[j][w] = line.charAt(w);
                    }

                }

                int wordsCount = Integer.parseInt(br.readLine()); //찾을 단어수
                boolean[] result = new boolean[wordsCount];       //단어 별 결과 저장

                String[] inputs = new String[wordsCount];

                //단어 찾기
                for(int f = 0; f<wordsCount ; f++){

                    //찾을 단어의 알파벳을 배열에 저장
                    inputs[f] = br.readLine();
                    char[] word = inputs[f].toCharArray();
                    boolean[][] cache = new boolean[5][5];


                    //단어의 첫 글자 찾기
                    for(int a =0; a<5; a++){
                        for(int b=0; b<5; b++){
                            if(board[a][b] == word[0]){
                                //두번 째 글자부터 재귀로 탐색
                                result[f] = findWord(board,y,x,word,0,a,b,cache);
                            }

                            if(result[f]){
                                break;
                            }
                        }

                        if(result[f]){
                            break;
                        }
                    }




                }

                //결과 출력
                for(int k=0; k<wordsCount; k++){
                    if(result[k]){
                        System.out.println(inputs[k]+" YES");
                    }else{
                        System.out.println(inputs[k]+" NO");
                    }
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}




