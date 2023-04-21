package gold.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 2206번
 */
public class BOJ2206 {

    private static final int MAXIMUM = 1_000 * 1_001;
    private static final Queue<Node> queue = new LinkedList<>();

    private static int n;
    private static int m;
    private static char[][] map;
    private static boolean[][] isVisited;
    private static boolean[][] isBreakWallVisited;
    private static int min = MAXIMUM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n + 1][m + 1];
        isVisited = new boolean[n + 1][m + 1];
        isBreakWallVisited = new boolean[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = input.charAt(j - 1);
            }
        }

        queue.add(new Node(1, 1, 1, false));
        bfs();

        System.out.println(min == MAXIMUM ? -1 : min);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.invalid()) {
                continue;
            }

            if (node.isBreakWall) {
                isBreakWallVisited[node.getRow()][node.getColumn()] = true;
            } else {
                isVisited[node.getRow()][node.getColumn()] = true;
            }
            if (node.isDestination() && node.getDepth() < min) {
                min = node.getDepth();
                break;
            }

            queue.add(new Node(node.getRow() + 1, node.getColumn(), node.getDepth() + 1, node.isBreakWall()));
            queue.add(new Node(node.getRow() - 1, node.getColumn(), node.getDepth() + 1, node.isBreakWall()));
            queue.add(new Node(node.getRow(), node.getColumn() + 1, node.getDepth() + 1, node.isBreakWall()));
            queue.add(new Node(node.getRow(), node.getColumn() - 1, node.getDepth() + 1, node.isBreakWall()));
        }
    }

    static class Node {

        private int row;
        private int column;
        private int depth;
        private boolean isBreakWall;

        public Node(int row, int column, int depth, boolean isBreakWall) {
            this.row = row;
            this.column = column;
            this.depth = depth;
            this.isBreakWall = isBreakWall;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public int getDepth() {
            return depth;
        }

        public boolean isBreakWall() {
            return isBreakWall;
        }

        public boolean isDestination() {
            if (row == n && column == m) {
                return true;
            }
            return false;
        }

        public boolean invalid() {
            if (row < 1 || row > n || column < 1 || column > m) {
                return true;
            }
            if (isBreakWall && isBreakWallVisited[row][column]) {
                return true;
            }
            if (!isBreakWall && isVisited[row][column]) {
                return true;
            }
            if (map[row][column] == '1') {
                if (isBreakWall) {
                    return true;
                }
                isBreakWall = true;
                return false;
            }
            return false;
        }
    }
}
