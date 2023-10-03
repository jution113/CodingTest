#include<iostream>
#include<vector>
#include<algorithm>
#include<numeric>

using namespace std;

bool isFind;

void combination(int startIdx, vector<int> srcV, vector<int>& resultV) { // 시작 인덱스, 소스 vector
    // 9c7의 합이 100이라면 출력
    if(isFind) return;

    if(resultV.size() == 7) {
        // 현재 조합의 합이 100이라면 종료 조건을 활성화 시킨다.
        int sum = accumulate(resultV.begin(), resultV.end(), 0);
        if(sum == 100) isFind = true;
        return;
    }

    for(int i = startIdx + 1; i < 9; i++) {
        resultV.push_back(srcV[i]);
        combination(i, srcV, resultV);
        if(isFind) return;
        resultV.pop_back();
    }
}

int main() {
    // 9 난쟁이를 담을 백터
    vector<int> src;

    // 7 난쟁이를 담을 백터
    vector<int> result;

    // 9번 입력 받아 src에 저장
    for(int i = 0; i < 9; i++) {
        int input;
        cin >> input;
        src.push_back(input);
    }

    // 9 난쟁이 오름차순 정렬
    sort(src.begin(), src.end());

    // 조합 시작
    combination(-1, src, result);

    // 최종 결과 출력
    for(int i : result) {
        cout << i << "\n";
    }

    return 0;
}