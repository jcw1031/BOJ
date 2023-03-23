/* Floyd Warshall algorithm

   - 플로이드-워셜 알고리즘 -
   노드 개수 n개에 맞추어 n*n의 2차원 배열을 만들고
   자기 자신은 0, 입력되는 두 노드 사이는 1, 직접 연결되어 있지 않은 노드 사이는 ∞으로 설정.
   다른 노드를 거쳐 가는 경로를 탐색하여 최솟값으로 배열을 최신화한다.(dp)

   - 브루트포스 알고리즘 -
   조합을 이용하여 두 노드를 선택하여 합을 구하고
   최솟값을 찾고, 그 최솟값을 갖는 두 노드를 저장
 */

package codingTestGold.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class HoseoksTwoChickens21278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 200;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        for (int via = 1; via <= n; via++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    graph[start][end] = Math.min(graph[start][end], graph[start][via] + graph[via][end]);
                }
            }
        }

        int min = 10000000;
        int[] index = new int[2];
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int tmp = 0;
                for (int k = 1; k <= n; k++) {
                    tmp += Math.min(graph[k][i] * 2, graph[k][j] * 2);
                }
                if (min > tmp) {
                    min = tmp;
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        bw.write(index[0] + " " + index[1] + " " + min);

        bw.flush();
        bw.close();
    }
}