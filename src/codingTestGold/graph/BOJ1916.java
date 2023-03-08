package codingTestGold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 1916번
 */
public class BOJ1916 {

    private static final int MAXIMUM = 100_000 * 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] minimumCost = new int[n + 1];
        List<List<Node>> busRoute = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            busRoute.add(new ArrayList<>());
            minimumCost[i] = MAXIMUM;
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            busRoute.get(s).add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int destinationNode = Integer.parseInt(st.nextToken());




        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startNode, 0));
        minimumCost[startNode] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.getNum();
            if (minimumCost[now] < nowNode.getDistance()) {
                continue;
            }
            List<Node> adjacentNodes = busRoute.get(now);

            for (Node node : adjacentNodes) {
                if (minimumCost[node.getNum()] > minimumCost[now] + node.getDistance()) {
                    minimumCost[node.getNum()] = minimumCost[now] + node.getDistance();
                    pq.offer(new Node(node.getNum(), minimumCost[now] + node.getDistance()));
                }
            }
        }

        System.out.println(minimumCost[destinationNode]);
    }

    static class Node implements Comparable {

        private final int num;
        private final int distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }

        public int getNum() {
            return num;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node) o;
            return Integer.compare(this.distance, node.distance);
        }
    }
}