import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
            String numStr = br.readLine();
            String[] numStrArr= numStr.split("");
            int n = numStrArr.length;
            int max = Integer.parseInt(numStr);
            int min = Integer.parseInt(numStr);
            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    swap(numStrArr, i, j);
                    if(!numStrArr[0].equals("0")) {
                        int num = Integer.parseInt(String.join("", numStrArr));
                        max = Math.max(max, num);
                        min = Math.min(min, num);
                    }
                    swap(numStrArr, j, i);
                }
            }
            System.out.println(String.format("#%d %d %d", tc, min, max));
        }
	}
    
    static void swap(String[] src, int idx1, int idx2) {
        String tmp = src[idx1];
        src[idx1] = src[idx2];
        src[idx2] = tmp;
    }
}