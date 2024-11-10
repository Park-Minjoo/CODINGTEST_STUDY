class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int op_start_sec = timeToSec(op_start);
        int op_end_sec = timeToSec(op_end);
        int current = timeToSec(pos); // 현재 시간
        int video_len_sec = timeToSec(video_len);

        // 시작
        // 오프닝 구간은 건너뛴다
        if (op_start_sec <= current && current <= op_end_sec) {
            current = op_end_sec;
        }

        for (int i=0; i<commands.length; i++) {

            if (commands[i].equals("prev")) {
                if (current <= 10) current = 0;
                else current -= 10;
            } else if (commands[i].equals("next")) {
                if (current >= video_len_sec - 10) current = video_len_sec;
                else current += 10;
            }

            if (op_start_sec <= current && current <= op_end_sec) {
                current = op_end_sec;
            }
        }
        return SecTotime(current);
    }

    // MM:ss -> 시간초로 변경
    public int timeToSec(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    // 시간초로 변경 -> MM:ss
    public String SecTotime(int sec) {
        int intMin = sec / 60;
        int intSec = sec % 60;
        String strMin = String.valueOf(intMin);
        String strSec = String.valueOf(intSec);

        if (intMin < 10) {
            strMin = "0" + strMin;
        }
        if (intSec < 10) {
            strSec = "0" + strSec;
        }

        return strMin + ":" + strSec;
    }

}