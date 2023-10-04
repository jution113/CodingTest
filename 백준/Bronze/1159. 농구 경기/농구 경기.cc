#include<iostream>
#include<string> 

using namespace std;

// 1. 알파벳ASCII 코드에 대응되는 배열 생성
// 2. 인원수만큼 입력을 받으며 성의 첫번쨰 알파벳 - 97을 실행
// 3. 해당 배열의 알파벳 - 97 위치에 +1
// 4. 모든 입력을 다 받은 뒤 알파벳 배열을 순회하며 5 이상인 위치를 문자로 변환 후 결과 반환 

int main() {
	int a[26] = {};
	
	int n = 0;
	
	cin >> n;
	
	for(int i = 0; i < n; i++) {
		string input = "";
		cin >> input;
		
		a[input.at(0) - 97]++;
	}
	
	int size = sizeof(a) / sizeof(a[0]);
	string res = "";
	
	for(int i = 0; i < size; i++) {
		if(a[i] >= 5) res += (char)(i+97);
	}
	
	if(res.size() == 0) {
		cout << "PREDAJA";
	} else {
		cout << res;
	}
	
	return 0;
}