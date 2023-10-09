// 1. 입력 값은 반드시 짝수여야 한다.
// 2. 백터의 크기가 2를 초과할 경우 이는 답이 될 수 없다. 
// 3. 검사 종료 시 백터는 반드시 비워져 있어야 한다.

#include<iostream>
#include<vector>
#include<string>

using namespace std;

int main() {
	int n = 0;
	cin >> n;
	
	int res = 0;
	
	for(int i = 0; i < n; i++) {
		string input = "";
		cin >> input;
		
		// 입력 값은 반드시 짝수여야 한다. 
		if(input.size() % 2 != 0) continue;
		
		vector<char> check_v = {};
		
		check_v.push_back(input.at(0));
		
		for(int j = 1; j < input.size(); j++) {
			// 백터의 크기는 2를 넘어서는 안된다. 
//			if(check_v.size() > 2) break;
			
			if(check_v.back() == input.at(j)) {
				check_v.pop_back();
			} else {
				check_v.push_back(input.at(j));
			}
		}
		
		if(check_v.size() == 0) res++;
	}
	
	cout << res;
	
	return 0;
} 