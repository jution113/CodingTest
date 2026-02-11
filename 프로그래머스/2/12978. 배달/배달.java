import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] distanceMap = new int[N + 1][N + 1];
        
        // init map
        for (int[] roadInfo: road) {
            int townNum = roadInfo[0];
            int townNum2 = roadInfo[1];
            int distance = roadInfo[2];
            
            if (distanceMap[townNum][townNum2] == 0) {
                distanceMap[townNum][townNum2] = distance;
                distanceMap[townNum2][townNum] = distance;
            } else {
                distanceMap[townNum][townNum2] = Math.min(distanceMap[townNum][townNum2], distance);
                distanceMap[townNum2][townNum] = Math.min(distanceMap[townNum2][townNum], distance);
            }
        }
        
        return findReachableTownUsingBfs(distanceMap, N, K);
    }
    
    private int findReachableTownUsingBfs(int[][] distanceMap, int N, int K) {
        ArrayDeque<Town> townQue = new ArrayDeque<> ();
        townQue.offer(new Town(1, 0));
        
        int[] minDistanceArr = new int[N + 1];
        Arrays.fill(minDistanceArr, Integer.MAX_VALUE);
        minDistanceArr[1] = 0;
        
        int visitedCnt = 0;
        
        while (!townQue.isEmpty()) {
            Town town = townQue.poll();
            int curTownNum = town.num;
            int curDistanceSum = town.distanceSum;
            
            for (int nextTownNum = 1; nextTownNum <= N; nextTownNum++) {
                int nextDistance = distanceMap[curTownNum][nextTownNum];
                int nextDistanceSum = curDistanceSum + nextDistance;
                if (nextDistance == 0 || nextDistanceSum > K || nextDistanceSum >= minDistanceArr[nextTownNum])
                    continue;
                townQue.offer(new Town(nextTownNum, nextDistanceSum));
                minDistanceArr[nextTownNum] = nextDistanceSum;
            }
        }
        
        for (int distance : minDistanceArr) {
            if (distance <= K)
                visitedCnt++;
        }
        
        return visitedCnt;
    }
    
    static class Town {
        int num;
        int distanceSum;
        
        public Town(int num, int distanceSum) {
            this.num = num;
            this.distanceSum = distanceSum;
        }
    }
}