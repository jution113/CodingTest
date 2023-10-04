#include<iostream>
#include<string>

using namespace std;

// 1. 한줄 입력 받기
// 2. 한줄 문자열 순회
// 2.1. 조건: 65 ~ 90 || 97 + 122일 경우 ASCII CODE + 13 후 해당 문자 결과에 더하기 
// 2.1.1. 만약 13을 더할 경우 값을 초과하면 처음 시작 숫자 + 나머지 숫자로 계산 
// 2.2. 조건에 부합하지 않을 경우 해당 문자 결과에 더하기
// 3.3. 결과값 출력

int main() {
	string input = "";
	string res = "";
	
	getline(cin, input);
	
	for(char c : input) {
		int tmp = 0;
		tmp = (int)c;
		
		if(65 <= tmp && tmp <= 90) {
			tmp += 13;
			if(tmp > 90) tmp -= 26;
		} else if(97 <= tmp && tmp <= 122) {
			tmp += 13;
			if(tmp > 122) tmp -= 26;
		}
		
		res += tmp;
	} 
	
	cout << res;
	
	return 0;
}