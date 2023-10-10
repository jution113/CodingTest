// 1. 해시 테이블 A, B를 선언한다.
// 2. A에는 key:int, val:string을 담고
// 3. B에는 key:string, val:intg을 담는다
// 4. n, m을 입력 받는다.
// 5. n만큼 입력을 받으며 A, B에 각각 값을 담는다.
// 6. m만큼 입력을 받아 key의 타입에 따라 A, B에서 찾아 출력한다. 

#include<iostream>
#include<unordered_map>
#include<string>

using namespace std;

int main() {
	unordered_map<int, string> a;
	unordered_map<string, int> b;
	
	string res = ""; 
	
	int n = 0, m = 0;
	cin >> n >> m;
	
	for(int i = 1; i <= n; i++) {
		string input = "";
		cin >> input;
		
		a[i] = input;
		b[input] = i;
	}
	
	for(int i = 0; i < m; i++) {
		string input = "";
		cin >> input;
		
		// 입력이 숫자인지 검사 
		if(input.at(0) < 65) {
			res += a[stoi(input)] + "\n";
		} else {
			res += to_string(b[input]) + "\n";
		}
	}
	
	cout << res;
	
	return 0;
}