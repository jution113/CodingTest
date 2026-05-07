import java.util.*;

class Solution {
    static int minCostSum;
    static boolean[] visit;
    static ArrayList<Integer> pickList;
    static ArrayList<Integer> mineralList;
    static int[][] costTable;
    
    public int solution(int[] picks, String[] minerals) {
        // 광물 인덱싱
        mineralList = new ArrayList<> ();
        
        for (String mineral : minerals) {
            switch (mineral) {
                case "diamond":
                    mineralList.add(0);
                    break;
                case "iron":
                    mineralList.add(1);
                    break;
                default:
                    mineralList.add(2);
            }
        }
        
        // 채굴 비용 초기화
        costTable = new int[picks.length][picks.length];
        for (int i = 0; i < picks.length; i++) {
            Arrays.fill(costTable[i], 1);
        }
        costTable[1][0] = 5;
        costTable[2][0] = 25;
        costTable[2][1] = 5;

        // 곡괭이 리스트 초기화
        pickList = new ArrayList<> ();
        
        for (int i = 0; i < picks.length; i++) {
            for (int j = 0; j < picks[i]; j++) pickList.add(i);
        }
        
        visit = new boolean[pickList.size()];
        
        minCostSum = Integer.MAX_VALUE;
        
        dfs(0, 0, 0);
        
        return minCostSum;
    }
    
    private void dfs(int mineralOrder, int costSum, int usedPickCnt) {
        if (costSum >= minCostSum) {
            return;
        }
        if (mineralOrder == mineralList.size() || usedPickCnt == pickList.size()) {
            minCostSum = Math.min(minCostSum, costSum);
            return;
        }
        
        for (int i = 0; i < pickList.size(); i++) {
            if (visit[i]) continue;
            visit[i] = true;
            
            int cnt = 0;
            int cost = 0;
            while (mineralOrder + cnt < mineralList.size() && cnt < 5) {
                cost += costTable[pickList.get(i)][mineralList.get(mineralOrder + cnt)];
                cnt++;
            }
            
            dfs(mineralOrder + cnt, costSum + cost, usedPickCnt + 1);
            
            visit[i] = false;
        }
    }
}