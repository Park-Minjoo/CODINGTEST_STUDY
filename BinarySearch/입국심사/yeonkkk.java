import java.util.*;

class Solution {

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 0;
        long right = (long) times[times.length - 1] * n;
        long min = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            boolean isPossible = isPossible(mid, times, n);

            if (isPossible) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;    
            }
        }

        return min;
    }

    private boolean isPossible(long totalTime, int[] times, int n) {
        long count = 0;

        for (int time : times) {
            count += totalTime / time;
        }

        return count >= n;
    }
}
