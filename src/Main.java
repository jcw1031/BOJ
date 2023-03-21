import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 13305번
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n - 1];
        int[] oilCost = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oilCost[i] = Integer.parseInt(st.nextToken());
        }

        int now = 0;
        int check = 0;
        long result = 0;
        long totalDistance = 0;
        while (true) {
            totalDistance += distance[check];
            check++;
            if (oilCost[now] > oilCost[check] || check == n - 1) {
                result += oilCost[now] * totalDistance;
                now = check;
                totalDistance = 0;
            }
            if (now == n - 1) {
                break;
            }
        }

        System.out.println(result);
    }
}