import java.io.*;
import java.util.*;

class LeeMoonGi {
    public String solution(String input_string) throws Exception {
        char[] chars = input_string.toCharArray();
        boolean[] alphVisited = new boolean[26];
        boolean[] alphSolo = new boolean[26]; // 외톨이 알파벳
        String answer = "";

        alphVisited[chars[0] - 97] = true;
        for (int i=1; i<chars.length; i++) {
            // 바로 전에 알파벳이랑 같으면 한덩어리
            if (chars[i] == chars[i-1])
                continue;

            // 처음 등장한 알파벳
            int idx = chars[i] - 97;
            if (!alphVisited[idx]) {
                alphVisited[idx] = true;
                // 전에 보였던 알파벳
            } else  {
                alphSolo[idx] = true;
            }
        }

        boolean isNull = false;
        for (int i=0; i<alphSolo.length; i++) {
            if (alphSolo[i]) {
                answer += (char) (97 + i);
                isNull = true;
            }
        }
        return isNull ? answer : "N";
    }
}