package codingTestGold.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position1 implements Comparable<Position> {
    public int num;
    public int time;

    public Position1(int num, int time) {
        this.num = num;
        this.time = time;
    }

    @Override
    public int compareTo(Position o) {
        return this.time - o.time;
    }
}

public class HideAndSeekSecond12851 {
    public static int n, k;
    public static boolean[] visited = new boolean[100001];
    public static Queue<Position1> queue = new LinkedList<>();
    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static int time = Integer.MAX_VALUE;

    public static void bfs() {
        while (!queue.isEmpty()) {
            Position1 tmp = queue.poll();
            visited[tmp.num] = true;
            if (tmp.num == k) {
                if (map.containsKey(tmp.time)) {
                    map.put(tmp.time, map.get(tmp.time) + 1);
                } else {
                    map.put(tmp.time, 1);
                }
                time = Math.min(time, tmp.time);
            }

            int[] a = new int[3];
            a[0] = tmp.num * 2;
            a[1] = tmp.num + 1;
            a[2] = tmp.num - 1;

            for (int i = 0; i < 3; i++) {
                if (a[i] >= 0 && a[i] <= 100000 && !visited[a[i]]) {
                    queue.add(new Position1(a[i], tmp.time + 1));
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

        queue.add(new Position1(n, 0));
        visited[n] = true;
        bfs();

        System.out.println(time + "\n" + map.get(time));
    }
}