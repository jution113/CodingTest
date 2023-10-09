// 1.

#include<iostream>
#include<string>

using namespace std;

int main() {
	int case_cnt = 0;
	cin >> case_cnt;
	
	string pattern = "";
	cin >> pattern;
	
	string res = "";
	
	for(int i = 0; i < case_cnt; i++) {
		string input = "";
		cin >> input;
		
		bool is_end = false;
		
		// 입력의 길이가 1일 경우 
		if(pattern.size() - 1 > input.size()) {
			res += "NE\n";
			continue;
		}
		
		int pattern_idx = 0;
		int input_idx = 0;
		
		while(pattern.at(pattern_idx) != '*') {
			if(pattern.at(pattern_idx) != input.at(input_idx)) {
				is_end = true;
				break;
			}
			pattern_idx++;
			input_idx++;
		}
		
		if(is_end) {
			res += "NE\n";
			continue;
		}
		
		pattern_idx = pattern.size() - 1;
		input_idx = input.size() - 1;
		
		while(pattern.at(pattern_idx) != '*') {
			if(pattern.at(pattern_idx) != input.at(input_idx)) {
				is_end = true;
				break;
			}
			pattern_idx--;
			input_idx--;
		}
		
		if(is_end) {
			res += "NE\n";
		} else {
			res += "DA\n";
		}
		
	}
	
	cout << res;
	
	return 0;
}