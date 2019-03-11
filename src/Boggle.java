import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boggle {

    public void main (String args[]) {

        //단어 배
        String[] words = new String[25];

        int centerIndex;    //선택된 단어의 인덱스값
        int c;              // 테스트 케이스

        //입력 받는 버퍼 리더 ( .read() / .readLine() )
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer stringTokenizer = null;


        try {
            c = Integer.parseInt(bufferedReader.readLine());
            for(int i=0; i<c ; i++ ){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                words[i] = stringTokenizer.nextToken();



            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
