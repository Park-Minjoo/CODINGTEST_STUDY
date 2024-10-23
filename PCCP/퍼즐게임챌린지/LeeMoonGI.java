class LeeMoonGi {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = binarySearch(diffs, times, limit);
        return answer;
    }

    // 이진 탐색
    public int binarySearch(int[] diffs, int[] times, long limit) {
        int first = 1;
        int last = 100000;

        while (first <= last) {
            int mid = (int) ((first + last) / 2);
            long skill = getSkill(diffs, times, limit, mid); // 숙련도 구하기

            if (skill > limit) {
                first = mid + 1;
            } else {
                last = mid - 1;

            }
        }
        return first;
    }

    // 숙련도 구하기
    public long getSkill(int[] diffs, int[] times, long limit, int currentSkill) {
        long result = 0;
        for (int i=0; i<diffs.length; i++) {
            if (diffs[i] > currentSkill) {
                result += (long) (times[i] + times[i-1]) * (long) (diffs[i] - currentSkill) + times[i];
            } else {
                result += (long) times[i];
            }
        }
        return result;
    }
}