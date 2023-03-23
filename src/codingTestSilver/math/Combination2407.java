//BigInteger 사용법 익히기

package codingTestSilver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Combination2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger n = BigInteger.valueOf(Long.parseLong(st.nextToken()));
        BigInteger m = BigInteger.valueOf(Long.parseLong(st.nextToken()));

        BigInteger result1 = BigInteger.valueOf(1);
        BigInteger result2 = BigInteger.valueOf(1);

        if (m.compareTo(n.subtract(m)) == -1) {
            for (BigInteger i = n.subtract(m).add(BigInteger.ONE); i.compareTo(n) == 0 || i.compareTo(n) == -1; i = i.add(BigInteger.ONE)) {
                result1 = result1.multiply(i);
            }
            for (BigInteger i = BigInteger.ONE; i.compareTo(m) == 0 || i.compareTo(m) == -1; i = i.add(BigInteger.ONE)) {
                result2 = result2.multiply(i);
            }
        } else {
            for (BigInteger i = m.add(BigInteger.ONE); i.compareTo(n) == 0 || i.compareTo(n) == -1; i = i.add(BigInteger.ONE)) {
                result1 = result1.multiply(i);
            }
            for (BigInteger i = BigInteger.ONE; i.compareTo(n.subtract(m)) == 0 || i.compareTo(n.subtract(m)) == -1; i = i.add(BigInteger.ONE)) {
                result2 = result2.multiply(i);
            }
        }

        System.out.println(result1.divide(result2));
    }
}