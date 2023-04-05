package gold.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NQueen9663 {
    public static int n;
    public static boolean[] visited;
    public static int count = 0;
    public static int[] check;

    public static void backtracking(int depth) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < depth; j++) {
                if (check[j] == i || Math.abs(depth - j) == Math.abs(i - check[j])) break;
            }
            if (j == depth) {
                check[depth] = i;
                backtracking(depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        check = new int[n];

        backtracking(0);
        System.out.println(count);
    }
}