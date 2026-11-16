import java.util.*;
import java.io.*;

class Solution {
    // 입출력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    // 입력 숫자 관련
    private static int numCnt;
    private static int[] nums;
    
	public static void main(String args[]) throws IOException {
        int testCaseCnt = Integer.parseInt(br.readLine());
        
		for(int i = 1; i <= testCaseCnt; i++) {
            init();
            Arrays.sort(nums);
            for (int j = 0; j < numCnt; j++) {
                sb.append(convertIntNumToStrNum(nums[j]) + " ");
            }
            sb.append("\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        sb.append(st.nextToken() + "\n");
        
        numCnt = Integer.parseInt(st.nextToken());
        nums = new int[numCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            nums[i] = convertStrNumToIntNum(st.nextToken());
        }
    }
    
    private static int convertStrNumToIntNum(String strNum) {
        switch(strNum) {
            case "ZRO":
                return 0;
            case "ONE":
                return 1;
            case "TWO":
                return 2;
            case "THR":
                return 3;
            case "FOR":
                return 4;
            case "FIV":
                return 5;
            case "SIX":
                return 6;
            case "SVN":
                return 7;
            case "EGT":
                return 8;
        }
        return 9;
    }
    
        private static String convertIntNumToStrNum(int intNum) {
        switch(intNum) {
            case 0:
                return "ZRO";
            case 1:
                return "ONE";
            case 2:
                return "TWO";
            case 3:
                return "THR";
            case 4:
                return "FOR";
            case 5:
                return "FIV";
            case 6:
                return "SIX";
            case 7:
                return "SVN";
            case 8:
                return "EGT";
        }
        return "NIN";
    }
}