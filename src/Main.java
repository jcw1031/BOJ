import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static BigInteger factorial(int n, int m){
        System.out.println("factorial"+ n);
        if(n <= m){
            return BigInteger.valueOf(1);
        }

        return BigInteger.valueOf((long) n *factorial(n-1, m));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(n+" "+m);

        long result;

        if(m < n-m){
            result = factorial(n, n-m)/factorial(m, 1);
        }
        else{
            result = factorial(n, m)/factorial(n-m, 1);
        }

        System.out.println(result);
    }
}