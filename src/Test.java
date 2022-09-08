import java.io.*;
import java.util.StringTokenizer;

class Test{
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        //combination of nCr
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        bw.write(dp[n][m]+"\n");
        bw.flush();

        //permutation of nPr
        int[] dp2 = new int[n+1];
        dp2[0] = 1;
        for(int i=1;i<=n;i++){
            dp2[i] = dp2[i-1]*i;
        }
        bw.write(dp2[n]+"\n");
        bw.flush();



        System.out.println("Hello World!");
    }
}