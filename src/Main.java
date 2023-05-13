import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3273
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        boolean[] need = new boolean[2_000_000];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (need[sequence[i]]) {
                answer++;
            }

            int needNumber = x - sequence[i];
            if (needNumber < 0) {
                continue;
            }
            need[needNumber] = true;
        }

        System.out.println(answer);
    }
}