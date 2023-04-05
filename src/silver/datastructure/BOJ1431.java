package silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Guitar implements Comparable {
    private String serial;

    public Guitar(String serial) {
        this.serial = serial;
    }

    public String getSerial() {
        return serial;
    }

    public Integer length() {
        return serial.length();
    }

    public Integer sum() {
        int sum = 0;
        for (int i = 0; i < serial.length(); i++) {
            if (Character.isDigit(serial.charAt(i))) {
                sum += Integer.parseInt(String.valueOf(serial.charAt(i)));
            }
        }

        return sum;
    }

    @Override
    public int compareTo(Object o) {
        Guitar guitar = (Guitar) o;
        if (this.length().equals(guitar.length())) {
            if (this.sum().equals(guitar.sum())) {
                return this.getSerial().compareTo(guitar.getSerial());
            } else {
                return this.sum().compareTo(guitar.sum());
            }
        } else {
            return this.length().compareTo(guitar.length());
        }
    }
}

public class BOJ1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Guitar[] guitars = new Guitar[n];

        for (int i = 0; i < n; i++) {
            String serial = br.readLine();
            guitars[i] = new Guitar(serial);
        }

        Arrays.sort(guitars);

        for (int i = 0; i < n; i++) {
            System.out.println(guitars[i].getSerial());
        }
    }
}
