// 1 <= name <= 50

#include<iostream>
#include<string>
#include<map>

using namespace std;

int main() {
	string name = "";
	cin >> name;
	
	char res[name.size() + 1] = {};
	res[name.size()] = '\0';
	
	map<char, int> c_map;
	
	for(char c : name) {
		c_map[c]++;
	}
	
	int odd_cnt = 0;
	int start = 0;
	int end = name.size() - 1;
	
	for(auto& c_cnt : c_map) {
		if(c_cnt.second % 2 != 0) {
			odd_cnt++;
			if(odd_cnt > 1) {
				cout << "I'm Sorry Hansoo";
				exit(0);
			}
			
			res[(name.size() - 1) / 2] = c_cnt.first;
			c_cnt.second--;
		}
		
		for(int i = 0; i < c_cnt.second / 2; i++) {
//			cout << "start : end -> " << start << " : " << end << "\n";
			
			res[start++] = c_cnt.first;
			res[end--] = c_cnt.first;
		}
	}
	
	cout << res;
	
	return 0;
}