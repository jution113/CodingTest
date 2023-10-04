#include<iostream>
using namespace std;

int main() {
	string input;
	cin >> input;
	
	int len = input.size();
	int center = len / 2;
	
	for(int i = 0; i < center; i++) {
		if(input.at(i) != input.at(len - i - 1)) {
			cout << 0;
			return 0;
		}
	}
	
	cout << 1;
	return 0;
}