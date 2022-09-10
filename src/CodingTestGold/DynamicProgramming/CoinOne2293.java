/** Dynamic Programming*/

package CodingTestGold.DynamicProgramming;

import java.io.*;
import java.util.*;

public class CoinOne2293 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] input = new int[n];
        int[] dp = new int[10001];

        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=input[i];j<=k;j++){
                dp[j] += dp[j-input[i]];
            }
        }
        System.out.println(dp[k]);
    }
}