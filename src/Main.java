import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer, Integer> map = new HashMap<>();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            map.put(1, 0);
            map.put(2, 0);
            map.put(3, 0);
            map.put(4, 0);
            int i = 0;
            while (i <= n - 1) {
                map.put(1, map.get(1)+sticker[0][i]);
                map.put(2, map.get(2)+sticker[1][i]);
                map.put(3, map.get(3)+sticker[0][i]);
                map.put(4, map.get(4)+sticker[0][i]);
            }
        }
    }
}