package codingTestGold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11404 {

    private static final int MAXIMUM = 100_000 * 100;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int m;
    private static int[][] minimumCost;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        minimumCost = new int[n + 1][n + 1];
        init();
        inputData();

        floydWarshallAlgorithm();

        display();
    }

    private static void init() {
        for (int i = 1; i < minimumCost.length; i++) {
            for (int j = 1; j < minimumCost[i].length; j++) {
                if (i == j) {
                    minimumCost[i][j] = 0;
                    continue;
                }
                minimumCost[i][j] = MAXIMUM;
            }
        }
    }

    private static void inputData() throws IOException {
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (minimumCost[start][end] > cost) {
                minimumCost[start][end] = cost;
            }
        }
    }

    private static void floydWarshallAlgorithm() {
        for (int middle = 1; middle <= n; middle++) {
            for (int start = 1; start <= n; start++) {
                if (middle == start) {
                    continue;
                }
                for (int end = 1; end <= n; end++) {
                    if (middle == end) {
                        continue;
                    }
                    if (minimumCost[start][end] > minimumCost[start][middle] + minimumCost[middle][end]) {
                        minimumCost[start][end] = minimumCost[start][middle] + minimumCost[middle][end];
                    }
                }
            }
        }
    }

    private static void display() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (minimumCost[i][j] == MAXIMUM) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(minimumCost[i][j] + " ");
            }
            System.out.println();
        }
    }
}