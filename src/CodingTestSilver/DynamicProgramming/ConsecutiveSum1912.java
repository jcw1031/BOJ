package CodingTestSilver.DynamicProgramming;

import java.io.*;
import java.util.*;

public class ConsecutiveSum1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] dp = new int[n];

        dp[0] = Integer.parseInt(st.nextToken());

        for(int i=1;i<n;i++){
            int tmp = Integer.parseInt(st.nextToken());

            if(dp[i-1]+tmp < tmp){
                dp[i] = tmp;
            }
            else dp[i] = dp[i-1]+tmp;
        }
        Arrays.sort(dp);

        System.out.println(dp[n-1]);
    }
}