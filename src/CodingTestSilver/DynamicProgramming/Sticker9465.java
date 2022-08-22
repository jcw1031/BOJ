package CodingTestSilver.DynamicProgramming;

import java.io.*;
import java.util.*;

public class Sticker9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n];
            int[][] arr = new int[2][n];
            for(int i=0;i<2;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            if(n>=2){
                dp[0][1] = dp[1][0] + arr[0][1];
                dp[1][1] = dp[0][0] + arr[1][1];
            }

            for(int i=2;i<n;i++){
                int tmp1;
                int tmp2;
                for(int j=0;j<2;j++){
                    tmp1 = dp[(j+1)%2][i-1] + arr[j][i];
                    tmp2 = dp[(j+1)%2][i-2] + arr[j][i];

                    dp[j][i] = Math.max(tmp1, tmp2);
                }
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }
    }
}