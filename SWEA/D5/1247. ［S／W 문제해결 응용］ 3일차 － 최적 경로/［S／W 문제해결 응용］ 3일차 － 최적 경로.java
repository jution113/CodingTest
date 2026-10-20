import java.util.*;
import java.io.*;

class Solution {
    private static int T;
    private static int n;
    private static int minDistSum;
    private static Point startPoint;
    private static Point endPoint;
    private static Point[] points;
    private static int[][] memo;
    
    private static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } 
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            endPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            memo = new int[n][1 << n];
            points = new Point[n];
            for (int i = 0; i < n; i++) {
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            	Arrays.fill(memo[i], Integer.MAX_VALUE);
            }
            
            minDistSum = Integer.MAX_VALUE;
            
            for (int nextPoint = 0; nextPoint < n; nextPoint++) {
                memo[nextPoint][1 << nextPoint] = getDist(startPoint, points[nextPoint]);
                move(nextPoint, 1 << nextPoint);
            }
            answer.append("#" + t + " " + minDistSum + "\n");
		}
        
        System.out.print(answer.toString());
	}
        
    private static int getDist(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    
    private static void move(int curPoint, int mask) {
        if (mask == (1 << n) - 1) {
            minDistSum = Math.min(memo[curPoint][mask] + getDist(points[curPoint], endPoint), minDistSum);
            return ;
        }
        
        for (int nextPoint = 0; nextPoint < n; nextPoint++) {
            if ((mask & 1 << nextPoint) != 0)
                continue;
            
            if (memo[curPoint][mask] + getDist(points[curPoint], points[nextPoint]) < memo[nextPoint][mask | 1 << nextPoint]) {
                memo[nextPoint][mask | 1 << nextPoint] = memo[curPoint][mask] + getDist(points[curPoint], points[nextPoint]);
            	move(nextPoint, mask | 1 << nextPoint);
            }
        }
    }
}