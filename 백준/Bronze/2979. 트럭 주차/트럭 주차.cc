#include<iostream>

using namespace std;

// 1. 101 크기의 배열을 선언(1~100 시간 사이에 트럭 수 기록용)
// 2. 3크기의 배열을 선언(요금표 기록용)
// 3. 3번의 입력을 받아서 요금표를 작성한다.
// 4. 2번씩 총 3번의 입력을 받아서 해당 101크기 배열에 시작과 끝 시간 동안 +1씩 기록한다.
// 5. 101 배열을 순회하며 1~3대에 대응되는 요금표를 최종 부과한다. 

int main() {
	int charges[3];
	int truck_cnt_for_time[101] = {};
	
	for(int i = 0; i < 3; i++) {
		int input;
		cin >> input;
		charges[i] = input;
	}
	
	for(int i = 0; i < 3; i++) {
		int start;
		int end;
			
		cin >> start;
		cin >> end;
			
		for(int k = start; k < end; k++) {
			truck_cnt_for_time[k]++;
		}
	}
	
	int sum = 0;
	
	for(int i : truck_cnt_for_time) {
		switch(i) {
			case 1:
				sum += charges[0];
				break;
			case 2:
				sum += charges[1] * i;
				break;
			case 3:
				sum += charges[2] * i;
				break;
		}
	}
	
	cout << sum;
	
	return 0;
}