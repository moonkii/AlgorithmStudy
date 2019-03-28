package _7_divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*##############
 *      완료
 * #############*/

public class FanMeeting {

    //멤버 수만큼 팬 배열을 한칸씩 이동하면서 체크 ( 남자는 1 , 여자는 0 이라서 남자끼리 만나는 경우는 곱이 1 이고 그 나머지는 모두 0 )
    public static int getResult(int[] member, int[] fan, int f, int order){

        if(order==0){

            return member[order]*fan[f];

        }else{

            int temp = 0;

            temp += getResult(member,fan,f-1,order-1);

            return member[order]*fan[f] + temp;

        }

    }

    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int c = Integer.parseInt(br.readLine());

            for (int i = 0; i < c; i++) {

                //멤버 추가
                String m = br.readLine();
                int[] member = new int[m.length()];
                for (int j = 0; j < m.length(); j++) {

                    if (m.charAt(j) == 'F') {
                        //여자인 경우 0 값
                        member[j] = 0;
                    } else {
                        //남자인 경우 1 값
                        member[j] = 1;
                    }
                }


                String f = br.readLine();
                int[] fan = new int[f.length()];

                for (int k = 0; k < f.length(); k++) {
                    if (f.charAt(k) == 'F') {
                        //여자인 경우 0
                        fan[k] = 0;
                    } else {
                        //남자인 경우 1
                        fan[k] = 1;

                    }
                }


                if(member.length != 0 && fan.length !=0){
                    int count = 0;

                    for (int h = member.length - 1; h < fan.length; h++) {

                        int check = getResult(member, fan, h, member.length - 1);
                        if (check == 0) {
                            count += 1;
                        }
                    }

                    System.out.println(count);
                }


            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
