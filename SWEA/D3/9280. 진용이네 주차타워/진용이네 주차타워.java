import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			// 자리 번호 : 요금
			Map<Integer, Integer> charges = new HashMap<> ();
			// 차 번호 : 무게
			Map<Integer, Integer> weights = new HashMap<> ();
			// 차 번호 : 자리 번호
			Map<Integer, Integer> parkingCars = new HashMap<> ();
			// 비어있는 자리 번호 오름차순 정렬 큐
			Queue<Integer> emptySpace = new PriorityQueue<> ();
			//대기 차 번호
			Queue<Integer> waitCars = new LinkedList<> ();
			int[] carOrders = new int[2 * m];
			int totalCharge= 0;
			
			for(int i = 1; i <= n; i++) {
				charges.put(i, Integer.parseInt(br.readLine()));
				emptySpace.offer(i);
			}
			for(int i = 1; i <= m; i++) weights.put(i, Integer.parseInt(br.readLine()));
			for(int i = 0; i < 2 * m; i++) carOrders[i] = Integer.parseInt(br.readLine());
			
			for(int carNum : carOrders) {
				if(carNum > 0) { // 주차
					// 주차 공간 확인
					if(emptySpace.isEmpty()) {
						// 주차 공간이 없을 경우
						waitCars.add(carNum);
					} else {
						// 주차 공간이 있을 경우
						int spaceIdx = emptySpace.poll();
						if(!waitCars.isEmpty()) carNum = waitCars.poll();
						parkingCars.put(carNum, spaceIdx);
						totalCharge += weights.get(carNum) * charges.get(spaceIdx);
					}
				} else { // 출차
					carNum = Math.abs(carNum);
					int spaceIdx = parkingCars.get(carNum);
					parkingCars.remove(carNum);
					emptySpace.offer(spaceIdx);
					if(!waitCars.isEmpty()) {
						carNum = waitCars.poll();
						spaceIdx = emptySpace.poll();
						parkingCars.put(carNum, spaceIdx);
						totalCharge += weights.get(carNum) * charges.get(spaceIdx);
					}
				}
			}
			System.out.println(String.format("#%d %d", tc, totalCharge));
		}
	}

}