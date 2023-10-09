#include<iostream>

using namespace std;

int main() {
	int n, m, cnt = 0;
	cin >> n >> m;
	
	int arr[n] = {};
	
	for(int i = 0; i < n; i++) {
		int input = 0;
		cin >> input;
		
		arr[i] = input;
	}
	
	for(int i = 0; i < n - 1; i++) {
		for(int j = i + 1; j < n; j++) {
			if(arr[i] + arr[j] == m) cnt++;
		}
	}
	
	cout << cnt;
	
	return 0;
}