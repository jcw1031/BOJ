package silver.datastructure.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1269 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st = null;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int element = Integer.parseInt(st.nextToken());
                map.put(element, map.getOrDefault(element, 0) + 1);
            }
        }

        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}