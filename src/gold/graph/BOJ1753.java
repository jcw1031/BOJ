package gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    private int destination;
    private int weight;

    public Node(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public void add(final int destination, final int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public int getDestination() {
        return destination;
    }

    public Integer getWeight() {
        return weight;
    }
}

public class BOJ1753 {

    static final int INF = 200001;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Node>[] list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        init(n, start);

        addEdge(m);

        dijkstra(n, start);

        print();
    }

    public static void init(final int n, final int start) {
        distance = new int[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i < distance.length; i++) {
            if (i == start) {
                distance[i] = 0;
                continue;
            }
            distance[i] = INF;
        }

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(distance, INF);
        distance[start] = 0;
    }

    public static void addEdge(final int m) throws IOException {
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }
    }

    private static void dijkstra(final int n, final int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int destination = node.getDestination();
            int weight = node.getWeight();
            if (weight > distance[destination]) {
                continue;
            }

            for (int i = 0; i < list[destination].size(); i++) {
                int vertex = list[destination].get(i).getDestination();
                int newWeight = list[destination].get(i).getWeight() + weight;
                if (distance[vertex] > newWeight) {
                    distance[vertex] = newWeight;
                    queue.add(new Node(vertex, newWeight));
                }
            }
        }
    }

    private static void print() {
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}