package dongbinna.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeeMoonGi {

    /**
     *  자르고 난 이후에 떡 길이를 이진탐색으로 구함
     *  자른 떡이 작으면 더 자르고 크면 덜 자름
     *  큰 부분을 처음 찾으면 절단기의 최대값을 찾으려고 오른쪽 부분을 다시 이진탐색을 한다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long result = 0;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 떡의 개수
        int m = Integer.parseInt(st.nextToken()); // 요청한 떡의 길이
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        int max = 0;
        // 떡길이 입력
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        // 절단기 길이 찾기
        int start = 0;
        int end = max;

        while (true) {
            int mid = (start + end) / 2;
            int tmp = 0;

            // 자르고 남은 떡 길이 계산
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i] - mid;
                if (num > 0)
                    tmp = tmp + num;
            }

            // 떡이 부족 -> 절단기 줄여
            if (tmp < m) {
                end = mid;
                // 떡이 충분 -> 최대길이를 구하기 위해서 다시 탐색
            } else {
                if(end - start <= 1) break; // 종료조건
                result = mid;
                start = mid;
            }
        }

        System.out.println(result);
    }



    /**
     *  < 공부 필요 부분 >
     */
}

