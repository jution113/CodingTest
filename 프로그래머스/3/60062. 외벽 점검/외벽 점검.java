import java.util.*;

class Solution {
    private int n;
    private int[] weak;
    private int weakLen;
    private int[] dist;
    private int distLen;
    private int answer;
        
    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.weakLen = weak.length;
        this.dist = dist;
        this.distLen = dist.length;
        answer = Integer.MAX_VALUE;

        makePermutation(new ArrayList<> (), new boolean[distLen]);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    private void makePermutation(ArrayList<Integer> permutation, boolean[] visited) {
        if (permutation.size() == distLen) {
            validate(permutation);
            return ;
        }
        
        for (int i = 0; i < distLen; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permutation.add(dist[i]);
            makePermutation(permutation, visited);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
    
    private void validate(ArrayList<Integer> permutation) {
        for (int i = 0; i < weakLen; i++) simulate(permutation, i);
    }
    
    private void simulate(ArrayList<Integer> permutation, int weakIdx) {
        int permuIdx = 0;
        HashSet<Integer> weakSet = new HashSet<> ();
        for (int w : weak) weakSet.add(w);
        
        while (permuIdx < distLen && weakSet.size() != 0) {
            if (!weakSet.contains(weak[weakIdx])) {
                if (++weakIdx == weakLen) weakIdx = 0;
                continue;
            }
            
            int wallIdx = weak[weakIdx];
            
            for (int i = 0; i <= permutation.get(permuIdx); i++) {
                if (weakSet.contains(wallIdx)) weakSet.remove(wallIdx);
                if (++wallIdx == n) wallIdx = 0;
            }
            
            permuIdx++;
        }
        
        if (weakSet.size() == 0) answer = Math.min(answer, permuIdx);
    }
}