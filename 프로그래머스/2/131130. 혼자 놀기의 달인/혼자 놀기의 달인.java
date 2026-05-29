import java.util.*;

class Solution {
    private int[] cards;
    private boolean[] visited;
    private PriorityQueue<Integer> pq;
    
    public int solution(int[] cards) {
        this.cards = cards;
        visited = new boolean[cards.length];
        pq = new PriorityQueue<> ((a, b) -> {
            return Integer.compare(b, a);
        }); 
        
        for (int box = 0; box < cards.length; box++) {
            if (visited[box]) continue;
            visited[box] = true;
            move(box, 1);
            // System.out.println(String.format("%d : %d", box, pq.peek()));
        }
        
        if (pq.size() < 2) return 0;
        return pq.poll() * pq.poll();
    }
    
    private void move(int box, int cnt) {
        if (visited[cards[box] - 1]) {
            pq.offer(cnt);
            return;
        }
        
        visited[cards[box] - 1] = true;
        move(cards[box] - 1, cnt + 1);
    }
}