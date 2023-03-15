package codingTestSilver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2477번
 */
public class BOJ2477 {

    private static final int SIZE = 6;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] direction = new int[SIZE];
        int[] length = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            direction[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
        }

        int squareSize = getSquareSize(direction, length);
        int blankSquareSize = getBlankSquareSize(direction, length);
        int result = (squareSize - blankSquareSize) * n;

        System.out.println(result);
    }

    private static int getSquareSize(int[] direction, int[] length) { // 큰 사각형 면적
        int maxWidth = 0;
        int maxHeight = 0;
        for (int i = 0; i < SIZE; i++) {
            if (direction[i] == 1 || direction[i] == 2) { // 가로인 경우
                maxWidth = Integer.max(maxWidth, length[i]);
            } else { // 세로인 경우
                maxHeight = Integer.max(maxHeight, length[i]);
            }
        }

        return maxWidth * maxHeight;
    }

    private static int getBlankSquareSize(int[] direction, int[] length) { // 비어있는 사각형 면적
        int index = 0;
        int compareIndex;
        int[] blankSquare = new int[2];
        while (true) {
            compareIndex = (index + 2) % SIZE;
            if (isSame(index, compareIndex, direction)) {
                if (isSame(index + 1, (compareIndex + 1) % SIZE, direction)) {
                    blankSquare[0] = length[index + 1];
                    blankSquare[1] = length[compareIndex];
                } else {
                    blankSquare[0] = length[index];
                    blankSquare[1] = length[compareIndex - 1];
                }
                break;
            }
            index++;
        }

        return blankSquare[0] * blankSquare[1];
    }

    private static boolean isSame(int index, int compareIndex, int[] direction) {
        return direction[index] == direction[compareIndex];
    }
}