package gold.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2133번
 */
public class BOJ2133 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        if (n % 2 == 1 || n == 0) {
            System.out.println(0);
            return;
        }

        dp[0] = 0;
        dp[2] = 3;

        if (n > 2) {
            dp[4] = 11;
        }

        for (int i = 6; i <= n; i += 2) {
            int result = dp[i - 2] * 3;
            for (int j = 2; j <= i - 4; j += 2) {
                result += dp[j] * 2;
            }
            dp[i] = result + 2;
        }

        System.out.println(dp[n]);
    }
}