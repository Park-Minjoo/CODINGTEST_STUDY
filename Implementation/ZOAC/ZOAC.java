import java.io.*;
import java.util.*;

public class Main {

    private static String str;
    private static int length;
    private static char[] output;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        length = str.length();
        output = new char[str.length()];
        Arrays.fill(output, ' ');

        nextChar(0, length);
        System.out.println(sb.toString());
    }

    private static void nextChar(int start, int end) {
        char[] arr = str.toCharArray();
        int length = arr.length;

        char min = 91;
        int index = 0;
        for (int i=start; i<end; i++) {
            if (min - arr[i] > 0) {
                min = arr[i];
                index = i;
            }
        }

        output[index] = min;
        for (int i=0; i<length; i++) {
            if (output[i] != ' ') {
                sb.append(output[i]);
            }
        }
        sb.append("\n");

        if (end - start == 1) {
            return;
        }

        // 0이면 남은 문자가 없는 경우
        if (index+1 - end != 0) {
            nextChar(index+1, end); // 오른쪽
        }
        if (start - index != 0) {
            nextChar(start, index); // 왼쪽
        }
    }
}
