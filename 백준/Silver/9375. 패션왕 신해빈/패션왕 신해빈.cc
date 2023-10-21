// 0 <= test_case <= 100
// 0 <= clothes_cnt <= 30

#include<iostream>
#include<unordered_map>
#include<string>
#include<vector>

using namespace std;

int main() {
	int test_case = 0;
	cin >> test_case;
	
	vector<int> res;
	
	for(int i = 0; i < test_case; i++) {
		int clothes_cnt = 0;
		cin >> clothes_cnt;
		
		unordered_map<string, int> parts_cnt;
		
		for(int j = 0; j < clothes_cnt; j++) {
			string name, part;
			cin >> name >> part;
			
			parts_cnt[part]++;
		}
		
		int combi_cnt = 1;
		
		for(pair<string, int> part_cnt : parts_cnt) {
			combi_cnt *= part_cnt.second + 1;
		}
		
		res.push_back(combi_cnt - 1);
	}
	
	for(int i : res) {
		cout << i << "\n";
	}
	
	return 0;
}