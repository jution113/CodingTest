import java.util.*;
import java.io.*;

class Solution
{
    static int[] nums = new int[7];
    static TreeSet<Integer> treeSet = new TreeSet<> (Comparator.reverseOrder());
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= TC; tc++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < 7; i++) nums[i] = Integer.parseInt(st.nextToken());
            treeSet.clear();
            
            combination(0, 0, new ArrayList<Integer> ());
            
            for(int i = 0; i < 4; i++) treeSet.pollFirst();
            System.out.println(String.format("#%d %d", tc, treeSet.pollFirst()));
        }
	}
    
    static void combination(int start, int curDepth, List<Integer> peekList) {
        if(curDepth == 3) {
            int sum = 0;
            for(int num : peekList) sum += num;
            treeSet.add(sum);
			return;
        }
        
        for(int i = start; i < 7; i++) {
            peekList.add(nums[i]);
            combination(i + 1, curDepth + 1, peekList);
            peekList.remove(peekList.size() - 1);
        }
    }
}