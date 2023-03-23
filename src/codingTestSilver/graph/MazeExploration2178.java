package codingTestSilver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeExploration2178 {

    private static Queue<int[]> queue = new LinkedList<>();
    private static int n, m;
    private static int[][] map;
    private static int[] tmp = new int[2];

    public static void bfs() {
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            set(tmp[0] + 1, tmp[1]);
            set(tmp[0] - 1, tmp[1]);
            set(tmp[0], tmp[1] + 1);
            set(tmp[0], tmp[1] - 1);
        }
    }

    public static void set(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        if (map[y][x] == 1) {
            queue.add(new int[]{x, y});
            map[y][x] = map[tmp[1]][tmp[0]] + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }

        queue.add(new int[]{0, 0});
        bfs();

        System.out.println(map[n - 1][m - 1]);
    }
}
