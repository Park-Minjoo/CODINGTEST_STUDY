import java.util.*;

class Solution {
    public String[] r = {"RR", "Rr", "Rr", "rr"};
    
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int depth = query[0];
            int index = query[1] - 1;
            
            answer[i] = find(depth, index);
        }
        
        return answer;
    }
    
    private String find(int depth, int index) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        // depth 가 1일 때
        if (depth == 1) {
            return r[1];
        }
        
        // depth 가 2일 때
        if (depth == 2) {
            return r[index];
        }
        
        // 계통 인덱스 찾기
        while(depth-- > 1) {
            stack.offerLast(index % 4);
            index /= 4;
        }
        
        while(stack.size() > 1) {
            int parentIndex = stack.pollLast();
            
            // 조상이 RR이나 rr 인 경우
            if (parentIndex == 0 || parentIndex == 3) {
                return r[parentIndex];
            }
        }
        
        // 마지막 조상 (가장 상위 조상)
        return r[stack.pollLast()];
    }
}
