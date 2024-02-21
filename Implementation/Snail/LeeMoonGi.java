
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 달팽이 1913번
public class Snail {


    public static void main(String[] args) throws IOException {
        mySolution();
    }


    /**
     *  돌려가면서 1씩 더하며 배열을 완성시킨다
     *  찾으려는 숫자인지 확인
     */
    public static String targetIdx;
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  // 입력값 N
        int targetNum = Integer.parseInt(br.readLine());  // 찾으려는 숫자
        int[][] map = new int[n][n];

        int indexY = n / 2;
        int indexX = n / 2;
        int numbering = 1;
        map[indexY][indexX] = numbering;

        for (int i = 1; i < n / 2 + 1; i++) {
            // 위로 한칸
            map[--indexY][indexX] = ++numbering;
            isTargetIdx(targetNum, indexY, indexX, numbering);

            // 오른쪽
            for (int j = 0; j < i * 2 - 1; j++) {
                map[indexY][++indexX] = ++numbering;
                isTargetIdx(targetNum, indexY, indexX, numbering);
            }

            // 아래쪽
            for (int j = 0; j < i * 2; j++) {
                map[++indexY][indexX] = ++numbering;
                isTargetIdx(targetNum, indexY, indexX, numbering);
            }

            // 왼쪽
            for (int j = 0; j < i * 2; j++) {
                map[indexY][--indexX] = ++numbering;
                isTargetIdx(targetNum, indexY, indexX, numbering);
            }

            // 위쪽
            for (int j = 0; j < i * 2; j++) {
                map[--indexY][indexX] = ++numbering;
                isTargetIdx(targetNum, indexY, indexX, numbering);
            }
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(targetIdx);
    }

    private static void isTargetIdx(int targetNum, int indexY, int indexX, int numbering) {
        if (targetNum == numbering)
            targetIdx = (indexY + 1) + " " + (indexX + 1);
    }




    /**
     *
     */
    public static void answer() throws IOException {
    }
}