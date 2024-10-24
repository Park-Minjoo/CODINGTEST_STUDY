import java.util.*;

class Solution {
    //int[] c26배열 해당 값 - 'a' -> 인덱스
    //해당 값이 나온 인덱스를 비교
    //0이 아닌데 연속되지 않은 값아다 -> 외톨이 -> -1로 설정
    public String solution(String input_string) {
        String answer = "";

        int[] alphbats = new int[50];
        Arrays.fill(alphbats, -99);

        for(int i=0; i<input_string.length(); i++){
            int a_i = input_string.charAt(i) - 'a';

            //이미 외톨이 알파벳이면 패스
            if(alphbats[a_i] == -1){
                continue;
            }

            //-99이면 처음 나온거
            if(alphbats[a_i] == -99){
                alphbats[a_i] = i;
            } else {
                //-99이 아닌데 연속되지 않은 값아다 -> 외톨이
                if(i - alphbats[a_i] == 1){
                    alphbats[a_i] = i;
                } else {
                    alphbats[a_i] = -1;
                    answer += input_string.charAt(i);
                }
            }
        }

        //알파벳 정렬
        char[] tmp = answer.toCharArray();
        Arrays.sort(tmp);
        answer = String.valueOf(tmp);

        //아무것도 없는 경우 처리
        if(answer.length() == 0){
            answer = "N";
        }

        return answer;
    }
}