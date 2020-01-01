
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main  {

    public static void main(String[] args){

        int c; //테스트 케이스 ( [0,300] )
        int n; //도시락 수 ( [1,10000] )

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());

            for(int i=0; i<c ; i ++){

                n = Integer.parseInt(br.readLine());
                TimePacks[] TimePackss = new TimePacks[n];


                //도시락 데우는 시간 입력
                StringTokenizer ht = new StringTokenizer(br.readLine());

                //도시락 먹는 시간 입력
                StringTokenizer et = new StringTokenizer(br.readLine());

                for(int j=0; j<n ; j++){
                    TimePackss[j] = new TimePacks(Integer.parseInt(ht.nextToken()), Integer.parseInt(et.nextToken()));
                }

                Arrays.sort(TimePackss);

                int hitTimeSum=0;
                int resultTime = 0;
                for(int r =0; r<TimePackss.length; r++){
                    hitTimeSum += TimePackss[r].getHitTime();
                    int temp = hitTimeSum + TimePackss[r].getEatTime();
                    if(resultTime < temp){
                        resultTime = temp;
                    }
                }

                System.out.println(resultTime);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class TimePacks implements Comparable<TimePacks>{
    private int hitTime;
    private int eatTime;


    public TimePacks(int hitTime, int eatTime) {
        this.hitTime = hitTime;
        this.eatTime = eatTime;
    }

    public int getHitTime() {
        return hitTime;
    }

    public int getEatTime() {
        return eatTime;
    }

    @Override
    public int compareTo(TimePacks o) {
        if( eatTime == o.eatTime){
            return 0;
        }

        //내림차순 정렬
        return o.eatTime - eatTime;
    }
}