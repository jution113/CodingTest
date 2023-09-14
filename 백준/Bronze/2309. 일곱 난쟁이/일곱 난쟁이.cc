#include<iostream>
#include<vector>
#include<algorithm>
#include<numeric>

using namespace std;

int maxCase = 7;

// 7 난쟁이 키를 담을 백터
vector<int> result;

bool isFindResult;

void combi(int startIdx, vector<int> src) {
    if(result.size() == maxCase) {
        if(accumulate(result.begin(), result.end(), 0) == 100) {
            isFindResult = true;
        }
        return;
    }

    for(int i = startIdx + 1; i < src.size(); i++) {
        result.push_back(src[i]);
        combi(i, src);
        if(isFindResult) return;
        result.pop_back();
    }
}

int main() {
    // 9 난쟁이 키 입력 후 오름차순 정렬
    vector<int> inputs;

    for(int i = 0; i < 9; i++) {
        int input;
        cin >> input;
        inputs.push_back(input);
    }

    sort(inputs.begin(), inputs.end());

    combi(-1, inputs);

    for(int i : result) {
        cout << i << "\n";
    }

    return 0;
}