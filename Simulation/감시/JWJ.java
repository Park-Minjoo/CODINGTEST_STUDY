package org.woojin.simulation;

import java.util.*;

public class 감시 {

    static int n,m;
    static final int CHECK = 9;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        int[][] arr = new int[n][m];
        ArrayList<Node> cctv = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(sc.nextLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.valueOf(st.nextToken());

                if(arr[i][j] != 0 && arr[i][j] != 6){
                    cctv.add(new Node(arr[i][j], i, j));
                }
            }
        }

        bfs(arr, 0, cctv);
        System.out.println(min);

    }

    public static void bfs(int[][] arr, int cnt, ArrayList<Node> cctv){
        if(cnt == cctv.size()){
            min = Math.min(min, countZero(arr));
            return;
        }

        Node now = cctv.get(cnt);
        int[][] tmp;
        if(now.type == 1){

            tmp = copyArr(arr);
            setLeft(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

            tmp = copyArr(arr);
            setRight(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

            tmp = copyArr(arr);
            setTop(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

            tmp = copyArr(arr);
            setBottom(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

        } else if(now.type == 2){
            tmp = copyArr(arr);
            setLeft(tmp, now.x, now.y);
            setRight(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

            tmp = copyArr(arr);
            setTop(tmp, now.x, now.y);
            setBottom(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);
        } else if(now.type == 3){
            tmp = copyArr(arr);
            setTop(tmp, now.x, now.y);
            setRight(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

            tmp = copyArr(arr);
            setRight(tmp, now.x, now.y);
            setBottom(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

            tmp = copyArr(arr);
            setLeft(tmp, now.x, now.y);
            setBottom(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

            tmp = copyArr(arr);
            setLeft(tmp, now.x, now.y);
            setTop(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

        } else if(now.type == 4){

            tmp = copyArr(arr);
            setTop(tmp, now.x, now.y);
            setRight(tmp, now.x, now.y);
            setLeft(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

            tmp = copyArr(arr);
            setRight(tmp, now.x, now.y);
            setBottom(tmp, now.x, now.y);
            setTop(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

            tmp = copyArr(arr);
            setLeft(tmp, now.x, now.y);
            setBottom(tmp, now.x, now.y);
            setTop(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);

            tmp = copyArr(arr);
            setLeft(tmp, now.x, now.y);
            setRight(tmp, now.x, now.y);
            setBottom(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);


        } else if(now.type == 5){
            tmp = copyArr(arr);
            setLeft(tmp, now.x, now.y);
            setRight(tmp, now.x, now.y);
            setTop(tmp, now.x, now.y);
            setBottom(tmp, now.x, now.y);
            bfs(tmp, cnt+1, cctv);
        }
    }

    public static void setLeft(int[][] arr, int x, int y){
        for(int i = y-1; i>=0; i--){
            if(arr[x][i] == 0){
                arr[x][i] = CHECK;
            } else if (arr[x][i] == 6) {
                break;
            }
        }
    }

    public static void setRight(int[][] arr, int x, int y){
        for(int i = y+1; i<m; i++){
            if(arr[x][i] == 0){
                arr[x][i] = CHECK;
            } else if (arr[x][i] == 6) {
                break;
            }
        }
    }

    public static void setTop(int[][] arr, int x, int y){
        for(int i = x-1; i>=0; i--){
            if(arr[i][y] == 0){
                arr[i][y] = CHECK;
            } else if (arr[i][y] == 6) {
                break;
            }
        }
    }

    public static void setBottom(int[][] arr, int x, int y){
        for(int i = x+1; i<n; i++){
            if(arr[i][y] == 0){
                arr[i][y] = CHECK;
            } else if (arr[i][y] == 6) {
                break;
            }
        }
    }

    public static int countZero(int[][] arr){
        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0){
                    result++;
                }
            }
        }

        return result;
    }

    public static int[][] copyArr(int[][] arr){
        int[][] copy_arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy_arr[i][j] = arr[i][j];
            }
        }

        return copy_arr;
    }

    static class Node{
        int type;
        int x;
        int y;

        public Node(int _type, int _x, int _y){
            type = _type;
            x = _x;
            y = _y;
        }
    }
}
