import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemies) {
        HashMap<Integer, Integer> kCntByEnemy = new HashMap<> ();
        PriorityQueue<Integer> enemyKeyque = new PriorityQueue<> ();
        
        for (int round = 0; round < enemies.length; round++) {
            int enemy = enemies[round];
            
            // 무적권이 남아 있다면
            if (k > 0) {
                if (!kCntByEnemy.containsKey(enemy)) {
                    enemyKeyque.offer(enemy);
                }
                kCntByEnemy.put(enemy, kCntByEnemy.getOrDefault(enemy, 0) + 1);
                k--;
                continue;
            }
            
            // 무적권을 다 소모했다면
            int minEnemy = enemyKeyque.peek();
            
            if (enemy > minEnemy) {
                int minEnemyKCnt = kCntByEnemy.get(minEnemy);
                minEnemyKCnt--;
                if (minEnemyKCnt <= 0) {
                    kCntByEnemy.remove(minEnemy);
                    enemyKeyque.poll();
                } else {
                    kCntByEnemy.put(minEnemy, minEnemyKCnt);
                }
                
                if (!kCntByEnemy.containsKey(enemy)) {
                    enemyKeyque.offer(enemy);
                }
                kCntByEnemy.put(enemy, kCntByEnemy.getOrDefault(enemy, 0) + 1);
                
                n -= minEnemy;
            } else {
                n -= enemy;
            }
            
            if (n < 0) {
                return round;
            }
        }
        
        return enemies.length;
    }
}