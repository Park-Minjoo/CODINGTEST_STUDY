import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블로그 21921번
public class Main {

    public static void main(String[] args) throws IOException {
        mySolution();
    }

    /**
     *  누적 합
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 일수
        int m = Integer.parseInt(st.nextToken()); // 원하는 길이
        int[] arr = new int[n + 1]; // 구간합 배열

        int max = 0; // 최대 구간합
        int count = 0; // 그 개수

        // 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = m; i < n + 1; i++) {
            int num = arr[i] - arr[i - m];

            if (max < num) {
                max = num;
                count = 1;
            } else if (max == num) {
                count++;
            }
        }

        if (max == 0){
            System.out.println("SAD");
        } else{
            System.out.println(max);
            System.out.println(count);
        }
    }
}
