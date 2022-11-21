package CodingTestSilver.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3182 {
    private static int[] answer;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            answer[i] = Integer.parseInt(br.readLine());
        }

        int max = 0, index = 0;
        for (int i = 1; i <= n; i++) {
            isVisited = new boolean[n + 1];
            isVisited[i] = true;
            int count = 1, next = i;
            while (true) {
                next = answer[next];
                if (isVisited[next]) {
                    break;
                }
                isVisited[next] = true;
                count++;
            }

            if (max < count) {
                max = count;
                index = i;
            }
        }
        System.out.println(index);
    }
}