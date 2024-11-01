import java.util.*;
class Solution {
    public String[] solution(int[][] queries) {
        String[] result = new String[queries.length];
        for(int i = 0; i < queries.length; i++)
            result[i] = queries[i][0] == 1 ? "Rr" : recursive(queries[i][0], queries[i][1]);
        return result;
    }
    private String recursive(int n, int p) {
        int cnt = (int) Math.pow(4, n - 1);
        if(p <= cnt / 4) return "RR";
        if(p > cnt / 4 * 3) return "rr";
        if(n == 2) return "Rr";
        if(p > cnt / 4 && p <= cnt / 2) return recursive(n - 1, p - cnt / 4);
        return recursive(n - 1, p - cnt / 2);
    }
}

//
//class Solution {
//    //순종은 순종만, 잡종인 경우 섞임
//    //type: 1 - RR, 2 - rr, 3 - Rr
//    //dfs? -> 깊이 들어가면 각 세대 인덱스를 모름 -> bfs로 범위 벗어나면 버리기 -> 근데 어케 알지?
//    //그럼 거꾸로: 4^(n-1) 가서 각 부모를 스캔? -> (p-1)/4 + 1이 부모 번호
//    //부모 경로를 저장하고 그걸 추적하는 방향
//    public String[] solution(int[][] queries) {
//        String[] answer = new String[queries.length];
//
//        //부모 경로 저장
//        String[] parents = new String[queries.length];
//        for(int i=0; i<queries.length; i++){
//            int[] q = queries[i];
//            String str = "";
//            for(int j=q[0]; j>2; j--){
//                str += (q[1]-1)/4;
//            }
//            parents[i]=str;
//        }
//
//        //저장한 경로 진행
//        for(int i=0; i<queries.length; i++){
//            int[] q = queries[i];
//
//            //예외처리: 1을 보는경우
//            if(q[0] == 1){
//                answer[i] = "3";
//                continue;
//            }
//
//            int[] now = {1,3,3,2};
//            String p = parents[i];
//
//            //내려가면서 now값 업데이트
//            for(int j=0; j<p.length(); j++){
//                int next = (p.charAt(j) - '0') % 4;
//
//                if(now[next] == 1){
//                    now = new int[] {1,1,1,1};
//
//                } else if(now[next] == 2){
//                    now = new int[] {2,2,2,2};
//
//                } else{
//                    now = new int[] {1,3,3,2};
//                }
//            }
//            answer[i] = (now[ (q[1]-1) % 4]) + "";
//        }
//
//        //type에 맞는 문자열 변환
//        for(int i=0; i<answer.length; i++){
//            String tmp = answer[i];
//
//            if(tmp.equals("1")){
//                answer[i] = "RR";
//            } else if(tmp.equals("2")){
//                answer[i] = "rr";
//            } else {
//                answer[i] = "Rr";
//            }
//        }
//        return answer;
//    }
//
//
//}