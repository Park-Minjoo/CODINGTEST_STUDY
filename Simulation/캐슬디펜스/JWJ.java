package org.woojin.simulation;

import java.util.*;

public class 캐슬디펜스 {

    //적들을 저장하는 리스트
    static List<Node> points = new LinkedList<>();

    //격자판 정보
    static int[][] S;
    static int n,m,d;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        d = Integer.valueOf(st.nextToken());

        S = new int[n+1][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(sc.nextLine());
            for(int j=0; j<m; j++){
                S[i][j] = Integer.valueOf(st.nextToken());

                if(S[i][j] == 1){
                    points.add(new Node(i,j));
                }
            }
        }
        //입력끝

        int max = -1;

        int i=0,j=1,q=2;
        for(; i<j; i++){
            for(j=i+1; j<q; j++){
                for(q=j+1; q<m; q++){
                    List<Node> archer = new LinkedList<>();
                    archer.add(new Node(n,i));
                    archer.add(new Node(n,j));
                    archer.add(new Node(n,q));

                    List<Node> enemy = makeCopy(points);

                    max = Math.max(max, bfs(enemy, archer));

                }
            }
        }

        System.out.println(max);

    }


    //0. 궁수의 모든 조합을 보는 메서드
    public static int bfs(List<Node> enemy, List<Node> archer){
        int result = 0;
        while(!enemy.isEmpty()){
            result += attack(enemy, archer);
            nextMove(enemy);
        }

        return result;
    }


    //1.모든 적을 한칸씩 이동시키는 메서드 -> 적이 없는 경우 종료
    public static void nextMove(List<Node> enemy){
        List<Node> dies = new LinkedList<>();

        for(Node now : enemy){
            now.x += 1;

            if(now.x >= n){
                dies.add(now);
            }
        }

        for(Node die : dies){
            enemy.remove(die);
        }
    }

    //2. 거리를 계산하여 공격하는 메서드
    public static int attack(List<Node> enemy, List<Node> archer){

        Set<Node> dies = new HashSet<>();

        int r1,c1, r2, c2, d_;
        for(Node a : archer){
            PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2) -> {
                if(n1.d == n2.d){
                    return n1.y - n2.y;
                } else{
                    return n1.d - n2.d;
                }
            });

            r1 = a.x;
            c1 = a.y;

            for(Node now : enemy){
                r2 = now.x;
                c2 = now.y;

                d_ = Math.abs(r1-r2) + Math.abs(c1 - c2);

                if(d_ <= d){
                    now.setD(d_);
                    pq.offer(now);
                }
            }

            if(pq.peek() != null) {
                dies.add(pq.poll());
            }
        }

        int result = dies.size();
        for(Node die : dies){
            enemy.remove(die);
        }

        return result;

    }

    //4. 깊은 복사를 진행하는 메서드
    public static List<Node> makeCopy(List<Node> arr){
        List<Node> new_arr = new LinkedList<>();

        for(Node n : arr){
            new_arr.add(new Node(n.x, n.y));
        }

        return new_arr;
    }



    //3. 적을 표현하는 노드 클래스
    static class Node{
        int x;
        int y;
        int d;

        public Node(int _x, int _y){
            x = _x;
            y = _y;
        }

        public void setD(int _d){
            d = _d;
        }

        public String toString(){
            return "(" + x +", " + y + ")" ;
        }
    }



}
