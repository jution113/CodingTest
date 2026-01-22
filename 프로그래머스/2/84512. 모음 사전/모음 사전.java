class Solution {
    static int cnt;
    static String[] src = {"A", "E", "I", "O", "U"};
    static String target;
    
    public int solution(String word) {
        cnt = 0;
        target = word;
        dfs("", 0);
        return cnt;
    }
    
    private boolean dfs(String cur, int depth) {
        if (cur.equals(target)) {
            return true;
        }
        
        for (int i = 0; i < src.length; i++) {
            if (depth + 1 <= src.length) {
                cnt++;
                if (dfs(cur + src[i], depth + 1))
                    return true;
            }
        }
        
        return false;
    }
}