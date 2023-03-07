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
public class Main {

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

    private static final int MAXIMUM = 100_000 * 1_000;
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int m;
    private static int startNode;
    private static int destinationNode;
    private static boolean[] isVisited;
    private static int[] minimumCost;
    private static List<List<Node>> busRoute;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        init();
        inputData();

        dijkstraAlgorithm();

        display();
    }

    private static void init() {
        isVisited = new boolean[n + 1];
        minimumCost = new int[n + 1];
        busRoute = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            busRoute.add(new ArrayList<>());
            minimumCost[i] = MAXIMUM;
        }
    }

    private static void inputData() throws IOException {
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            busRoute.get(s).add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        destinationNode = Integer.parseInt(st.nextToken());
    }

    private static void dijkstraAlgorithm() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startNode, 0));
        minimumCost[startNode] = 0;

        while (!pq.isEmpty()) {
            int now = pq.poll().getNum();

            if (isVisited[now]) {
                continue;
            }
            isVisited[now] = true;

            List<Node> adjacentNodes = busRoute.get(now);
            for (Node node : adjacentNodes) {
                if (minimumCost[node.getNum()] > minimumCost[now] + node.getDistance()) {
                    minimumCost[node.getNum()] = minimumCost[now] + node.getDistance();
                }
                if (!isVisited[node.getNum()]) {
                    pq.offer(node);
                }
            }
        }
    }

    private static void display() {
        System.out.println(minimumCost[destinationNode]);
    }
}