package org.woojin.simulation;

import java.util.*;

public class 후보추천하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());
        int m = Integer.valueOf(sc.nextLine());

        List<Node> lst = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int k;
        for(int i=0; i<m; i++){
            k = Integer.valueOf(st.nextToken());

            boolean isHere = false;

            for(Node now : lst){
                if(now.who == k){
                    isHere = true;
                    now.count+=1;
                    break;
                }
            }

            if(!isHere){
                if(lst.size() >= n) {
                    Collections.sort(lst, (n1, n2) ->{
                        if(n1.count == n2.count){
                            return n1.when - n2.when;
                        }
                        return n1.count - n2.count;
                    });

                    lst.remove(0);
                }
                lst.add(new Node(k, 0, i));
            }
        }

        Collections.sort(lst, (n1, n2) -> n1.who - n2.who);

        StringBuilder sb = new StringBuilder();

        for(Node now : lst){
            sb.append(now.who).append(" ");
        }

        System.out.println(sb);


    }

    static class Node{
        int who;
        int count;
        int when;

        public Node(int _who, int _c, int _when){
            who = _who;
            when = _when;
            count = _c;
        }
    }
}
