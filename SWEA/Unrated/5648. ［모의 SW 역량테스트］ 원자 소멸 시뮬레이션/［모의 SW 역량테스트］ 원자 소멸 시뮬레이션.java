import java.util.*;
import java.io.*;

class Solution {
    private static final int LIMIT = 2000;
    private static final int[] DIR_Y = {1, -1, 0, 0};
    private static final int[] DIR_X = {0, 0, -1, 1};
    
	private static int N;
	private static int[][] atomCntMap;
	private static Atom[] atoms;
	private static ArrayList<Integer> deadList;
    
    private static class Atom {
        int x;
        int y;
        int dir;
        int size;
        
        public Atom(int y, int x, int dir, int size) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.size = size;
        }
    }
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
            int answer = 0;
			N = Integer.parseInt(br.readLine());
            atoms = new Atom[N];
            atomCntMap = new int[2 * LIMIT + 1][2 * LIMIT + 1];
            int remainAtomCnt = N;
            
            for (int n = 0; n < N; n++) {
            	st = new StringTokenizer(br.readLine());
            	int x = Integer.parseInt(st.nextToken()) * 2 + LIMIT;
                int y = Integer.parseInt(st.nextToken()) * 2 + LIMIT;
            	int dir = Integer.parseInt(st.nextToken());
            	int size = Integer.parseInt(st.nextToken());
                atoms[n] = new Atom(y, x, dir, size);
                atomCntMap[y][x] = 1;
            }
            
            while (remainAtomCnt > 0) {
                for (int n = 0; n < N; n++) {
                    Atom atom = atoms[n];
                    if (atom == null) continue;
                    atomCntMap[atom.y][atom.x] = 0;
                    atom.y += DIR_Y[atom.dir];
                    atom.x += DIR_X[atom.dir];
                    if (atom.y < 0 || atom.y > 2 * LIMIT || atom.x < 0  || atom.x > 2 * LIMIT) {
                		// 범위 밖 원자 처리
                        remainAtomCnt--;
                        atoms[n] = null;
                        continue;
                    }
                    atomCntMap[atom.y][atom.x] ++;
                }
                
                ArrayList<Integer> deadList = new ArrayList<> ();
                
                // 충돌 원자 처리
                for (int n = 0; n < N; n++) {
                    Atom atom = atoms[n];
                    if (atom == null) continue;
                    if (atomCntMap[atom.y][atom.x] > 1) deadList.add(n);
                }
                for (int n : deadList) {
                    Atom atom = atoms[n];
                    answer += atom.size;
                    atomCntMap[atom.y][atom.x] = 0;
                    remainAtomCnt--;
                    atoms[n] = null;
                }
            }
            
            sb.append("#" + t + " " + answer + "\n");
		}
        
        System.out.println(sb.toString());
	}
}