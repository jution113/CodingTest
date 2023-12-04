#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

const int DIR = 4;
const int DIR_Y[] = {1, 0, -1, 0};
const int DIR_X[] = {0, 1, 0, -1};
vector<vector<bool>> map;
vector<vector<bool>> visited;

int yLength;
int xLength;
int squareCnt;
int moveCnt = 0;
vector<int> result;

void dfsR(int y, int x) {
	visited[y][x] = 1;
	moveCnt++;
	
	for(int i = 0; i < DIR; i++) {
		int nextY = y + DIR_Y[i];
		int nextX = x + DIR_X[i];
		
		if(nextY < 0 || yLength <= nextY) continue;
		if(nextX < 0 || xLength <= nextX) continue;
		if(visited[nextY][nextX]) continue;
		if(!map[nextY][nextX]) continue;
		
		dfsR(nextY, nextX);
	}
}

int main() {
	cin >> yLength;
	cin >> xLength;
	cin >> squareCnt;
	
	map.resize(yLength, vector<bool>(xLength, 1));
	visited.resize(yLength, vector<bool>(xLength, 0));
		
	// 사각형 생성 
	for(int i = 0; i < squareCnt; i++) {
		int x1, y1, x2, y2;
		cin >> x1;
		cin >> y1;
		cin >> x2;
		cin >> y2;
		
		// 시작 꼭지점은 칸의 인덱스에 포함 시켜도 되지만, 마지막 꼭지점은 칸읜 인덱스에 포함시키면 안됨 
		for(int y = y1; y < y2; y++) {
			for(int x = x1; x < x2; x++) {
				map[y][x] = 0;
			}
		}
	}
	
	for(int y = 0; y < yLength; y++) {
		for(int x = 0; x < xLength; x++) {
			if(visited[y][x]) continue;
			if(!map[y][x]) continue;
			
			dfsR(y, x);
			result.push_back(moveCnt);
			moveCnt = 0;
		}
	}
	
	
	// 결과 출력 
	cout << result.size() << "\n";
	
	sort(result.begin(), result.end());
	
	for(int i : result) {
		cout << i << " ";
	}
	
	return 0;
}