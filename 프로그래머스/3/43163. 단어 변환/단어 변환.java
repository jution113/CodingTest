import java.util.*;

class Solution {
    private class StringInfo {
        String str;
        boolean[] visit;
        int changeCnt;
        
        public StringInfo(String str, boolean[] visit, int changeCnt) {
            this.str = str;
            this.visit = visit;
            this.changeCnt = changeCnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        ArrayDeque<StringInfo> que = new ArrayDeque<> ();
        
        for (int i = 0; i < words.length; i++) {
            if (validate(begin, words[i])) {
                boolean[] visit = new boolean[words.length];
                visit[i] = true;
                que.offer(new StringInfo(words[i], visit, 1));
            }
        }
        
        while (!que.isEmpty()) {
            StringInfo info = que.poll();
            
            if (info.str.equals(target))
                return info.changeCnt;
            
            for (int i = 0; i < words.length; i++) {
                if (!info.visit[i] && validate(info.str, words[i])) {
                    boolean[] visit = Arrays.copyOf(info.visit, info.visit.length);
                    visit[i] = true;
                    que.offer(new StringInfo(words[i], visit, info.changeCnt + 1));
                }
            }
        }
        
        return 0;
    }
    
    private boolean validate(String str1, String str2) {
        int diffCnt = 0;
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (diffCnt == 1)
                    return false;
                diffCnt++;
            }
        }
        return true;
    }
}