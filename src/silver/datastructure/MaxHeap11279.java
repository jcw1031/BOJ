package silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                maxHeap.offer(input);
            } else {
                if (maxHeap.isEmpty()) System.out.println('0');
                else {
                    System.out.println(maxHeap.poll());
                }
            }
        }
    }
}