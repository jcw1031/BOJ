import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
        int[][] timeAndCost = new int[2][n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            timeAndCost[0][i] = Integer.parseInt(st.nextToken());
            timeAndCost[1][i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=n;i++){
            int max = 0;
            if(i+timeAndCost[0][i]-1 <= n){
                for(int j=1;j<=i;j++){
                    if(max < dp[j]) max = dp[j];
                }
                dp[i+timeAndCost[0][i]] = Math.max(dp[i+timeAndCost[0][i]], max+timeAndCost[1][i]);
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n+1]);
    }
}