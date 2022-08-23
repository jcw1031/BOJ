import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    public int to, price;
    public Node(int to, int price){
        this.to = to;
        this.price = price;
    }

    @Override
    public int compareTo(Node tmp){
        return this.price - tmp.price;
    }
}

public class Main {
    public static boolean[] visited;
    public static int[] cheapest;
    public static HashMap<Integer, Integer>[] map;
    public static PriorityQueue<Node> queue = new PriorityQueue<>();

    public static void visit() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println("--- "+ (node.to+1)+" ---");
            if (!visited[tmp]) {
                visited[tmp] = true;
                for (int key : map[tmp].keySet()) {
                    if (!visited[key]) {
                        queue.add(new Node());
                    }
                    int a = cheapest[tmp];

                    if (cheapest[key] > map[tmp].get(key) + a) {
                        cheapest[key] = map[tmp].get(key) + a;
                    }
                }
                for(int i = 0; i<cheapest.length; i++){
                    System.out.print(i+1+" : "+cheapest[i]+"   ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        cheapest = new int[n];
        map = new HashMap[n];

        for(int i=0;i<n;i++){
            map[i] = new HashMap<>();
        }

        Arrays.fill(cheapest, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[3];
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            tmp[2] = Integer.parseInt(st.nextToken());

            if(map[tmp[0]-1].containsKey(tmp[1]-1)){
                map[tmp[0]-1].put(tmp[1] - 1, tmp[2] < map[tmp[0]-1].get(tmp[1]-1)?tmp[2]:map[tmp[0]-1].get(tmp[1]-1));
            }
            else{
                map[tmp[0]-1].put(tmp[1] - 1, tmp[2]);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;
        queue.add(start);
        cheapest[start] = 0;

        visit();
        System.out.println(cheapest[end]);
    }
}