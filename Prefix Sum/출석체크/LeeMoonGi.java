import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 출석체크 20438번
public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    /**
     * 코드 받는 애들이 자는 경우가 있다
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 ≤ K, Q ≤ N ≤ 5,000, 1 ≤ M ≤ 50,000
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int k = Integer.parseInt(st.nextToken()); // 자는 수
        int q = Integer.parseInt(st.nextToken()); // 출석 코드 보낼 수
        int m = Integer.parseInt(st.nextToken()); // 구간 수

        int[] student = new int[n + 3]; // 0:출석no   1:출석ok
        int[] sumArr = new int[n + 3];
        ArrayList<Integer> sleepList = new ArrayList<>();

        // 자는 학생
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            sleepList.add(num);
        }

        // 출석 코드를 받을 학생 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 출석 코드 받는 친구가 자는 경우 **
            if (sleepList.contains(num)) continue;
            for (int j = num; j < n + 3; j = j + num) {
                student[j] = 1;
            }
        }

        // 자는 애들 처리
        for (int i = 0; i < k; i++) {
            Integer sleepNum = sleepList.get(i);
            student[sleepNum] = 0;
        }

        // 구간합 처리 출석하지 않은 수
        for (int i = 3; i < n + 3; i++) {
            if (student[i] == 1)
                sumArr[i] = sumArr[i - 1];
            else
                sumArr[i] = sumArr[i - 1] + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = sumArr[end] - sumArr[start - 1];
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

/*
10 1 3 2
7
3 5 7
3 12
4 4

*/
}
