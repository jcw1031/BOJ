import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> list = new ArrayList<>();
    public static boolean[] visited;

    public static void combination(int depth, int start, ArrayList<Integer> arr) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(list.get(i)).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < n; i++) {
            list.add(arr.get(i));
            combination(depth + 1, i, arr);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        combination(0, 0, arr);

        System.out.println(sb);
    }
}