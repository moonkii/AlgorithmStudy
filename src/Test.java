import java.math.BigInteger;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args){

        ArrayList<Integer> t = new ArrayList<>();


        int n=5;
        for(int a=0; a<n; a++){
            t.add(a);
        }

        int count = 0;
        while (t.size()!=0) {


            for (int a = 0; a < t.size(); a++) {
                System.out.print(t.get(a) + " ");
            }

            System.out.println();
            t.remove(count);
            if(count<5){
                count++;
            }




        }

    }
}

