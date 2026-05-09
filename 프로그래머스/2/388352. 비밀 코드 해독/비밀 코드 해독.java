import java.util.*;

class Solution {
    private final int MAX_LEN = 5;
    
    private int answer;
    private int n;
    private int[] ans;
    private HashSet<Integer> [] setQ;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.ans = ans;
        setQ = new HashSet[q.length];
        for (int i = 0; i < q.length; i++) {
            setQ[i] = new HashSet<> ();
            for (int j : q[i]) {
                setQ[i].add(j);
            }
        }
        
        answer = 0;
        comb(1, 0, new ArrayList<> ());
        
        return answer;
    }
    
    private void comb(int start, int curLen, ArrayList<Integer> code) {
        if (curLen == MAX_LEN) {
            if (validate(code)) answer++;
            return;
        }
        
        for (int i = start; i <= n; i++) {
            code.add(i);
            comb(i + 1, curLen + 1, code);
            code.remove(code.size() - 1);
        }
    }
    
    private boolean validate(ArrayList<Integer> code) {
        for (int i = 0; i < setQ.length; i++) {
            int cnt = 0;
            
            for (int c : code) {
                if (setQ[i].contains(c)) cnt++;
            }
            
            if (cnt < ans[i] || cnt > ans[i])
                return false;
        }
        return true;
    }
}