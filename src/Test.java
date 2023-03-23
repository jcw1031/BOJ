import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ", ");

        int cap, n;
        cap = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] deliveries = new int[n];
        int[] pickups = new int[n];

        String tmp = st.nextToken();
        System.out.println(tmp);
        for (int i = 0; i < n; i++) {

        }
    }
}