import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }

        list[0].add(Integer.parseInt(br.readLine()));

        for(int i=1;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++){
                int a = -1, b = -1;
                int tmp = Integer.parseInt(st.nextToken());
                if(j-1 >=0){
                    a=list[i-1].get(j-1);
                }
                if(j < list[i-1].size()){
                    b = list[i-1].get(j);
                }
                list[i].add(a>b?a+tmp:b+tmp);
            }
        }
        System.out.println(Collections.max(list[n-1]));
    }
}