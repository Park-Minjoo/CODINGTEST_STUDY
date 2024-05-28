import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     * 게으른 백곰
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[1000002];

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken()); // 그람수
            int x = Integer.parseInt(st.nextToken()); // 좌표

            arr[x] = g;
        }


        // K까지 구간합
        int max = 0;
        int now = 0;
        int n = 0;

        if (K ==1) {
            n = 2;
        } else if (K >= 1000000){
            n = 1000000;
        } else {
            n = K * 2 ;
        }

        for (int i = 0; i <= n; i++) {
            now = now + arr[i];
        }
        max = now;

        // 구간합 구하기
        int start = 0;
        for (int end = n + 1; end <= 1000000; end++) {
            now = now - arr[start];
            now = now + arr[end];

            start++;

            max = Math.max(max,now);
        }

        System.out.println(max);
    }



}





