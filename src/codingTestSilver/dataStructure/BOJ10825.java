package codingTestSilver.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student1 implements Comparable{
    private String name;
    private int korean;
    private int english;
    private int mathematics;

    public String getName() {
        return name;
    }

    public Integer getKorean() {
        return korean;
    }

    public Integer getEnglish() {
        return english;
    }

    public Integer getMathematics() {
        return mathematics;
    }

    public Student1(String name, int korean, int english, int mathematics) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.mathematics = mathematics;
    }

    @Override
    public int compareTo(Object o) {
        Student1 student = (Student1) o;
        if (student.getKorean().equals(this.getKorean())) {
            if (this.getEnglish().equals(student.getEnglish())) {
                if (student.getMathematics().equals(this.getMathematics())) {
                    return this.getName().compareTo(student.getName());
                } else {
                    return student.getMathematics().compareTo(this.getMathematics());
                }
            } else {
                return this.getEnglish().compareTo(student.getEnglish());
            }
        } else {
            return student.getKorean().compareTo(this.getKorean());
        }
    }
}

public class BOJ10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Student1[] students = new Student1[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            students[i] = new Student1(name, k, e, m);
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.println(students[i].getName());

        }
    }
}