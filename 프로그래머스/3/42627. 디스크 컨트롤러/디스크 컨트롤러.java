import java.util.*;

class Solution {
    private static class Node {
        int no;
        int req;
        int pro;
        
        public Node(int no, int req, int pro) {
            this.no = no;
            this.req = req;
            this.pro = pro;
        }
    }
    
    public int solution(int[][] jobs) {
        PriorityQueue<Node> pq2 = new PriorityQueue<> ((a, b) -> {
            return a.req - b.req;
        });
        
        for (int no = 0; no < jobs.length; no++) {
            pq2.offer(new Node(no, jobs[no][0], jobs[no][1]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<> ((a, b) -> {
            if (a.pro == b.pro) {
                if (a.req == b.req)
                    return a.no - b.no;
                return a.req - b.req;
            }
            return a.pro - b.pro;
        });

        int time = pq2.peek().req;
        
        while (!pq2.isEmpty() && pq2.peek().req <= time) {
            pq.offer(pq2.poll());
        }
        
        int answer = 0;
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            time = Math.max(time, node.req);
            time += node.pro;
            answer += time - node.req;
            
            while (!pq2.isEmpty() && pq2.peek().req <= time) {
                pq.offer(pq2.poll());
            }
            
            if (!pq2.isEmpty() && pq.isEmpty()) {
                time = pq2.peek().req;
                
                 while (!pq2.isEmpty() && pq2.peek().req <= time) {
                    pq.offer(pq2.poll());
                }
            }
        }
        
        return answer / jobs.length;
    }
}