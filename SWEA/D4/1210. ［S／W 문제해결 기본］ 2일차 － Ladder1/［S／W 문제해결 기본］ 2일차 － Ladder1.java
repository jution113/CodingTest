import java.io.*;
import java.util.*;

public class Solution {
	static int y = 0;
	static int x = 0;
	static List<ArrayList<Integer>> ladder;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			boolean testInProgress = true;
			ladder = new ArrayList<ArrayList<Integer>> ();
			
			y = 0;
			x = 0;
			
			// 사다리 생성
			while(testInProgress) {
				ladder.add(new ArrayList<> ());
				StringTokenizer st = new StringTokenizer(br.readLine());
				int i = 0;
				
				while(st.hasMoreTokens()) {
					int num = Integer.parseInt(st.nextToken());
					ladder.get(ladder.size() - 1).add(num);
					if(num == 2) {
						testInProgress = false;
						y = ladder.size() - 1;
						x = i;
					}
					i++;
				}
			}
			
			int w = ladder.get(0).size();
			
			// 탐색
			while(y > 0) {
				if(x + 1 < w && ladder.get(y).get(x + 1) == 1) {
					move(1, w);
				} else if(0 <= x - 1 && ladder.get(y).get(x - 1) == 1) {
					move(-1, w);
				} else {
					y--;
				}
			}
			
			System.out.println("#" + tc + " " + x);
		}
	}
	
	static void move(int dir, int w) {
		while(0 <= x + dir && x + dir < w && ladder.get(y).get(x + dir) == 1) {
			x += dir;
		}
		y--;
	}

}
