package codingTestSilver.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

public class WineTasting2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] volume = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            volume[i] = Integer.parseInt(br.readLine());
        }
        map.put(1, volume[0]);
        if (n > 1)
            map.put(2, volume[0] + volume[1]);
        if (n > 2) {
            map.put(3, (Math.max(volume[0], volume[1])) + volume[2]);
            map.put(3, (Math.max(map.get(3), map.get(2))));
        }

        for (int i = 4; i <= n; i++) {
            int[] tmp = new int[2];
            tmp[0] = map.get(i - 3) + volume[i - 1 - 1] + volume[i - 1];
            tmp[1] = map.get(i - 2) + volume[i - 1];
            //System.out.println("i : "+i+" tmp[0] = "+tmp[0]+" tmp[1] = "+tmp[1]);
            map.put(i, Math.max(map.get(i - 1), Math.max(tmp[0], tmp[1])));
            //System.out.println("dp : "+map.get(i));
        }
        System.out.println(Collections.max(map.values()));
    }
}