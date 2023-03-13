package codingTestGold.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 17281번
 */
public class BOJ17281 {

    private static final int PLAYER_NUMBER = 9;
    private static int n;
    private static int maxScore = 0;
    private static int[][] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        score = new int[n][PLAYER_NUMBER];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < PLAYER_NUMBER; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] isVisited = new boolean[PLAYER_NUMBER - 1];
        List<Integer> sequence = new ArrayList<>();
        setPlayerSequence(isVisited, sequence, 0);

        System.out.println(maxScore);
    }

    private static void setPlayerSequence(boolean[] isVisited, List<Integer> sequence, int depth) {
        if (depth == PLAYER_NUMBER - 1) {
            int score = play(sequence);
            if (maxScore < score) {
                maxScore = score;
            }
            return;
        }

        for (int i = 0; i < PLAYER_NUMBER - 1; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                sequence.add(i + 1);
                setPlayerSequence(isVisited, sequence, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    private static int play(List<Integer> sequence) {
        sequence.add(3, 0);
        int score = 0; // seuqence 순서 경우의 점수
        int turn = 0; // 타자 순서

        for (int i = 0; i < n; i++) {
            int outCount = 0; // 아웃 수
            List<Runner> runners = new ArrayList<>(); // 주자들
            while (true) {
                if (outCount == 3) {
                    break;
                }

                int result = BOJ17281.score[i][sequence.get(turn)];
                if (result == 0) {
                    outCount++;
                    turn = ++turn % 9;
                    continue;
                }

                score += advanceRunners(result, runners);
                turn = ++turn % 9;
            }
        }
        return score;
    }

    private static int advanceRunners(int result, List<Runner> runners) {
        int score = 0;
        runners.add(new Runner());
        for (int i = 0; i < runners.size(); i++) {
            Runner runner = runners.get(i);
            runner.advance(result);
            if (runner.getStatus() >= 4) {
                score++;
                runners.remove(runner);
                i--;
            }
        }
        return score;
    }

    static class Runner {

        private int status = 0;

        public int getStatus() {
            return status;
        }

        public void advance(int num) {
            this.status += num;
        }
    }
}