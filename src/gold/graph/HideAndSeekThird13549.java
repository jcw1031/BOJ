package gold.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position implements Comparable<Position> {
    public int num;
    public int time;

    public Position(int num, int time) {
        this.num = num;
        this.time = time;
    }

    @Override
    public int compareTo(Position o) {
        return this.time - o.time;
    }
}

public class HideAndSeekThird13549 {
    public static int n, k;
    public static boolean[] visited = new boolean[100001];
    public static Queue<Position> queue = new LinkedList<>();
    public static int time = Integer.MAX_VALUE;

    public static void bfs() {
        while (!queue.isEmpty()) {
            Position tmp = queue.poll();
            visited[tmp.num] = true;
            if (tmp.num == k) {
                time = Math.min(time, tmp.time);
                //return tmp.time;
            }

            int[] a = new int[3];
            a[0] = tmp.num * 2;
            a[1] = tmp.num + 1;
            a[2] = tmp.num - 1;

            for (int i = 0; i < 3; i++) {
                if (a[i] >= 0 && a[i] <= 100000 && !visited[a[i]]) {
                    if (i == 1 || i == 2) {
                        queue.add(new Position(a[i], tmp.time + 1));
                    } else {
                        queue.add(new Position(a[i], tmp.time));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        queue.add(new Position(n, 0));
        visited[n] = true;
        bfs();

        System.out.println(time);
    }
}