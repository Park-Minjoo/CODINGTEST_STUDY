import java.io.*;
import java.util.*;

public class Main {

    private static int max =0;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        split(str, 0);

        System.out.println(min + " " + max);
    }

    private static void split(String str, int result) {
        int length = str.length();
        String[] split = str.split("");
        // 들어온 문자열의 홀수를 확인한다
        for (int i=0; i<split.length; i++){
            if (Integer.parseInt(split[i]) % 2 == 1) {
                result++;
            }
        }

        if (length == 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        } else if (length == 2) {
            int sum = Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
            split(String.valueOf(sum), result);
        } else if (length >= 3) {
            // 3개로 나누는 방법
            for (int i=1; i<length; i++) {
                for (int j=1; j<length-i; j++) {
                    String s1 = str.substring(0,i);
                    String s2 = str.substring(i,i+j);
                    String s3 = str.substring(i+j);
                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    split(String.valueOf(sum), result);
                }
            }

        }
    }
}
