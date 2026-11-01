import java.util.*;
import java.io.*;

class Solution {
    // 입력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    private static int cakeCnt;
    private static PriorityQueue<CakeInfo> cakeInfos;
    private static int divideLimit;
    private static double minCakeSize;
    
    private static class CakeInfo {
        double size;
        int sliceCnt = 1;
        
        public CakeInfo(double size) {
            this.size = size;
        }
    }
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        int totalTestCase = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= totalTestCase; testCase++) {
            initDate();
            sb.append("#" + testCase + " " + findMinGap() + "\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static void initDate() throws IOException {
        cakeCnt = Integer.parseInt(br.readLine());
        cakeInfos = new PriorityQueue<> ((a, b) -> {
            return Double.compare(b.size / b.sliceCnt, a.size / a.sliceCnt);
        });
        st = new StringTokenizer(br.readLine());
        minCakeSize = Double.MAX_VALUE;
        for (int i = 0; i < cakeCnt; i++) {
            double cakeSize = Double.parseDouble(st.nextToken());
            cakeInfos.offer(new CakeInfo(cakeSize));
            minCakeSize = Math.min(minCakeSize, cakeSize);
        }
        divideLimit = Integer.parseInt(br.readLine());
    }
    
    private static double findMinGap() {
        double minGap = Double.MAX_VALUE;
        
        for (int divide = 0; divide < divideLimit; divide++) {
            CakeInfo cakeInfo = cakeInfos.poll();
            Double maxCakeSize = cakeInfo.size / cakeInfo.sliceCnt;
            Double gap = maxCakeSize - minCakeSize;
            
            //if (gap > minGap) break;
            
            cakeInfo.sliceCnt++;
            minCakeSize = Math.min(cakeInfo.size / cakeInfo.sliceCnt, minCakeSize);
            minGap = Math.min(gap, minGap);
            cakeInfos.offer(cakeInfo);
        }
        
        CakeInfo cakeInfo = cakeInfos.poll();
        Double maxCakeSize = cakeInfo.size / cakeInfo.sliceCnt;
        Double gap = maxCakeSize - minCakeSize;
        minGap = Math.min(gap, minGap);
        
        return minGap;
    }
}