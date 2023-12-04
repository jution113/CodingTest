#include<iostream>
#include<vector>

using namespace std;

const int DIR_CNT = 4;
const int DIR_Y[] = {1, 0, -1, 0};
const int DIR_X[] = {0, 1, 0, -1};

vector<vector<bool>> map;
vector<vector<bool>> visited;

int xLength;
int yLength;

void dfsR(int y, int x) {
	visited[y][x] = 1;
	
	for(int i = 0; i < DIR_CNT; i++) {
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
	int test;
	
	cin >> test;
	
	vector<int> result(test, 0); 
	
	for(int t = 0; t < test; t++) {
		int target;
		
		cin >> xLength;
		cin >> yLength;
		cin >> target;
		
		map.clear();
		map.resize(yLength, vector<bool>(xLength, 0));
		
		visited.clear();
		visited.resize(yLength, vector<bool>(xLength, 0));
		
		for(int i = 0; i < target; i++) {
			int x;
			int y;
			
			cin >> x;
			cin >> y;
		
			map[y][x] = 1;
		}
	
		for(int y = 0; y < yLength; y++) {
			for(int x = 0; x < xLength; x++) {
				if(visited[y][x]) continue;
				if(!map[y][x]) continue;
			
				result[t]++;
				dfsR(y, x);
			}
		}
	}
	
	for(int i : result) {
		cout << i << "\n";
	}

	return 0;
}