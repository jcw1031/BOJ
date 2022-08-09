import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EunJeong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ej = br.readLine();
        String tmp = "";
        int size = ej.length();
        int count =0;

        for(int i=size-1;i>=0;i--){
            if(count!=0&& count%3==0){
                tmp=","+tmp;
            }
            tmp= ej.charAt(i)+tmp;
            count++;
        }
        System.out.println("make_comma("+ej+")");
        System.out.println(tmp);
    }
}
