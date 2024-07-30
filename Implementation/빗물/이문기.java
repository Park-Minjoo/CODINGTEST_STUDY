import java.io.*;
import java.util.*;

public class 이문기 {

    private static int H, W;
    private static int[] arr;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int leftTop = arr[0];
        int rightTop = 0;
        int moveCount = 0;

        for (int i=1; i<W; i++) {
            moveCount++;
            int current = arr[i];
            if (current >= leftTop) {
                int min = Math.min(leftTop, current);
                for (int j=1; j<moveCount; j++) {
                    answer += min - arr[i-j];
                }
                leftTop = current;
                rightTop = 0;
                moveCount = 0;
            } else {
                rightTop = Math.max(rightTop, current);
            }
        }

        // 마지막 부분이 계산되지 않았으면
        if (moveCount > 1) {
            int moveCount2 = 0;
            rightTop = arr[W-1];

            for (int i=1; i<=moveCount; i++) {
                int current = arr[W-1-i];
                moveCount2++;

                if (current >= rightTop) {
                    int min = Math.min(rightTop, current);
                    for (int j=1; j<moveCount2; j++) {
                        answer += min - arr[W-1-i+j];
                    }
                    leftTop = 0;
                    rightTop = current;
                    moveCount2 = 0;
                } else {
                    leftTop = Math.max(leftTop, current);
                }
            }
        }

        System.out.println(answer);
    }
/*
5 5
5 4 3 2 1
 */

}

