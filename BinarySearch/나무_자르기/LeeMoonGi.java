import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나무자르기 2805번
public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    /**
     * 이진탐색으로 절단기 최대 높이를 구함
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 나무 수
        long m = Integer.parseInt(st.nextToken()); // 필요한 길이

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        long start = 0;
        long end = max;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long length = 0; // 자른 후 나무
            for (int i = 0; i < n; i++) {
                long tmp = arr[i] - mid;
                if (tmp < 0) // 음수면 0으로
                    tmp = 0;
                length = length + tmp;
            }

            // 나무 부족할때 => 절단기 길이를 늘려야 한다
            if (length < m) {
                end = mid - 1;
                // 나무 넘칠떄 => 절단기 길이를 줄여야 한다
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);
    }

/*
4 0
20 15 10 17

5 20
4 42 40 26 46
 */
}
