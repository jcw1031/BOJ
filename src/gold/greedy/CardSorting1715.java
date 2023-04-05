package gold.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CardSorting1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            pQueue.add(Integer.parseInt(br.readLine()));
        }

        int tmp = 0;
        int sum = 0;
        while (true) {
            if (pQueue.size() == 1) break;

            tmp = pQueue.poll();
            tmp += pQueue.poll();
            sum += tmp;
            pQueue.add(tmp);
        }

        System.out.println(sum);
    }
}
