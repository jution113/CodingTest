import java.io.*;
import java.util.*;

public class Solution {	
	static int[] dirY = {-1, 1, 0, 0};
	static int[] dirX = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Queue<Cell> cells = new LinkedList<> ();
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				cells.offer(new Cell(y, x, num, dir));
			}
			
			for(int m = 0; m < M; m++) {
				Map<String, Queue<Cell>> cellsNextPos = new HashMap<> ();
				
				while(!cells.isEmpty()) {
					Cell cell = cells.poll();
					cell.y += dirY[cell.dir];
					cell.x += dirX[cell.dir];
					if(cell.y == 0 || cell.y == N - 1 || cell.x == 0 || cell.x == N - 1) {
						cell.num /= 2;
						if(cell.num == 0) continue;
						cell.reverseDir();
					}
					
					String nextPos = cell.y + "-" + cell.x;
					
					if(cellsNextPos.containsKey(nextPos)) {
						cellsNextPos.get(nextPos).offer(cell);
					} else {
						Queue<Cell> samePosCells = new PriorityQueue<> ((c1, c2) -> c2.num - c1.num);
						samePosCells.offer(cell);
						cellsNextPos.put(nextPos, samePosCells);
					}
				}
				
				for(Queue<Cell> cellNextPos : cellsNextPos.values()) {
					Cell maxNumCell = cellNextPos.poll();
					while(!cellNextPos.isEmpty()) maxNumCell.num += cellNextPos.poll().num;
					cells.offer(maxNumCell);
				}
			}
			
			int totalCellNum = 0;
			for(Cell cell : cells) {
				totalCellNum += cell.num;
			}
			
			System.out.println("#" + tc + " " + totalCellNum);
		}
	}
	
	static class Cell {
		int y;
		int x;
		int num;
		int dir;
		
		public Cell(int y, int x, int num, int dir) {			
			this.y = y ;
			this.x = x;
			this.num = num;
			this.dir = dir;
		}
		
		void reverseDir() {
			switch(dir) {
			case 0: 
				dir = 1;
				break;
			case 1:
				dir = 0;
				break;
			case 2:
				dir = 3;
				break;
			default:
				dir = 2;
			}
		}
	}
}
