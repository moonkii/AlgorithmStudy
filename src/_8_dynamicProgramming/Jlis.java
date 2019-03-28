package _8_dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*##############
 *     해결중
 * #############*/

public class Jlis {



    public static int getMax(int[] a, int[] b){

        int maxA=0;
        for(int i=0; i<a.length; i++){
            if(maxA < a[i]){
                maxA=a[i];
            }
        }

        int maxB=0;
        for(int j=0; j<b.length; j++){
            if(maxB < b[j]){
                maxB = b[j];
            }
        }

        return (maxA >= maxB) ? maxA : maxB;

    }

    public static void main(String[] args){

        int c; //테스트 케이스
        int n; //배열 A 의 길이
        int m; //배열 B 의 길이

        long[] nArray; //A 배열
        long[] mArray; //B 배열

        int[] checkA; // A 배열에서의 LIS
        int[] checkB; // B 배열에서의 LIS

        int[] checkAB;//A 원소별 합친 LIS (A -> B 순 )
        int[] checkBA;//B 원소별 합친 LIS (B -> A 순 )


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = Integer.parseInt(br.readLine());



            for(int i=0; i<c ; i ++){


                StringTokenizer st = new StringTokenizer(br.readLine());

                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());

                nArray = new long[n];
                mArray = new long[m];

                checkA = new int[n];
                checkB = new int[m];

                checkAB = new int[n];
                checkBA = new int[m];


                //A 배열 입력받기
                st = new StringTokenizer(br.readLine());

                for(int a=0; a<n; a++){
                    nArray[a]=Integer.parseInt(st.nextToken());

                    checkA[a]+=1;

                    int maxSumA=0;

                    for(int preA= a-1 ; preA >=0; preA--){

                        if( nArray[preA] < nArray[a]){
                            if(maxSumA < checkA[preA]){
                                maxSumA = checkA[preA];
                            }
                        }

                    }

                    checkA[a] += maxSumA;
                }


                //B 배열 입력받기
                st = new StringTokenizer(br.readLine());

                for(int b=0; b<m; b++){
                    mArray[b]=Integer.parseInt(st.nextToken());

                    checkB[b] +=1;

                    int maxSumB=0;

                    for(int preB = b-1; preB >=0; preB--){

                        if( mArray[preB] < mArray[b]){
                            if(maxSumB < checkB[preB]){
                                maxSumB = checkB[preB];
                            }
                        }
                    }

                    checkB[b] += maxSumB;

                }


                //A->B 로 체크

                for(int ab=0; ab<n; ab++){

                    int maxSumAB=0;
                    for(int bp=0; bp<m; bp++){

                        if(mArray[bp] < nArray[ab]){
                            if(maxSumAB < checkB[bp] ){
                                maxSumAB = checkB[bp];
                            }
                        }
                    }

                    checkAB[ab] = checkA[ab]+maxSumAB;
                }



                //B -> A 로 체크
                for(int ba=0; ba<m; ba++){

                    int maxSumBA=0;
                    for(int ap=0; ap<n; ap++){

                        if(nArray[ap] < mArray[ba]){
                            if(maxSumBA < checkA[ap] ){
                                maxSumBA = checkA[ap];
                            }
                        }
                    }

                    checkBA[ba] = checkB[ba]+maxSumBA;
                }



                System.out.println(getMax(checkAB, checkBA));



            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
