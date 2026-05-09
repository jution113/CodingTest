class Solution {
    public int solution(String s) {
        int sLen = s.length();
        int minLen = sLen;
        
        for (int zipSize = 1; zipSize < sLen; zipSize++) {
            int i = zipSize;
            int len = 0;
            int cnt = 1;
            String before = s.substring(0, i);
            
            while (i + zipSize <= sLen) {
                String cur = s.substring(i, i + zipSize);
                
                if (cur.equals(before)) {
                    cnt++;
                } else {
                    len += cnt > 1 ? String.valueOf(cnt).length() : 0;
                    len += zipSize;
                    cnt = 1;
                }
                
                before = cur;
                i += zipSize;
            }
            
            if (i <= sLen) {
                len += zipSize;
                len += cnt > 1 ? String.valueOf(cnt).length() : 0;
                len += s.substring(i).length();
            }
            
            minLen = Math.min(minLen, len);
        }
        
        return minLen;
    }
}