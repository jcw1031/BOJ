import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int[] input = new int[6];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<6;i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            double r = Math.sqrt(Math.pow(Math.abs(input[0]-input[1]), 2)+Math.pow(Math.abs(input[3]-input[4]), 2));
            int rMax, rMin;
            if(input[2] > input[5]){
                rMax = input[2];
                rMin = input[5];
            }
            else{
                rMax = input[5];
                rMin = input[2];
            }

            if(input[0] == input[1] && input[3] == input[4]){
                if(input[2] == input[5]){
                    bw.write(-1+"\n");
                    continue;
                }
                else{
                    bw.write(0+"\n");
                    continue;
                }
            }
            if(rMax > r+rMin){
                bw.write(0+"\n");
                continue;
            }
            else if(rMax == r+rMin){
                bw.write(1+"\n");
                continue;
            }

            if(r > input[2]+input[5]){
                bw.write(0+"\n");
            }
            else if(r < input[2]+input[5]){
                bw.write(2+"\n");
            }
            else{
                bw.write(1+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}