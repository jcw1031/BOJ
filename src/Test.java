import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }


    }
}