import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt();

        int[] wine = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            wine[i] = sc.nextInt();
            if (i == 0) {
                dp[i] = wine[i];
                continue;
            }
            int first = 0, second = 0;
            if (i >= 2) second = wine[i] + dp[i-2];
            if (i >= 1) first = wine[i] + wine[i-1];
            if (i >= 3) first += dp[i-3];
            dp[i] = Math.max(first, second);

            dp[i] = Math.max(dp[i-1], dp[i]);
        }

        int answer = 0;
        for (int dpValue : dp) answer = Math.max(answer, dpValue);
        System.out.println(answer);

        sc.close();

    }
}