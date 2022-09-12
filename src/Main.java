import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int tmp = 1;
        for(int i=n;i>0;i--) {
            for (int j = 0; j < i - 1; j++) {
                bw.write(" ");
            }
            if (i != 1) {
                for (int k = 0; k < tmp; k++) {
                    if (k == 0 || k == tmp - 1) {
                        bw.write('*');
                    } else {
                        bw.write(" ");
                    }
                }
            }
            else{
                for(int k=0;k<tmp;k++){
                    bw.write("*");
                }
            }
            tmp += 2;
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}