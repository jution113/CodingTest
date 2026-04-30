import java.util.*;

class Solution {
    private HashMap<String, Integer> idxByEnrolled;
    private HashMap<String, String> referralByEnrolled;
    private int[] answer;
    
    private class Node {
        String name;
        int income;
        
        public Node(String name, int income) {
            this.name = name;
            this.income = income;
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        idxByEnrolled = new HashMap<> ();
        referralByEnrolled = new HashMap<> ();
        int n = enroll.length;
        answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            idxByEnrolled.put(enroll[i], i);
            if (referral[i].equals("-")) continue;
            referralByEnrolled.put(enroll[i], referral[i]);
        }
        
        bfs(seller, amount);
        
        return answer;
    }
    
    private void bfs(String[] seller, int[] amount) {
        ArrayDeque<Node> q = new ArrayDeque<> ();
        
        for (int i = 0; i < seller.length; i++) {
            q.offer(new Node(seller[i], amount[i] * 100));
        }
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int div = cur.income / 10;
            
            answer[idxByEnrolled.get(cur.name)] += cur.income - div; 

            if (div == 0)
                continue;
            
            if (referralByEnrolled.containsKey(cur.name))
                q.offer(new Node(referralByEnrolled.get(cur.name), div));
        }
    }
}