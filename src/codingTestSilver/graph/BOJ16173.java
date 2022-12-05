package codingTestSilver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16173 {
    private static Queue<int[]> queue = new LinkedList<>();
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new int[]{0, 0});

        System.out.println(bfs());
    }

    public static String bfs() {
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if (map[tmp[0]][tmp[1]] == -1) {
                return "HaruHaru";
            }
            int jelly = map[tmp[0]][tmp[1]];
            if (jelly + tmp[0] < n && !isVisited[jelly + tmp[0]][tmp[1]]) {
                queue.add(new int[]{jelly + tmp[0], tmp[1]});
                isVisited[jelly + tmp[0]][tmp[1]] = true;

            }
            if (jelly + tmp[1] < n && !isVisited[tmp[0]][jelly + tmp[1]]) {
                queue.add(new int[]{tmp[0], jelly + tmp[1]});
                isVisited[tmp[0]][jelly + tmp[1]] = true;
            }
        }
        return "Hing";
    }
}