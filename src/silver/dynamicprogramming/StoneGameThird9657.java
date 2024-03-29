package silver.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoneGameThird9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] a = new boolean[1001];

        a[1] = true;
        a[2] = false;
        a[3] = true;
        a[4] = true;
        boolean flag;
        for (int i = 5; i < n + 1; i++) {
            if (a[i - 1] == false) {
                a[i] = true;
            }
            if (a[i - 3] == false) {
                a[i] = true;
            }
            if (a[i - 4] == false) {
                a[i] = true;
            }
        }
        System.out.println(a[n] == true ? "SK" : "CY");
    }
}