package codingTestSilver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1388 {
    private static int n, m;
    private static boolean[][] isVisited;
    private static char[][] floor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        floor = new char[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                floor[i][j] = input.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j]) {
                    count++;
                    bfs(i, j, floor[i][j]);
                }
            }
        }

        System.out.println(count);
    }

    public static void bfs(int x, int y, char c) {
        if (x == n || x < 0 || y == m || y < 0 || isVisited[x][y] || c != floor[x][y]) {
            return;
        }
        isVisited[x][y] = true;
        if (floor[x][y] == '-') {
            bfs(x, y + 1, c);
            bfs(x, y - 1, c);
        }
        if (floor[x][y] == '|') {
            bfs(x + 1, y, c);
            bfs(x - 1, y, c);
        }
    }
}