
//시간초과 미해결

package codingTestGold;

import java.io.*;
import java.util.*;

public class SquareNoNoNumber1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int count= (int) (max-min+1);
        boolean[] arr = new boolean[count];
        count = 0;


        for(long i = 2; i*i<=max; i++){
            if(Math.pow(i, 2)-min >= 0 && arr[(int)((Math.pow(i, 2))-min)]){
                continue;
            }
            for(int j=1;j*Math.pow(i, 2)<=max;j++){
                if(Math.pow(i, 2)*j >= min){
                    arr[(int) (Math.pow(i, 2)*j-min)] = true;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            if(!arr[i]) count++;
        }
        System.out.println(count);
    }
}