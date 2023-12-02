#include<iostream>
#include<string>
#include<queue>
#include<tuple>

using namespace std;

const int START_X = 0;
const int START_Y = 0;
const int IDX_OFFSET = 1;
const int DIR_SZIE = 4;
// 탐색 방향은 북 -> 동 -> 남 -> 서 
const int DIR_X[] = {0, 1, 0, -1};
const int DIR_Y[] = {1, 0, -1, 0};
const int START_LEVEL = 1;

vector<vector<bool>> map;
vector<vector<bool>> visitedMap;

int destX;
int destY;

// queue<level, y, x>
queue<tuple<int, int, int>> que;

void bfs() {
	que.push(make_tuple(START_LEVEL, START_Y, START_X));
	visitedMap[START_Y][START_X] = 1;
	
	while(!que.empty()) {
		tuple<int, int, int> nodeInfo = que.front();
		que.pop();
		int level = get<0>(nodeInfo);
		int y = get<1>(nodeInfo);
		int x = get<2>(nodeInfo);
		
		
		// 이동 방향 탐색 
		for(int i = 0; i < DIR_SZIE; i++) {
			int nextY = y + DIR_Y[i];
			int nextX = x + DIR_X[i];
			
			// 이동 가능 여부 검사 
			if(nextY < 0 || destY < nextY) continue;
			if(nextX < 0 || destX < nextX) continue; 
			if(!map[nextY][nextX]) continue;
			if(visitedMap[nextY][nextX]) continue;
			visitedMap[nextY][nextX] = 1;
			
			// 목적지 도착 검사 
			if(nextY == destY && nextX == destX) {
				cout << level + 1;
				exit(0);
			}
			
			// 이동할 좌표로 queue에 저장 
			que.push(make_tuple(level + 1, nextY, nextX));
		}
	}
	
}

int main() {
	int xSize;
	int ySize;
	
	cin >> ySize;
	cin >> xSize;
	
	destX = xSize - IDX_OFFSET;
	destY = ySize - IDX_OFFSET;
	
	// 버퍼 비우기 
	cin.ignore(); 
	
	// map, visitedMap 생성 
	for(int i = 0; i < ySize; i++) {
		string line;
		getline(cin, line);
		
		vector<bool> mapXLine;
		vector<bool> visitedMapXLine;
		
		for(int j = 0; j < xSize; j++) {
			bool e = line.at(j) - '0';
			mapXLine.push_back(e);
			visitedMapXLine.push_back(0);
		}
		
		map.push_back(mapXLine);
		visitedMap.push_back(visitedMapXLine);
	}
	
	bfs();
	
	return 0;
}