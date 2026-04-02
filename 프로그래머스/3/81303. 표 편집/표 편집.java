import java.util.*;

class Solution {
    private class Node {
        int num;
        int prevNum;
        int nextNum;
        
        public Node(int num, int prevNum, int nextNum) {
            this.num = num;
            this.prevNum = prevNum;
            this.nextNum = nextNum;
        }
    }
    
    public String solution(int n, int k, String[] cmds) {
        // Node 관리 맵 초기화
        HashMap<Integer, Node> nodeByNum = new HashMap<> ();

        nodeByNum.put(-1, new Node(-1, -2, 0));
        nodeByNum.put(n, new Node(n, n - 1, n + 1));
        
        for (int num = 0; num < n; num++) {
            nodeByNum.put(num, new Node(num, num - 1, num + 1));
        }

        // Node 삭제 스택
        ArrayDeque<Integer> removedNodeStack = new ArrayDeque<> ();
        
        // 명령어 실행
        int curNodeNum = k;
        
        for (String cmd : cmds) {
            String[] cmdInfo = cmd.split(" ");
            
            switch (cmdInfo[0]) {
                case("U"):
                    int uMove = Integer.parseInt(cmdInfo[1]);
                    
                    for (int m = 0; m < uMove; m++) curNodeNum = nodeByNum.get(curNodeNum).prevNum;
                    break;
                case("D"):
                    int dMove = Integer.parseInt(cmdInfo[1]);
                    
                    for (int m = 0; m < dMove; m++) curNodeNum = nodeByNum.get(curNodeNum).nextNum;
                    break;
                case("C"):
                    // 삭제 처리
                    removedNodeStack.push(curNodeNum);
                    
                    // 노드 연결 수정
                    int prevNodeNum = nodeByNum.get(curNodeNum).prevNum;
                    int nextNodeNum = nodeByNum.get(curNodeNum).nextNum;
                    
                    nodeByNum.get(prevNodeNum).nextNum = nextNodeNum;
                    nodeByNum.get(nextNodeNum).prevNum = prevNodeNum;
                    
                    if (nextNodeNum == n) {
                        curNodeNum = prevNodeNum;
                    } else {
                        curNodeNum = nextNodeNum;
                    }
                    break;
                case("Z"):
                    // 삭제 복구
                    int recoveryNum = removedNodeStack.pop();
                    int prevNodeNum2 = nodeByNum.get(recoveryNum).prevNum;
                    int nextNodeNum2 = nodeByNum.get(recoveryNum).nextNum;
                    
                    nodeByNum.get(prevNodeNum2).nextNum = recoveryNum;
                    nodeByNum.get(nextNodeNum2).prevNum = recoveryNum;
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        while (!removedNodeStack.isEmpty()) {
            answer[removedNodeStack.pop()] = 'X';
        }
        
        return new String(answer);
    }
}