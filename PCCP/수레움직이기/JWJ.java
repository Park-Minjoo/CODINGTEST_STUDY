import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1 ,1};
    static int n,m;
    static int result = Integer.MAX_VALUE;


    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;

        int[] rb = new int[4];
        int[][] r_vist = new int[n][m];
        int[][] b_vist = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maze[i][j] == 1){
                    rb[0] = i;
                    rb[1] = j;

                } else if(maze[i][j] == 2){
                    rb[2] = i;
                    rb[3] = j;
                }

            }
        }

        dfs(r_vist, b_vist, maze, 0, rb);

        if(result == Integer.MAX_VALUE){
            result = 0;
        }

        return result;
    }

    public static int[][] copyArr(int[][] arr){
        int[][] new_arr = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                new_arr[i][j] = arr[i][j];
            }
        }

        return new_arr;
    }

    //vist -> 방문x r 방문 - 1 , b 방문 - 2
    //maze -> r - 1,3, b-2,4  벽 - 5
    //rb -> rx, ry, bx, by
    public static void dfs(int[][] r_vist, int[][] b_vist, int[][] maze, int cnt, int[] rb){

        if(maze[rb[0]][rb[1]] == 3 && maze[rb[2]][rb[3]] == 4){
            result = Math.min(cnt, result);
            return;
        }

        if(cnt >= result){
            return;
        }

        //빨간색 이동 & 파란색 이동
        for(int i=0; i<4; i++){ //빨간색 이동
            int r_nx = rb[0] + dx[i];
            int r_ny = rb[1] + dy[i];

            if(r_nx >= 0 && r_nx < n && r_ny >= 0 && r_ny < m){
                if(maze[rb[0]][rb[1]] == 3){ //빨간색이 도착칸에 있는 경우 -> 고정
                    r_nx = rb[0];
                    r_ny = rb[1];
                    r_vist[r_nx][r_ny] = 0;
                    i=4;
                }

                //빨간색 다음 이동이 벽이거나 방문했으면 패스
                if(maze[r_nx][r_ny] != 5 && r_vist[r_nx][r_ny] != 1){


                    for(int j=0; j<4; j++){ //파란색 이동
                        int b_nx = rb[2] + dx[j];
                        int b_ny = rb[3] + dy[j];

                        if(maze[rb[2]][rb[3]] == 4){ //파란색이 도착칸에 있는 경우 -> 고정
                            b_nx = rb[2];
                            b_ny = rb[3];
                            b_vist[b_nx][b_ny] = 0;
                            j=4;
                        }

                        if(b_nx >= 0 && b_nx < n && b_ny >= 0 && b_ny < m){
                            //파란색 다음 이동이 벽이거나 방문했으면 패스 + 빨간색이랑 동시 이동 불가능
                            if(maze[b_nx][b_ny] != 5 && b_vist[b_nx][b_ny] != 2 && !(b_nx == r_nx && b_ny == r_ny)  ){

                                //자리를 바꾸며 이동 불가능
                                if(!(r_nx == rb[2] && r_ny == rb[3]) && !(b_nx == rb[0] && b_ny == rb[1])){
                                    int[] new_rb = {r_nx, r_ny, b_nx, b_ny};

                                    //방문처리
                                    r_vist[rb[0]][rb[1]] = 1;
                                    b_vist[rb[2]][rb[3]] = 2;

                                    dfs(copyArr(r_vist), copyArr(b_vist), maze, cnt+1, new_rb);
                                }
                            }

                        }
                    }

                }

            }

        }
    }
}