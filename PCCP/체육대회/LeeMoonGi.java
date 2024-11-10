class Solution {

    public static int max = 0;

    public int solution(int[][] ability) {
        int student = ability.length; //  학생수
        int sports = ability[0].length; // 종목수
        boolean[] visited = new boolean[student];
        int start = 0;

        selectStudent(ability, student, sports, 0, 0, visited);

        return max;
    }

    public void selectStudent(int[][] ability, int student, int sports, int depth, int result, boolean[] visited) {
        // 선수 다 뽑힘
        if (sports == depth) {
            max = Math.max(max, result);
            return;
        }

        for (int i=0; i<student; i++) {
            if (visited[i])
                continue;

            // 스포츠 능력치
            int skill = ability[i][depth];
            visited[i] = true;
            selectStudent(ability, student, sports, depth+1, result + skill, visited);
            visited[i] = false;
        }

    }
}