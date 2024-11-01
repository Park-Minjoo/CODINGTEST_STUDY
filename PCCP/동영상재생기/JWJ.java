import java.util.*;

class Solution {
    static int video_m, video_s, ops_m, ops_s, ope_m, ope_s, next_m, next_s;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] v_times = video_len.split(":");
        video_m = Integer.parseInt(v_times[0]);
        video_s = Integer.parseInt(v_times[1]);

        String[] ops_times = op_start.split(":");
        ops_m = Integer.parseInt(ops_times[0]);
        ops_s = Integer.parseInt(ops_times[1]);

        String[] ope_times = op_end.split(":");
        ope_m = Integer.parseInt(ope_times[0]);
        ope_s = Integer.parseInt(ope_times[1]);

        String[] times = pos.split(":");
        next_m = Integer.parseInt(times[0]);
        next_s = Integer.parseInt(times[1]);

        pos = checkTime(next_m, next_s);

        for (String command : commands) {
            times = pos.split(":");
            next_m = Integer.parseInt(times[0]);
            next_s = Integer.parseInt(times[1]);

            if (command.equals("next")) {
                next_s += 10;
            } else {
                next_s -= 10;
            }
            pos = checkTime(next_m, next_s);
        }

        return pos;
    }

    public static String checkTime(int min, int sec) {
        // 초 조정
        if (sec >= 60) {
            sec -= 60;
            min += 1;
        } else if (sec < 0) {
            sec += 60;
            min -= 1;
        }

        // 영상 범위 조정
        if (min < 0 || (min == 0 && sec < 0)) {
            min = 0;
            sec = 0;
        } else if (min > video_m || (min == video_m && sec > video_s)) {
            min = video_m;
            sec = video_s;
        }

        // 오프닝 범위 확인 및 건너뛰기
        if ((min > ops_m || (min == ops_m && sec >= ops_s)) && (min < ope_m || (min == ope_m && sec <= ope_s))) {
            min = ope_m;
            sec = ope_s;
        }

        return String.format("%02d:%02d", min, sec);
    }
}