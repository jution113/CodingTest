import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        Map<String, Integer> numMap = new HashMap<> ();
        numMap.put("1011000", 0);
        numMap.put("1001100", 1);
        numMap.put("1100100", 2);
        numMap.put("1011110", 3);
        numMap.put("1100010", 4);
        numMap.put("1000110", 5);
        numMap.put("1111010", 6);
        numMap.put("1101110", 7);
        numMap.put("1110110", 8);
        numMap.put("1101000", 9);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[][] map = new String[N][M];
            int row = 0;
            int col = 0;
            for(int n = 0; n < N; n++) {
                String[] input = br.readLine().split("");
                for(int m = 0; m < M; m++) {
                    map[n][m] = input[m];
                    if(map[n][m].equals("1")) {
                        row = n;
                        col = m;
                    }
                }
            }
            int[] nums = new int[8];
            int evenSum = 0;
            int oddSum = 0;
            StringBuilder numSb = new StringBuilder();
            for(int i = 0; i < 8; i++) { 
                for(int j = 0; j < 7; j++) {
                    numSb.append(map[row][col - (7 * i) - j]);
                }
                int num = numMap.get(numSb.toString());
                nums[7 - i] = num;
                if((8 - i) % 2 == 0) {
                    evenSum += num;
                } else {
                    oddSum += num;
                }
                numSb.setLength(0);
            }
            //System.out.println(Arrays.toString(nums));
            //System.out.println(String.format("evenSum: %d / oddSun: %d", evenSum, oddSum));
            
            int result = (oddSum * 3 + evenSum) % 10 == 0 ? evenSum + oddSum : 0;
            sb.append(result).append("\n");
        }
        
        System.out.println(sb.toString());
	}
}