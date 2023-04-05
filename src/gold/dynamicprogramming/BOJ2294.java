package gold.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 2294번
 */
public class BOJ2294 {

    private static final int MAXIMUM = 10_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int coinsNumber = Integer.parseInt(st.nextToken());
        int goalCost = Integer.parseInt(st.nextToken());
        int[] minimumCoinsNumber = new int[goalCost + 1];

        Arrays.fill(minimumCoinsNumber, MAXIMUM);

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < coinsNumber; i++) {
            int input = Integer.parseInt(br.readLine());
            if (!coins.contains(input)) {
                coins.add(input);
            }
        }

        minimumCoinsNumber[0] = 0;
        for (int i = 1; i <= goalCost; i++) {
            for (Integer coin : coins) {
                if (coin > i) {
                    continue;
                }
                minimumCoinsNumber[i] =
                        Math.min(minimumCoinsNumber[i], minimumCoinsNumber[i - coin] + 1);
            }
        }

        if (minimumCoinsNumber[goalCost] == MAXIMUM) {
            System.out.println(-1);
            return;
        }
        System.out.println(minimumCoinsNumber[goalCost]);
    }
}