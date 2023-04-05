package silver.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //n <= 35 조건에서 int형의 범위를 넘어가기 때문에 long 형으로 생성
        Long[] dp = new Long[n + 1];

        //초기화
        dp[0] = 1L;

        //DP
        for (int i = 1; i <= n; i++) {
            long sum = 0L;
            for (int j = 0; j < i; j++) {
                sum += dp[j] * dp[i - (j + 1)];
            }
            dp[i] = sum;
        }

        System.out.println(dp[n]);
    }
}