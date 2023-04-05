package silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AtoB16953 {
    public static long n, m;
    public static Queue<Long> queue = new LinkedList<>();
    public static int count = 0;

    public static void bfs() {
        while (!queue.isEmpty()) {
            int tmp = queue.size();
            count++;
            for (int i = 0; i < tmp; i++) {
                long tt = queue.poll();

                if (tt == m) {
                    return;
                }

                if (tt * 2 <= m)
                    queue.offer((tt * 2));
                if (tt * 10 + 1 <= m)
                    queue.offer((tt * 10 + 1));
            }
        }
        System.out.println(-1);
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());

        queue.offer(n);

        bfs();

        System.out.println(count);
    }
}