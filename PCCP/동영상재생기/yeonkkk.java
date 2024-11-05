class Solution {

    public static final String NEXT = "next";

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Video video = Video.of(video_len, op_start, op_end);
        Time currentTime = Time.from(pos);

        for (String command : commands) {
            if (command.equals(NEXT)) {
                currentTime = video.next(currentTime);
                continue;
            }

            currentTime = video.prev(currentTime);
        }

        return buildResult(currentTime);
    }

    private String buildResult(Time time) {
        String minute = String.valueOf(time.getMinute());
        String second = String.valueOf(time.getSecond());

        if (minute.length() == 1) {
            minute = "0" + minute;
        }

        if (second.length() == 1) {
            second = "0" + second;
        }

        return String.join(":", minute, second);
    }


    public static class Video {

        private final Time videoLen;
        private final Time opStart;
        private final Time opEnd;

        private Video(Time videoLen, Time opStart, Time opEnd) {
            this.videoLen = videoLen;
            this.opStart = opStart;
            this.opEnd = opEnd;
        }

        public static Video of(String videoLen, String opStart, String opEnd) {
            return new Video(Time.from(videoLen),
                    Time.from(opStart),
                    Time.from(opEnd));
        }

        public Time next(Time time) {
            Time currentTime = checkOpRange(time);
            Time nextTime = currentTime.plus(10);
            return checkLen(checkOpRange(nextTime));
        }

        public Time prev(Time time) {
            Time currentTime = checkOpRange(time);
            Time prevTime = currentTime.minus(10);
            return checkLen(checkOpRange(prevTime));
        }

        private Time checkOpRange(Time time) {
            int opStartSum = opStart.getTotalSecond();
            int opEndSum = opEnd.getTotalSecond();
            int timeSum = time.getTotalSecond();

            if (opStartSum <= timeSum && timeSum <= opEndSum) {
                return opEnd;
            }

            return time;
        }

        private Time checkLen(Time time) {
            int maxSum = videoLen.getTotalSecond();
            int timeSum = time.getTotalSecond();

            if (maxSum < timeSum) {
                return videoLen;
            }

            return time;
        }
    }

    public static class Time {
        private final int minute;
        private final int second;

        private Time(int minute, int second) {
            this.minute = minute;
            this.second = second;
        }

        public static Time from(String time) {
            String[] times = time.split(":");
            int minute = Integer.parseInt(times[0]);
            int second = Integer.parseInt(times[1]);

            return new Time(minute, second);
        }

        public Time plus(int second) {
            if (this.second + second < 60) {
                return new Time(this.minute, this.second + second);
            }

            return new Time(this.minute + 1, this.second + second - 60);
        }

        public Time minus(int second) {
            if (second <= this.second) {
                return new Time(this.minute, this.second - second);
            }
            int minute = this.minute - 1;

            if (minute < 0) {
                return new Time(0, 0);
            }

            return new Time(minute, 60 + (this.second - second));
        }

        public int getMinute() {
            return minute;
        }

        public int getSecond() {
            return second;
        }

        public int getTotalSecond() {
            return minute * 60 + second;
        }
    }
}
