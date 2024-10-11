import java.util.*;

class Solution {
    //1. 그래프 탐색을 통해 총 몇덩어리 그룹이 있는지 확인
    //2. 1~n까지 뚫었을때 총 몇덩어리를 얻을 수 있는지 확인

    static int[] dx = {-1, 1, 0 , 0};
    static int[] dy = {0, 0 ,-1 , 1};
    static boolean[][] visited;
    static int n,m;
    static ArrayList<Integer> group_size = new ArrayList<Integer>();
    static int group_num = 1;

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;

        visited = new boolean[n][m];

        int answer = 0;

        //1.
        group_size.add(0);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] != 0 && !visited[i][j]){
                    dfs(i,j, land);
                    group_num++;
                }

            }
        }

        //2.
        int max = Integer.MIN_VALUE;
        boolean[] group_check;
        int tmp;
        for(int j=0; j<m; j++){
            tmp = 0;
            group_check = new boolean[group_size.size()];

            for(int i=0; i<n; i++){
                int g_num = land[i][j];
                if(g_num != 0 && !group_check[g_num]){
                    tmp += group_size.get(g_num);
                    group_check[g_num] = true;
                }
            }

            max = Math.max(tmp, max);

        }

        answer = max;

        return answer;
    }


    public static void dfs(int x, int y, int[][] land){
        Stack<Node> st = new Stack<>();

        st.push(new Node(x,y));
        visited[x][y] = true;

        int count = 0;

        while(!st.isEmpty()){
            Node now = st.pop();

            land[now.x][now.y] = group_num;
            count++;

            for(int k=0; k<4; k++){
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(land[nx][ny] != 0 && !visited[nx][ny]){
                        st.push(new Node(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        group_size.add(count);

    }


    static class Node{
        int x;
        int y;

        public Node(int _x, int _y){
            x = _x;
            y = _y;
        }
    }

}