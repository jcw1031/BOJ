package codingTestGold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1039번
 */
public class BOJ1039 {

    private static final Queue<int[]> queue = new LinkedList<>();
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        isVisited = new boolean[k][1_000_001];

        if (n / 10 == 0) {
            System.out.println(-1);
            return;
        }

        int result = bfs(n, k);
        System.out.println(result != 0 ? result : -1);
    }

    private static int bfs(int n, int k) {
        int max = 0;
        queue.add(new int[]{0, n});

        while (!queue.isEmpty()) {
            int[] numAndDepth = queue.poll();

            if (numAndDepth[0] == k && numAndDepth[1] > max) {
                max = numAndDepth[1];
            }

            if (numAndDepth[0] != k) {
                changeNum(numAndDepth);
            }
        }

        return max;
    }

    private static void changeNum(int[] numAndDepth) {
        String numberString = String.valueOf(numAndDepth[1]);
        for (int i = 0; i < numberString.length() - 1; i++) {
            for (int j = i + 1; j < numberString.length(); j++) {
                char[] chars = numberString.toCharArray();
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;

                String changedString = String.valueOf(chars);
                if (changedString.startsWith("0")) {
                    continue;
                }

                int changedNum = Integer.parseInt(changedString);
                if (isVisited[numAndDepth[0]][changedNum]) {
                    continue;
                }

                queue.add(new int[]{numAndDepth[0] + 1, changedNum});
                isVisited[numAndDepth[0]][changedNum] = true;
            }
        }
    }
}