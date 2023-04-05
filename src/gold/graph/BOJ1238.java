package gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 1238번
 */
public class BOJ1238 {

    private static final int MAXIMUM = 1_000 * 100 * 2;

    private static ArrayList<Node>[] routes;
    private static int[] minimumTime;
    private static int[] returnMinimumTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int villagesNumber = Integer.parseInt(stringTokenizer.nextToken());
        int roadsNumber = Integer.parseInt(stringTokenizer.nextToken());
        int destinationNode = Integer.parseInt(stringTokenizer.nextToken());

        routes = new ArrayList[villagesNumber + 1];
        for (int i = 1; i <= villagesNumber; i++) {
            routes[i] = new ArrayList<>();
        }


        for (int i = 0; i < roadsNumber; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(stringTokenizer.nextToken());
            int endNode = Integer.parseInt(stringTokenizer.nextToken());
            int consumptionTime = Integer.parseInt(stringTokenizer.nextToken());

            routes[startNode].add(new Node(endNode, consumptionTime));
        }

        minimumTime = new int[villagesNumber + 1];
        Arrays.fill(minimumTime, MAXIMUM);

        dijkstra(destinationNode);
        returnMinimumTime = Arrays.copyOf(minimumTime, minimumTime.length);

        int max = 0;
        for (int i = 1; i <= villagesNumber; i++) {
            if (i == destinationNode) {
                continue;
            }

            minimumTime = new int[villagesNumber + 1];
            Arrays.fill(minimumTime, MAXIMUM);

            dijkstra(i);

            int totalConsumptionTime = minimumTime[destinationNode] + returnMinimumTime[i];
            if (totalConsumptionTime < MAXIMUM && max < totalConsumptionTime) {
                max = totalConsumptionTime;
            }
        }

        System.out.println(max);
    }

    private static void dijkstra(int startNode) {
        final PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(startNode, 0));
        minimumTime[startNode] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int endNode = node.getEndNode();
            int time = node.getTime();

            if (minimumTime[endNode] < time) {
                continue;
            }

            for (int i = 0; i < routes[endNode].size(); i++) {
                int nextNode = routes[endNode].get(i).getEndNode();
                int totalTime = routes[endNode].get(i).getTime() + time;
                if (minimumTime[nextNode] > totalTime) {
                    minimumTime[nextNode] = totalTime;
                    priorityQueue.add(new Node(nextNode, totalTime));
                }
            }
        }
    }

    static class Node implements Comparable {

        private int endNode;
        private int time;

        public Node(int endNode, int time) {
            this.endNode = endNode;
            this.time = time;
        }

        public int getEndNode() {
            return endNode;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node) o;
            return Integer.compare(this.time, node.time);
        }
    }
}