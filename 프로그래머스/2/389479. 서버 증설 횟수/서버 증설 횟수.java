import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        ArrayDeque<ServersTtl> serversTtlQue = new ArrayDeque<> ();
        int addedServerCnt = 0;
        
        for (int connections : players) {
            int serverCnt = getServerCnt(serversTtlQue);
            int maxConnections = serverCnt * m - 1;
            
            if (connections > maxConnections) {
                int requiredServerCnt = (int) Math.ceil((connections - maxConnections) / (double) m);
                addedServerCnt += requiredServerCnt;
                serversTtlQue.offer(new ServersTtl(requiredServerCnt, k - 1));
                serverCnt += requiredServerCnt;
            }
        }
        
        return addedServerCnt;
    }
    
    private int getServerCnt(ArrayDeque<ServersTtl> serversTtlQue) {
        int serverCnt = 1;
        serversTtlQue.offer(new ServersTtl(-1, -1));
        
        while (!serversTtlQue.isEmpty()) {
            ServersTtl serversTtl = serversTtlQue.poll();
            
            if (serversTtl.ttl == -1)
                break;
            
            if (!serversTtl.isExpired()) {
                serverCnt += serversTtl.serverCnt;
                serversTtlQue.offer(serversTtl);
            }
            
            serversTtl.progressTtl();
        }
        
        return serverCnt;
    }
    
    static class ServersTtl {
        int serverCnt;
        int ttl;
        
        public ServersTtl(int serverCnt, int ttl) {
            this.serverCnt = serverCnt;
            this.ttl = ttl;
        }
        
        private void progressTtl() {
            this.ttl--;
        }
        
        private boolean isExpired() {
            return ttl == 0 ? true : false;
        }
    }
}