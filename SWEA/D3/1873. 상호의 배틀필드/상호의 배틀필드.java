// 1. 이동 명령: 위치 변경 -> 평지일 경우 이동
// 2. 벽돌은 파괴 가능, 강철은 불가

import java.util.*;
import java.io.*;

    class Solution
    {
        public static void main(String args[]) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int TC = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int tc = 1; tc <= TC; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int H = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());;
                String[][] map = new String[H][W];
                int y = 0;
                int x = 0;
                for(int h = 0; h < H; h++) {
                    String[] input = br.readLine().split("");
                    for(int w = 0; w < W; w++) {
                        map[h][w] = input[w];
                        if(map[h][w].equals("^") || map[h][w].equals("v") || map[h][w].equals("<") || map[h][w].equals(">")) {
                            y = h;
                            x = w;
                        }
                    }
                }

                int N = Integer.parseInt(br.readLine());
                String[] input = br.readLine().split("");
                for(int n = 0; n < N; n++) {
                    String command = input[n];
                    switch(command) {
                        case "U":
                            if(y - 1 >= 0 && map[y - 1][x].equals(".")) {
                                map[y][x] = ".";
                                y--;
                            }
                            map[y][x] = "^";
                            break;
                        case "D":
                            if(y + 1 < H && map[y + 1][x].equals(".")) {
                                map[y][x] = ".";
                                y++;
                            }
                            map[y][x] = "v";
                            break;
                        case "R":
                            if(x + 1 < W && map[y][x + 1].equals(".")) {
                                map[y][x] = ".";
                                x++;
                            }
                            map[y][x] = ">";
                            break;
                        case "L":
                            if(x - 1 >= 0 && map[y][x - 1].equals(".")) {
                                map[y][x] = ".";
                                x--;
                            }
                            map[y][x] = "<";
                            break;
                        default:
                            int curX = x;
                            int curY = y;
                            int dirX = 0;
                            int dirY = 0;
                            switch(map[y][x]) {
                                case "^":
                                    dirX = 0;
                                    dirY = -1;
                                    break;
                                case "v":
                                    dirX = 0;
                                    dirY = 1;
                                    break;
                                case ">":
                                    dirX = 1;
                                    dirY = 0;
                                    break;
                                default:
                                    dirX = -1;
                                    dirY = 0;
                            }
                            while((0 <= curX && curX < W) && (0 <= curY && curY < H)) {
                                if(map[curY][curX].equals("*")) {
                                    map[curY][curX] = ".";
                                    break;
                                }
                                if(map[curY][curX].equals("#")) break;
                                curX += dirX;
                                curY += dirY;
                            }
                    }
                }

                sb.append("#").append(tc).append(" ");
                for(int h = 0; h < H; h++) {
                    for(int w = 0; w < W; w++) {
                        sb.append(map[h][w]);
                    }
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }
    }