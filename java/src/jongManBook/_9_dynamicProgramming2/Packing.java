package jongManBook._9_dynamicProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Packing {


    public static int getMaxPair(int order , int remainVolume , int[] volume, int[] value ){

        if(order == volume.length){
            return 0;
        }


        int max=0;


            if(volume[order] <= remainVolume){

                int in =  value[order] + getMaxPair(order+1, remainVolume - volume[order] , volume, value);
                int out = getMaxPair(order+1, remainVolume, volume,value);

                if(in > out){
                    max = in;
                }

            }else{
                max = getMaxPair(order+1, remainVolume, volume,value);

            }




        return max;


    }


    public static void getItemName(int order , int remainVolume , int[] volume, int[] value , boolean[] picked){

        if(order == value.length){
            return;
        }

        if(getMaxPair(order,remainVolume,volume,value) == getMaxPair(order+1, remainVolume,volume,value)){
            picked[order] = false;
            getItemName(order+1 , remainVolume, volume,value,picked);
        }else{
            picked[order] = true;
            getItemName(order+1,remainVolume-volume[order],volume,value,picked);
        }
    }


    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //가져가고 싶은 물건 수 ( [1,100] )
        int w; //한계 용량 ( [1,1000] )


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());


            for(int i=0; i<c ; i ++){

                StringTokenizer st = new StringTokenizer(br.readLine());

                n = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());

                ArrayList<String> items = new ArrayList<>();
                int[] volume = new int[n];
                int[] value = new int[n];
                boolean[] picked = new boolean[n];


                for(int j=0; j<n ; j++){
                    st = new StringTokenizer(br.readLine());

                    items.add(st.nextToken());
                    volume[j] = Integer.parseInt(st.nextToken());
                    value[j] = Integer.parseInt(st.nextToken());

                }


                int result = getMaxPair(0,w,volume,value);
                getItemName(0,w,volume,value,picked);

                int count = 0;
                ArrayList<String> pickedItem = new ArrayList<>();

                for(int r =0 ; r<n ; r++){
                    if(picked[r]){
                        count += 1;
                        pickedItem.add(items.get(r));
                    }
                }

                System.out.println(result+" "+count);
                for(String item : pickedItem){
                    System.out.println(item);
                }








            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
