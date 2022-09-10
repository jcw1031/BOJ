import java.io.*;
import java.util.StringTokenizer;

class Test{
    public static int n, m;
    /** combination of nCr
     * @see <a href="https://naver.com">Naver</a>
     * @version 1.3.0*/
    public static void combination(){
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
        System.out.println(dp[n][m]);
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());


        //permutation of nPr
        int[] dp2 = new int[n+1];
        dp2[0] = 1;
        for(int i=1;i<=n;i++){
            dp2[i] = dp2[i-1]*i;
        }
        bw.write(dp2[n]+"\n");
        bw.flush();

        combination();


        System.out.println("Hello World!");
    }
}