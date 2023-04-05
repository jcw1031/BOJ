package silver.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NAndMSecond15650 {
    public static int n, m;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void combination(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sb.append(i + 1).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        combination(0, 0);

        System.out.println(sb);
    }
}