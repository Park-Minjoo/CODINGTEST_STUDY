import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     * 빗물
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int result = 0;

        int[] arr = new int[W];
        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            leftMax[i] = max;
        }

        max = 0;
        for (int i = W - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            rightMax[i] = max;
            int min = Math.min(leftMax[i], rightMax[i]);
            result = result + min - arr[i];
        }

        System.out.println(result);

    }



}





