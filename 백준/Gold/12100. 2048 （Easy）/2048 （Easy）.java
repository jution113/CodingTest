import java.util.*;
import java.io.*;

public class Main {
    static int MAX = 0;
    static int N = 0;
    static char[] DIR = {'u', 'd', 'r', 'l'};
    static int searchCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        simulate(1, 5, map);

        System.out.println(MAX);
    }

    static int[][] copyMap(int[][] originMap) {
        int[][] copyMap = new int[N][N];

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                copyMap[r][c] = originMap[r][c];
            }
        }

        return copyMap;
    }

    static void simulate(int curDepth, int maxDepth, int[][] map) {
        if(curDepth > maxDepth) return;

        for(char dir : DIR) {
            int[][] mergedMap = move(dir, map);
            simulate(curDepth + 1, maxDepth, mergedMap);
            searchCnt++;
        }
    }

    static int[][] move(char dir, int[][] originMap) {
        int[][] map = copyMap(originMap);

        switch(dir) {
            case 'u':
                // merge block
                for(int c = 0; c < N; c++) {
                    Stack<Integer> mergedNum = new Stack<>();
                    boolean beforeMerged = false;

                    for(int r = 0; r < N; r++) {
                        if(map[r][c] != 0) {
                            int num = map[r][c];
                            map[r][c] = 0;

                            if(mergedNum.isEmpty()) {
                                mergedNum.push(num);
                                continue;
                            }

                            if(!beforeMerged) {
                                if(num == mergedNum.peek()) {
                                    mergedNum.push(mergedNum.pop() * 2);
                                    beforeMerged = true;
                                    continue;
                                }
                            }

                            mergedNum.push(num);
                            beforeMerged = false;
                        }
                    }

                    // move block
                    for(int r = 0; r < mergedNum.size(); r++) {
                        int num = mergedNum.get(r);
                        map[r][c] = num;
                        if(MAX < num) MAX = num;
                    }
                }
                break;

            case 'd':
                // merge block
                for(int c = 0; c < N; c++) {
                    Stack<Integer> mergedNum = new Stack<>();
                    boolean beforeMerged = false;

                    for(int r = N - 1; r >= 0; r--) {
                        if(map[r][c] != 0) {
                            int num = map[r][c];
                            map[r][c] = 0;

                            if(mergedNum.isEmpty()) {
                                mergedNum.push(num);
                                continue;
                            }

                            if(!beforeMerged) {
                                if(num == mergedNum.peek()) {
                                    mergedNum.push(mergedNum.pop() * 2);
                                    beforeMerged = true;
                                    continue;
                                }
                            }

                            mergedNum.push(num);
                            beforeMerged = false;
                        }
                    }

                    // move block
                    for(int r = 0; r < mergedNum.size(); r++) {
                        int num = mergedNum.get(r);
                        map[N - 1 - r][c] = num;
                        if(MAX < num) MAX = num;
                    }
                }
                break;

            case 'r':
                // merge block
                for(int r = 0; r < N; r++) {
                    Stack<Integer> mergedNum = new Stack<>();
                    boolean beforeMerged = false;

                    for(int c = N - 1; c >= 0; c--) {
                        if(map[r][c] != 0) {
                            int num = map[r][c];
                            map[r][c] = 0;

                            if(mergedNum.isEmpty()) {
                                mergedNum.push(num);
                                continue;
                            }

                            if(!beforeMerged) {
                                if(num == mergedNum.peek()) {
                                    mergedNum.push(mergedNum.pop() * 2);
                                    beforeMerged = true;
                                    continue;
                                }
                            }

                            mergedNum.push(num);
                            beforeMerged = false;
                        }
                    }

                    // move block
                    for(int c = 0; c < mergedNum.size(); c++) {
                        int num = mergedNum.get(c);
                        map[r][N - 1 - c] = num;
                        if(MAX < num) MAX = num;
                    }
                }
                break;

            default:
                for(int r = 0; r < N; r++) {
                    Stack<Integer> mergedNum = new Stack<>();
                    boolean beforeMerged = false;

                    for(int c = 0; c < N; c++) {
                        if(map[r][c] != 0) {
                            int num = map[r][c];
                            map[r][c] = 0;

                            if(mergedNum.isEmpty()) {
                                mergedNum.push(num);
                                continue;
                            }

                            if(!beforeMerged) {
                                if(num == mergedNum.peek()) {
                                    mergedNum.push(mergedNum.pop() * 2);
                                    beforeMerged = true;
                                    continue;
                                }
                            }

                            mergedNum.push(num);
                            beforeMerged = false;
                        }
                    }

                    // move block
                    for(int c = 0; c < mergedNum.size(); c++) {
                        int num = mergedNum.get(c);
                        map[r][c] = num;
                        if(MAX < num) MAX = num;
                    }
                }
        }

        return map;
    }

    static void printArr(int[][] originMap){
        for(int c = 0; c < N; c++) {
            System.out.print("- ");
        }
        System.out.println();

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                System.out.print(originMap[r][c] + " ");
            }
            System.out.println();
        }
    }
}
