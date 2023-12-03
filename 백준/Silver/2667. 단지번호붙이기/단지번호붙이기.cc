#include<iostream>
#include<vector>
#include<algorithm>
#include<string>

using namespace std;

const int DIR_CNT = 4;
const int DIR_Y[] = {1, 0, -1, 0};
const int DIR_X[] = {0, 1, 0, -1};

int mapSize;
int moveCnt = 0;
vector<vector<bool>> map;
vector<vector<bool>> visited;
vector<int> results;

void dfsR(int y, int x) {
	visited[y][x] = 1;
	moveCnt++;
	
	for(int dirCnt = 0; dirCnt < DIR_CNT; dirCnt++) {
		int nextY = y + DIR_Y[dirCnt];
		int nextX = x + DIR_X[dirCnt];
		
		if(nextY < 0 || mapSize <= nextY) continue;
		if(nextX < 0 || mapSize <= nextX) continue;
		if(!map[nextY][nextX]) continue;
		if(visited[nextY][nextX]) continue;
		
		dfsR(nextY, nextX);
	}
}

int main() {
	// map, visited 생성 
	cin >> mapSize;
	
	visited.resize(mapSize, vector<bool>(mapSize, 0));
	
	// 버퍼 비우기 
	cin.ignore();
	
	for(int inputCnt = 0; inputCnt < mapSize; inputCnt++) {
		string line;
		getline(cin, line);
		
		vector<bool> row;
		
		for(int rowElementIdx = 0; rowElementIdx < mapSize; rowElementIdx++) {
			row.push_back(line.at(rowElementIdx) - '0');
		}
		
		map.push_back(row);
		
	}
	
	for(int y = 0; y < mapSize; y++) {
		for(int x = 0; x < mapSize; x++) {
			if(!map[y][x]) continue;
			if(visited[y][x]) continue;
			
			dfsR(y, x);
			
			results.push_back(moveCnt);
			moveCnt = 0;
		}
	}
	
	// 오름차순으로 정렬 
	sort(results.begin(), results.end());
	
	// 결과 출력 
	cout << results.size() << "\n";
	
	for(int e : results) {
		cout << e << "\n";
	}
	
	return 0;
}