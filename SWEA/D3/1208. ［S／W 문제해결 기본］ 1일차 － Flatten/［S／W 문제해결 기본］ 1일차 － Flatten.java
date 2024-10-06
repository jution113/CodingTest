import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = 10;
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            int dumpCount = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> numList = new ArrayList<> ();
            while(st.hasMoreTokens()) numList.add(Integer.parseInt(st.nextToken()));
            numList = numList.stream().sorted().mapToInt(num -> num.intValue()).boxed().collect(Collectors.toList());

            while(dumpCount > 0 && numList.get(numList.size() - 1) - numList.get(0) > 1) {
                numList.set(numList.size() - 1, numList.get(numList.size() - 1) - 1);                
                numList.set(0, numList.get(0) + 1);
                dumpCount--;
                numList = numList.stream().sorted().mapToInt(num -> num.intValue()).boxed().collect(Collectors.toList());
            }
            
            sb.append(numList.get(numList.size() - 1) - numList.get(0)).append("\n");
        }
        
        System.out.println(sb.toString());
	}
}