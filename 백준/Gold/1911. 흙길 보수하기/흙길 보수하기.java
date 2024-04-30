import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long L = Integer.parseInt(st.nextToken());

        Pool[] pools = new Pool[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long poolStartIdx = Integer.parseInt(st.nextToken());
            long poolEndIdx = Integer.parseInt(st.nextToken());
            pools[i] = new Pool(poolStartIdx, poolEndIdx);
        }

        Arrays.sort(pools, new Comparator<Pool>() {
            @Override
            public int compare(Pool p1, Pool p2) {
                return Long.compare(p1.startIdx, p2.startIdx);
            }
        });

        long totalUsingBridgeCnt = 0;
        long lastBridgeIdx = 0;

        for(int i = 0; i < N ; i++) {
            Pool pool = pools[i];
            long poolStartIdx = pool.startIdx;
            long poolEndIdx = pool.endIdx;

            if(poolEndIdx <= lastBridgeIdx) continue;

            if(poolStartIdx <= lastBridgeIdx) poolStartIdx = lastBridgeIdx + 1;

            long usingBridgeCnt = getNeedBridgeCnt(L, poolStartIdx, poolEndIdx);
            lastBridgeIdx = (poolStartIdx - 1) + L * usingBridgeCnt;
            totalUsingBridgeCnt += usingBridgeCnt;
        }

        System.out.println(totalUsingBridgeCnt);
    }

    static class Pool {
        long startIdx;
        long endIdx;

        public Pool(long startIdx, long endIdx) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        }
    }

    static long getNeedBridgeCnt(long bridgeLength, long poolStartIdx, long poolEndIdx) {
        long poolLength = poolEndIdx - poolStartIdx;
        if(poolLength == 0) return 0;
        if(poolLength <= bridgeLength) return 1;
        long needBridgeCnt = poolLength / bridgeLength;
        return poolLength % bridgeLength == 0 ? needBridgeCnt : needBridgeCnt + 1;
    }
}
