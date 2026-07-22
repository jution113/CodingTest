import java.util.*;

class Solution {
    private String[][] relation;
    private int rLen;
    private int cLen;
    private int answer;
    private HashSet<Integer> candidateSet;
    
    public int solution(String[][] relation) {
        this.relation = relation;
        this.rLen = relation.length;
        this.cLen = relation[0].length;
        this.answer = 0;
        this.candidateSet = new HashSet<> ();
        
        for (int c = 0; c < cLen; c++)
            makeCombination(0, 0, c + 1, new ArrayList<> ());
        
        return answer;
    }
    
    private void makeCombination(int start, int depth, int maxDepth, ArrayList<Integer> combination) {
        if (depth == maxDepth) {
            if (uniqueValidate(combination) != -1 && minimumValidate(combination) != -1) {
                // System.out.println(combination.toString() + " -> " + candidate);
                answer++;
            }
            return ;
        }
        
        for (int c = start; c < cLen; c++) {
            combination.add(c);
            makeCombination(c + 1, depth + 1, maxDepth, combination);
            combination.remove(combination.size() - 1);
        }
    }
    
    private int uniqueValidate(ArrayList<Integer> combination) {
        HashSet<String> set = new HashSet<> ();
        StringBuilder sb;
        for (int r = 0; r < rLen; r++) {
            sb = new StringBuilder();
            for (int c : combination) sb.append(relation[r][c] + " ");
            if (set.contains(sb.toString())) return -1;
            set.add(sb.toString());
        }
        return combination.size();
    }
    
    private int makeCandidate(ArrayList<Integer> combination) {
        int candidate = 0;
        for (int c : combination)
            candidate |= (1 << c);
        return candidate;
    }
    
    private int minimumValidate(ArrayList<Integer> combination) {
        int cur = makeCandidate(combination);
        
        for (int prev : candidateSet)
            if ((cur & prev) == prev) return -1;
        candidateSet.add(cur);
        
        return cur;
    }
}