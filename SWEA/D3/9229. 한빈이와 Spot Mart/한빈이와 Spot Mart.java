import java.util.*;
import java.io.*;

class Solution {
    // 입력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    // 과자 관련
    private static int totalSnacks;
    private static int weightLimit;
    private static int[] snackWeights;
    private static int maxSnacksWeight;
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        int totalTestCase = Integer.parseInt(br.readLine());

		for(int testCase = 1; testCase <= totalTestCase; testCase++) {
            init();
            findMaxSnacksWeight();
            sb.append("#" + testCase + " " + maxSnacksWeight + "\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        totalSnacks = Integer.parseInt(st.nextToken());
        weightLimit = Integer.parseInt(st.nextToken());
        
        snackWeights = new int[totalSnacks];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalSnacks; i++)
            snackWeights[i] = Integer.parseInt(st.nextToken());
        
        maxSnacksWeight = -1;
    }
    
    private static void findMaxSnacksWeight() {
        Arrays.sort(snackWeights);
        
        for (int i = totalSnacks - 1; i > 0; i--) {
            if (snackWeights[i] > weightLimit) continue;

            for (int j = 0; j < i; j++) {
                if (snackWeights[i] + snackWeights[j] > weightLimit) break;
                maxSnacksWeight = Math.max(maxSnacksWeight, snackWeights[i] + snackWeights[j]);
            }
        }
    }
}