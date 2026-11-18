import java.util.*;
import java.io.*;

class Solution {
    private static final int MEM_SIZE = 15;

    // 방향 관련
    private static final int DIR_CNT = 4;
    private static final int[] DIR_Y = {-1, 0, 1, 0};
    private static final int[] DIR_X = {0, 1, 0, -1};

    // 입출력 관련
    private static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    // 명령어 관련
    private static int commandLineCnt;
    private static int commandLineLen;
    private static String[] commandLines;
    private static ArrayDeque<int[]> que = new ArrayDeque<>();
    private static int[][][] visited;

    public static void main(String args[]) throws Exception {
        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
            init();
            String answer = executeProgram() ? "YES" : "NO";
            sb.append("#" + testCase + " " + answer + "\n");
        }

        System.out.print(sb.toString());
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        commandLineCnt = Integer.parseInt(st.nextToken());
        commandLineLen = Integer.parseInt(st.nextToken());

        commandLines = new String[commandLineCnt];
        for (int i = 0; i < commandLineCnt; i++)
            commandLines[i] = br.readLine();

        que.clear();
        visited = new int[commandLineCnt][commandLineLen][DIR_CNT];
    }

    private static boolean executeProgram() {
        que.offer(new int[] {0, 0, 1, 0});
        visited[0][0][1] |= (1 << 0);

        while (!que.isEmpty()) {
            int[] curInfo = que.poll();
            int y = curInfo[0];
            int x = curInfo[1];
            int dir = curInfo[2];
            int mem = curInfo[3];
            char command = commandLines[y].charAt(x);

            switch (command) {
                case '@':
                    return true;

                case '<':
                case '>':
                case '^':
                case 'v':
                    dir = parseDir(command);
                    y = calculateNextY(y, dir);
                    x = calculateNextX(x, dir);
                    if ((visited[y][x][dir] & (1 << mem)) > 0) continue;
        			visited[y][x][dir] |= (1 << mem);
                    que.offer(new int[] {y, x, dir, mem});
                    break;
                case '_':
                case '|':
                    if (command == '_')
                        dir = mem == 0 ? 1 : 3;
                    else
                        dir = mem == 0 ? 2 : 0;
                    y = calculateNextY(y, dir);
                    x = calculateNextX(x, dir);
                    if ((visited[y][x][dir] & (1 << mem)) > 0) continue;
        			visited[y][x][dir] |= (1 << mem);
                    que.offer(new int[] {y, x, dir, mem});
                    break;
                case '?':
                    for (int i = 0; i < DIR_CNT; i++) {
                        dir = i;
                        int nextY = calculateNextY(y, dir);
                        int nextX = calculateNextX(x, dir);
                        if ((visited[nextY][nextX][dir] & (1 << mem)) > 0) continue;
        				visited[nextY][nextX][dir] |= (1 << mem);
                        que.offer(new int[] {nextY, nextX, dir, mem});
                    }
                    break;
                default:
                    if (command == '+')
                        mem = mem + 1 > MEM_SIZE ? 0 : mem + 1;
                    else if (command == '-')
                        mem = mem - 1 < 0 ? 15 : mem - 1;
                    else if ('0' <= command & command <= '9')
                        mem = command - '0';
                    y = calculateNextY(y, dir);
                    x = calculateNextX(x, dir);
                    if ((visited[y][x][dir] & (1 << mem)) > 0) continue;
        			visited[y][x][dir] |= (1 << mem);
                    que.offer(new int[] {y, x, dir, mem});
            }
        }
        return false;
    }

    private static int calculateNextY(int y, int dir) {
        y += DIR_Y[dir];
        if (y >= commandLineCnt) {
            y = 0;
        } else if (y < 0) {
            y = commandLineCnt - 1;
        }
        return y;
    }

    private static int calculateNextX(int x, int dir) {
        x += DIR_X[dir];
        if (x >= commandLineLen) {
            x = 0;
        } else if (x < 0) {
            x = commandLineLen - 1;
        }
        return x;
    }

    private static int parseDir(char dir) {
        switch (dir) {
            case '<':
                return 3;
            case '>':
                return 1;
            case '^':
                return 0;
        }
        return 2;
    }
}