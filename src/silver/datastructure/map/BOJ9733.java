package silver.datastructure.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ9733 {

    private static final String[] works = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
    private static Map<String, Integer> map = new HashMap<>();
    private static int totalCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (String work : works) {
            map.put(work, 0);
        }

        String tmp;
        while ((tmp = br.readLine()) != null) {
            st = new StringTokenizer(tmp);
            while (st.hasMoreTokens()) {
                String input = st.nextToken();
                if (map.containsKey(input)) {
                    map.put(input, map.get(input) + 1);
                }
                totalCount++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String work : works) {
            int number = map.get(work);
            double rate = (double) number / (double) totalCount;
            sb.append(work).append(" ")
                    .append(map.get(work)).append(" ")
                    .append(String.format("%.2f", rate)).append("\n");
        }
        sb.append("Total " + totalCount + " 1.00");

        System.out.println(sb);
    }
}