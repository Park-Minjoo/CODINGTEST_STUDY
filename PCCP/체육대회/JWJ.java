import java.util.*;

class Solution {
    //각 종목의 합이 최대가 되게하는 경우 -> 완탐?
    static int max = -1;

    public int solution(int[][] ability) {
        boolean[] vist = new boolean[ability.length];
        dfs(0, 0, ability, vist);
        return max;
    }

    public static void dfs(int cnt, int tmp, int[][] ability, boolean[] vist){
        if(cnt == ability[0].length){
            max = Math.max(max, tmp);
            return;
        }
        for(int i=0; i<ability.length; i++){
            if(vist[i]) continue;
            vist[i] = true;
            dfs(cnt+1, tmp + ability[i][cnt], ability, vist);
            vist[i] = false;
        }
    }
}