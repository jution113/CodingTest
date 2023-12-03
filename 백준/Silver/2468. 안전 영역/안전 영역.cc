// N(2 <= N <= 100)
// level(1 <= level <= 100)

#include<iostream>
#include<vector>

using namespace std;

// 탐색 방향 순서: 북, 동, 남, 서 
const int DIR_CNT = 4;
const int DIR_Y[] = {1, 0, -1, 0};
const int DIR_X[] = {0, 1, 0, -1};
const int MIN_LEVEL = 1;
const int MAX_LEVEL = 100;

int mapSize;
int maxLevel = MIN_LEVEL;
int minLevel = MAX_LEVEL;
vector<int> safeAreas;
vector<vector<int>> map;

void dfsR(vector<vector<bool>>& visited, int y, int x, int level) {
	visited[y][x] = 1;
	
	for(int i = 0; i < DIR_CNT; i++) {
		int nextX = x + DIR_X[i];
		int nextY = y + DIR_Y[i];
		
		if(nextX < 0 || mapSize <= nextX) continue;
		if(nextY < 0 || mapSize <= nextY) continue;
		if(map[nextY][nextX] <= level) continue;
		if(visited[nextY][nextX]) continue;
		
		dfsR(visited, nextY, nextX, level);
	}
}

int main() {
	
	cin >> mapSize;
	
	// 맵 생성 
	for(int i = 0; i < mapSize; i++) {
		vector<int> row;
		
		for(int j = 0; j < mapSize; j++) {
			int level;
			cin >> level;
			row.push_back(level); 
			
			maxLevel = maxLevel > level ? maxLevel : level;
			minLevel = minLevel < level ? minLevel : level;
		}
		
		map.push_back(row);
	}
	
	// 모든 높이가 동일한 경우 안전 영역은 1개 
	if(maxLevel == minLevel) {
		cout << 1;
		exit(0);
	}
	 
	safeAreas.resize(maxLevel);
	
	// 모든 타일을 방문 
	for(int level = minLevel; level <= maxLevel; level++) {
		vector<vector<bool>> visited(mapSize, vector<bool>(mapSize, 0)); 
		
		for(int y = 0; y < mapSize; y++) {
			for(int x = 0; x < mapSize; x++) {
				if(map[y][x] <= level) continue;
				if(visited[y][x]) continue;
				safeAreas[level]++;
				dfsR(visited, y, x, level);
			}
		}
	}
	
	int max = 0;
	
	for(int i : safeAreas) {
		max = i > max ? i : max;
	}
	
	cout << max;
	
	return 0;
}