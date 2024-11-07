class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int mid = yellow / 2;
        if (yellow == 1)
            mid = 1;
        
        for (int i=1; i<=mid; i++) {
            int height = i;
            int width = yellow / i;
            
            if (yellow % i > 0) continue;
            
            int needBrown = needBrown(width, height);
            
            if (brown == needBrown) {
                answer[0] = width+2;
                answer[1] = height+2;
                break;
            }
        }
        return answer;
    }
    
    // 필요한 갈색개수
    public int needBrown(int width, int height) {
        return width * 2 + (height + 2) * 2;
    }
}