import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] isUsed = new boolean[words.length];
        ArrayDeque<Node> que = new ArrayDeque<> ();
        
        que.offer(new Node(begin, 0));
        
        while (!que.isEmpty()) {
            Node node = que.poll();
            
            for (int i = 0; i < words.length; i++) {
                if (isUsed[i] || !isChangaeble(node.word, words[i]))
                    continue;
                if (words[i].equals(target))
                    return node.cnt + 1;
                isUsed[i] = true;
                que.offer(new Node(words[i], node.cnt + 1));
            }
        }
        
        return 0;
    }
    
    private boolean isChangaeble(String str, String str2) {
        int diffCnt = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str2.charAt(i)) {
                diffCnt++;
                if (diffCnt >= 2)
                    return false;
            }
        }
        
        return true;
    }
    
    static class Node {
        String word;
        int cnt;
        
        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}