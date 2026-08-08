import java.util.*;
import java.io.*;

class Solution {
    private static final int TIME_LIMIT = 540;
    
    private static int totalNode;
    private static int dayLimit;
    private static ArrayList<int[]>[] adjList;
    private static int aNode;
    private static Node[] nodes;
    private static int maxScoreSum;
    private static ArrayList<Integer> maxScoreSumPath;
    
    private static class Node {
        char type;
        int time = 0;
        int score = 0;
        boolean visited = false;
        
        public Node(char type) {
            this.type = type;
        }
        
        public Node(char type, int time, int score) {
            this.type = type;
            this.time = time;
            this.score = score;
        }
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            totalNode = Integer.parseInt(st.nextToken());
            dayLimit = Integer.parseInt(st.nextToken());
            
            // 인접 리스트 초기화 - 노드별 거리 저장
            adjList = new ArrayList[totalNode + 1];
            for (int i = 1; i <= totalNode; i++) adjList[i] = new ArrayList<>();
            
            for (int a = 1; a < totalNode; a++) {
                st = new StringTokenizer(br.readLine());
                
                for (int b = a + 1; b <= totalNode; b++) {
                    int time = Integer.parseInt(st.nextToken());
                    adjList[a].add(new int[] {b, time});
                    adjList[b].add(new int[] {a, time});
                }
            }
            
            // 노드 정보 초기화
            nodes = new Node[totalNode + 1];
            for (int i = 1; i <= totalNode; i++) {
                st = new StringTokenizer(br.readLine());
                char type = st.nextToken().charAt(0);

                if (type == 'A' || type == 'H') {
                    if (type == 'A') aNode = i;
                    nodes[i] = new Node(type);
                    continue;
                }
                
                int time = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(type, time, score);
            }
            
            maxScoreSum = 0;
            maxScoreSumPath = null;
            makePermutation(aNode, 0, 0, 1, 0, new ArrayList<>());
            
            sb.append("#").append(t).append(" ").append(maxScoreSum);
            if (maxScoreSum > 0 && maxScoreSumPath != null) {
                for (int node : maxScoreSumPath)
                    sb.append(" ").append(node);
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    // 조건 1: 하루 사용 시간이 TIME_LIMIT 초과 불가
    // 조건 2: 호텔, 공항 제외, 중복 방문 불가
    // 조건 3: 우회 경로 없음 -> 호텔, 공항을 경유지로 쓸 수 없음
    private static void makePermutation(int cur, int dailyTimeSum, int totalTimeSum, int day, int scoreSum, ArrayList<Integer> path) {
        if (day == dayLimit && nodes[cur].type == 'A' && path.size() > 0) {
            if (scoreSum > maxScoreSum) {
                maxScoreSum = scoreSum;
                maxScoreSumPath = new ArrayList<>(path);
            }
            return;
        }
        
        for (int[] nextInfo : adjList[cur]) {
            Node next = nodes[nextInfo[0]];
            boolean isAirport = next.type == 'A';
            boolean isHotel = next.type == 'H';
            
            // 공항은 마지막 날에만 방문
            if (day != dayLimit && isAirport) continue;
            
            boolean isPoint = next.type == 'P';
            int nextTime = isPoint ? nextInfo[1]  + next.time : nextInfo[1];
            int nextDay = isPoint || isAirport ? day : day + 1;
            int nextScoreSum = isPoint ? scoreSum + next.score : scoreSum;
            
            if (next.visited || dailyTimeSum + nextTime > TIME_LIMIT || nextDay > dayLimit) continue;
            if (isPoint && dailyTimeSum + nextTime + getNextToAirportOrHotelMinDis(nextInfo[0], day) > TIME_LIMIT) continue;
            
            int nextDailyTimeSum = isPoint ? dailyTimeSum + nextTime : 0;
            
            if (isPoint) next.visited = true;
            path.add(nextInfo[0]);
            makePermutation(nextInfo[0], nextDailyTimeSum, totalTimeSum + nextTime, nextDay, nextScoreSum, path);
            path.remove(path.size() - 1);
            if (isPoint) next.visited = false;
        }
    }
    private static int getNextToAirportOrHotelMinDis(int cur, int day) {
            int airportDis = 0;
            int minHotelDis = Integer.MAX_VALUE;
            
            for (int[] nextInfo : adjList[cur]) {
                Node next = nodes[nextInfo[0]];
                
                if (next.type == 'A') {
                    airportDis = nextInfo[1];
                } else if (next.type == 'H') {
                    minHotelDis = Math.min(minHotelDis, nextInfo[1]);
                }
            }
            
            return day == dayLimit ? airportDis : minHotelDis;
        }
}