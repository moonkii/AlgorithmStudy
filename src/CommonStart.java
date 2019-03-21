import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonStart {

    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
