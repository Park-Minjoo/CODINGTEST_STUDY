import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // 가로가 더 길어야 하니까, 제곱근 까지
        for (int height = 1; height <= Math.sqrt(yellow); height++) {
            if (yellow % height == 0) {
                int width = (yellow / height);
                int expected = 2 * width + 2 * height + 4;

                if (expected == brown) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    return answer;
                }
            }
        }

        return answer;
    }
}
