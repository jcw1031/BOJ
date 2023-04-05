package silver.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2705번
 */
public class BOJ2705 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[1000 + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (dp[n] != 0) {
                System.out.println(dp[n]);
                continue;
            }

            for (int j = 3; j <= n; j++) {
                if (dp[j] != 0) {
                    continue;
                }
                dp[j] += 1;
                if (j % 2 == 0) {
                    dp[j] += dp[j / 2];
                } else {
                }
                for (int k = 1; k < j; k++) {
                    int tmp = j - k;
                    if (tmp % 2 == 0) {
                        dp[j] += dp[tmp / 2];
                    }
                }
            }
            System.out.println(dp[n]);
        }
    }
}