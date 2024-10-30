import java.util.*;

class Solution {
    public String solution(String input_string) {
        Map<Character, Integer> counter = new HashMap<>();
        int n = input_string.length();
        
        for (int i = 1; i <= n; i++) {
            Character pre = input_string.charAt(i-1);
            
            if (i == n) {
                counter.put(pre, counter.getOrDefault(pre, 0) + 1);
                break;
            }
            
            char current = input_string.charAt(i);
            
            if (current == pre) {
                continue;
            }
            
            counter.put(pre, counter.getOrDefault(pre, 0) + 1);
        }
        
        return getResult(counter);
    }
    
    private String getResult(Map<Character, Integer> counter) {
        List<Character> results = new ArrayList<>();
        
        for (Character key: counter.keySet()) {
            if (counter.get(key) == 1 || results.contains(key)) {
                continue;
            }
            
            results.add(key);
        }
        
        if (results.size() == 0) {
            return "N";
        }
        
        Collections.sort(results);
        
        StringBuilder answer = new StringBuilder();
        for (Character result : results) {
            answer.append(result);
        }
        
        return answer.toString();
    }
}
