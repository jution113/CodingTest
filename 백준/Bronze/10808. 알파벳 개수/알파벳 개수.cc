#include<iostream>
#include<vector>

using namespace std;


int main() {
    // 입력 부분
    string str;
    cin >> str;

    // 문자열 -> 문자 백터
    vector<char> chars(str.begin(), str.end());

    // 결과를 담을 백터
    int result[26];

    // 배열 초기화
    for(int & i : result) {
        i = 0;
    }


    for(char c : chars) {
        // a = 97
        result[c - 97]++;
    }

    for(int i : result) {
        cout << i << " ";
    }

    return 0;
}