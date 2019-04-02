import java.math.BigInteger;

public class Test {

    public static void main(String[] args){

        int n= 92;
        long[] tiling = new long[93];

        for(int j=1; j<=n ; j++){

            if(j==1){
                tiling[j] = 1;
            }else if(j==2){
                tiling[j] = 2;
            }else{
                tiling[j] = tiling[j-1] + tiling[j-2];

            }

            System.out.println(j+"번째 "+tiling[j]);
        }


        long result = tiling[92] - tiling[45] - tiling[46];




        long mod = 1000000007;

        System.out.println( (long)(result%mod) );

//        System.out.println("92 번째 "+(tiling[92]%mod));


        }
    }

