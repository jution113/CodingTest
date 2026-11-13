import java.util.*;
import java.io.*;

class Solution {
    private static final int TOTAL_TEST_CASE = 10;
    
    // 입력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    // 암호문
    private static int cryptogramCnt;
    private static LinkedList<Integer> cryptograms = new LinkedList<> (); 
    
    // 명령어
    private static int commandCnt;
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        
		for(int testCase = 1; testCase <= TOTAL_TEST_CASE; testCase++) {
            init();
            executeCommand();
            
            sb.append("#" + testCase);
            for (int i = 0; i < 10; i++) sb.append(" " + cryptograms.get(i));
            sb.append("\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static void init() throws IOException {
        cryptogramCnt = Integer.parseInt(br.readLine());

        cryptograms.clear();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cryptogramCnt; i++) cryptograms.add(Integer.parseInt(st.nextToken()));
        
		commandCnt = Integer.parseInt(br.readLine());
    }
    
    private static void executeCommand() throws IOException {
        st = new StringTokenizer(br.readLine());
        int pos = 0;
        int cnt = 0;
        
        for (int i = 0; i < commandCnt; i++) {
            if (st.nextToken().equals("I")) {
                pos = Integer.parseInt(st.nextToken());
                cnt = Integer.parseInt(st.nextToken());
                for (int j = 0; j < cnt; j++) cryptograms.add(pos++, Integer.parseInt(st.nextToken()));
            } else {
                pos = Integer.parseInt(st.nextToken());
                cnt = Integer.parseInt(st.nextToken());
                for (int j = 0; j < cnt; j++) cryptograms.remove(pos);
            }
        }
    }
}