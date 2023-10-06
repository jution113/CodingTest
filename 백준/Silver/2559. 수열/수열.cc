// 1. 입력값 N 크기의 배열 생성
// 2. k 입력 받기 
// 3. 값을 담을 변수 max 선언
// 4. 이중 for문에서 밖의 for문은 0 ~ (n - k - 1)까지 반복 
// 5. 이중 for문의 out은 밖의 인덱스 + (0 ~ k)까지 반복
// 6. 반복문을 순회하며 합한 값이 max보다 클 경우 max 값을 수정하고 그렇지 않을 경우 max 값 유지 

#include<iostream>

using namespace std;

int main() {
	int n = 0;
	int k = 0;
	int max = 0;
	int sum = 0;
	
	cin >> n;
	cin >> k;
	
	int arr[n] = {};
	
	for(int &i : arr) {
		int input = 0;
		cin >> input;
		
		i = input;
	}
	
	for(int i = 0; i < n; i++) {
		sum += arr[i];
		if(i >= k) {
			sum -= arr[i - k];
			max = max > sum ? max : sum;
		} else {
			max = sum;
		}
	}
	
	cout << max;
	
	return 0;
}