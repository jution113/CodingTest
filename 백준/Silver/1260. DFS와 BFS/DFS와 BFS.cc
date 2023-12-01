// 1. DFS, BFS 결과 출력
// 2. 방문 가능한 노드가 여러개일 경우 작은 것부터 우선 방문 
// 3. 정점: 1 ~ N

#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>

using namespace std;

vector<vector<int>> adjList;
vector<bool> visitedForDfs;
vector<bool> visitedForBfs;
queue<int> bfsQueue;

int vCnt;
int eCnt;
int start;

const int INDEX_OFFSET = 1;

// dfs 재귀적 구현 
void dfsR(int v) {
	if(visitedForDfs[v]) return;
	cout << v << " ";
	visitedForDfs[v] = 1;
	
	for(int i : adjList[v]) {
		dfsR(i);
	}
}

// bfs
void bfs(int start) {
	bfsQueue.push(start);
	visitedForBfs[start] = 1;
	
	while(!bfsQueue.empty()) {
		int popV = bfsQueue.front();
		bfsQueue.pop();
		cout << popV << " ";
				
		for(int i : adjList[popV]) {
			if(visitedForBfs[i]) continue;
			bfsQueue.push(i);
			visitedForBfs[i] = 1;
		}
	}
}

int main() {
	cin >> vCnt;
	cin >> eCnt;
	cin >> start;
	
	adjList.resize(vCnt + INDEX_OFFSET);
	// 인접행렬 초기화 
	for(int i = 0; i < vCnt + INDEX_OFFSET; i++) {
		vector<int> e;
		adjList.push_back(e);
	}
	
	visitedForDfs.resize(vCnt + INDEX_OFFSET);
	visitedForBfs.resize(vCnt + INDEX_OFFSET);
	
	// 정점별 간선 설정 
	for(int i = 0; i < eCnt; i++) {
		int v1;
		int v2;
		
		cin >> v1;
		cin >> v2;
		
		adjList[v1].push_back(v2);
		adjList[v2].push_back(v1);
	}
	
	// 정점에 저장된 간선 정렬 
	for(vector<int>& i : adjList) {
		sort(i.begin(), i.end());
	}
	
	dfsR(start);
	
	cout << "\n";
	
	bfs(start);
	
	return 0;
}