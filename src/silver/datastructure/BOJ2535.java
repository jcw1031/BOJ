package silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Student implements Comparable { //점수를 기준으로 정렬하기 위해 Comparable 인터페이스의 compareTo() 구현
    private int country;
    private int id;
    private int score;

    public Student(int country, int id, int score) {
        this.country = country;
        this.id = id;
        this.score = score;
    }

    public int getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        return student.getScore().compareTo(getScore());
    }
}

public class BOJ2535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> check = new HashMap<>(); //해당 국가의 몇 명의 학생이 상을 받았는지 저장하는 Map

        Student[] students = new Student[size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());

            int country = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            students[i] = new Student(country, id, score); //생성자를 통해 국가, 번호, 점수를 저장
        }

        /*Arrays.sort(students, new Comparator<>() { //람다식을 통해 더 간단하게 표현 가능하지만, 람다식을 공부하지 않았기 때문에 현재와 같이 구현
            @Override
            public int compare(Student1 s1, Student1 s2) { //Integer 클래스에 정의된 compare 메소드를 오버라이딩
                return Integer.compare(s2.getScore(), s1.getScore()); //s2 점수 > s1 점수일 경우 양수 리턴
            }
        });*/

        Arrays.sort(students);

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (count == 3) {
                break;
            }
            int country = students[i].getCountry();

            if (check.get(country) == null) {
                check.put(country, 1);
            } else if (check.get(country) != 2) {
                check.put(country, check.get(country) + 1);
            } else {
                continue;
            }
            System.out.println(country + " " + students[i].getId());
            count++;
        }
    }
}