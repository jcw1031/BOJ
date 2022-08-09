
//조합과 너비우선탐색

import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[][] tmp;
    public static Queue<Integer> queue = new LinkedList<>();
    public static int count, max = 0;

    public static void combination(int[][] arr, int start, int depth){
        if(depth == 3){
            count = 0;
            visited = new boolean[n][m];
            for(int i=0;i<n;i++){
                for(int j = 0;j<m;j++){
                    tmp[i][j] = arr[i][j];
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(tmp[i][j] == 2 && !visited[i][j]){
                        dfs(i, j);
                    }
                }
            }

            for(int i=0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(tmp[i][j] == 0)
                        count++;
                }
            }

            if(max < count) max = count;

            return;
        }

        for(int i=start;i<n*m;i++){
            int x = i/m;
            int y = i%m;
            if(arr[x][y] == 0){
                arr[x][y] = 1;
                combination(arr, i+1, depth+1);
                arr[x][y] = 0;
            }
        }
    }

    public static void dfs(int x, int y){
        if(x<0 || x>=n || y<0 || y>=m){
            return;
        }
        if(tmp[x][y] != 1 && !visited[x][y]){
            visited[x][y] = true;
            tmp[x][y] = 2;

            dfs(x+1, y);
            dfs(x-1, y);
            dfs(x, y+1);
            dfs(x, y-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        tmp = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(arr, 0, 0);
        System.out.println(max);
    }
}