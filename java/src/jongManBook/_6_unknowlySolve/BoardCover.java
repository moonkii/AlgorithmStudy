package jongManBook._6_unknowlySolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*##############
*      완료
* #############*/

    /* 풀이 기록
     * 1. 예외처리 에러
     *  1-1) 원인 : 블록 시작 기준에서 위치값이 음수가 되는 경우 예외처리를 안함 ( 0은 포함해야함 )
     *  1-2) 해결책 : 들어갈 블록을 선정할 때 블럭이 게임판 범위를 벗아나는지 확인하는 조건문에서 위치값 음수되는 경우 예외 처리 추가
     *
     * 2. 모든 블럭이 검은색인 경우 (입력값이 모두 # 인 경우)에 경우의 수가 1 나오는 에러 ( 경우의 수는 0이 되야함)
     *  2-1) 원인 : 경우의 수를 구하는 메서드에서 게임칸이 모두 false 이면 1의 값을 return 하기 때문에 블록이 모두 검은색인 경우 게임판이 모두 false 가 되어 값이 1이됨
     *  2-2) 해결책 : 게임판을 입력 받는 곳에서 흰색칸 ' 입력이 있는지 체크해서 입력이 모두 # 인 경우 0 값을 return 함
     *
     * */
    public class BoardCover{

        public static int countCover(boolean[][] board){

            // L자 모양 블럭의 첫번 째 블럭을 기준으로 덮게되는 좌표 ( 총 4가지 경우 존재 ㄱ,┌,ㄴ , ┘)
            int[] by = {0,1,1,1,0,1,1,1};
            int[] bx = {1,0,0,1,1,1,-1,0};

            //시작 칸 좌표
            int y=-1;
            int x=-1;


            //시작 칸 구하기
            for(int h=0; h<board.length; h++){
                for(int w=0; w<board[0].length; w++){

                    if(board[h][w]){
                        y=h;
                        x=w;
                        break;
                    }

                }

                if(y!=-1){
                    break;
                }

            }


            //기저사례
            if(y==-1){
                //칸을 모두 채웠을 때 return 1 해서 count를 늘려줌
                return 1;
            }


            //시작칸으로부터 들어갈 블럭 타입 체크
            int nowType=0;

            //게임판 덮는 경우의 수
            int count=0;

            while(nowType<8){

                //블럭이 게임판 범위 벗어나는지 확인
                if(y+by[nowType]<board.length
                        && x+bx[nowType] < board[0].length
                        && y+by[nowType+1] < board.length
                        && x+bx[nowType+1] < board[0].length
                        && x+bx[nowType] >0
                        && x+bx[nowType+1] >0){



                    //블럭이 들어갈 수 있는지 확인
                    if(board[y+by[nowType]][x+bx[nowType]] && board[y+by[nowType+1]][x+bx[nowType+1]]){

                        board[y][x]=false;
                        board[y+by[nowType]][x+bx[nowType]]=false;
                        board[y+by[nowType+1]][x+bx[nowType+1]]=false;

                        count += countCover(board);

                        board[y][x]=true;
                        board[y+by[nowType]][x+bx[nowType]]=true;
                        board[y+by[nowType+1]][x+bx[nowType+1]]=true;

                    }

                }

                //블록을 다음 타입으로 변경
                nowType+=2;

            }


            return count;
        }


        public static void main(String[] args) {

            int c; //테스트 케이스 ( (30] )
            int h; //높이 ( [1,20] )
            int w; //너비 ( [1,20] )
            int[] result;


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = null;

            try {
                c = Integer.parseInt(br.readLine());
                result = new int[c];

                for(int i=0; i<c; i++){

                    st = new StringTokenizer(br.readLine());
                    h = Integer.parseInt(st.nextToken());
                    w = Integer.parseInt(st.nextToken());

                    boolean[][] board = new boolean[h][w];
                    boolean allBlack=true;

                    for(int j=0; j<h; j++){
                        String line = br.readLine();

                        for(int b = 0; b<line.length(); b++ ){
                            char block = line.charAt(b);

                            if(block == '#'){
                                board[j][b] = false;
                            }else if(block == '.'){
                                board[j][b] = true;
                                allBlack=false;
                            }
                        }

                    }


                    //입력값이 모두 # 인지 확인
                    if(allBlack){
                        result[i]=0;
                    }else{
                        result[i]= countCover(board);
                    }

                }

                //결과값 도출
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


