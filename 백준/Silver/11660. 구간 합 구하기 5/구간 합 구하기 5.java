// int squareSize 선언 후 N의 크기를 입력 받는다.
// int repeatCount 선언 후 M의 크기를 입력 받는다.
// squareSize * squareSize 크기의 int[][] square 선언한다.
// squareSize * squareSize 크기의 int[][] prefixSumSquare 선언한다.
//
// for(squareSize만큼 반복 row) {
//     for(squareSize만큼 반복 col) {
//        square[row][col] = 입력값 
//     }
// }
// 
// prefixSumSquare[0][0] = square[0][0];
// 
// for(squareSize만큼 반복 row) {
//     for(squareSize만큼 반복 col) {
//         if(row == 0 && col > 0) {
//             prefixSumSquare[0][col] = prefixSumSquare[0][col - 1] + square[0][col];
//             prefixSumSquare[col][0] = prefixSumSquare[col - 1][0] + square[col][0];
//         }
//         
//         if(col > 0) prefixSumSquare[row][col] = prefixSumSquare[row - 1][col] + prefixSumSquare[row][col - 1] - prefixSumSquare[row - 1][col -1] + square[row][col];
//     }
// }
// 
// for(repeatCount만큼 반복) {
//     int x1 선언 후 입력 값을 할당.
//     int y1 선언 후 입력 값을 할당.
//     int x2 선언 후 입력 값을 할당.
//     int y2 선언 후 입력 값을 할당.
//     
//     int result 선언 후 prefixSumSquare[x2][y2] - prefixSumSquare[x1 - 1][y2] - prefixSumSquare[y1 - 1][x2] + prefixSumSquare[x1 - 1][y1 - 1]의 값 할당
//     result 출력
// }

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int tileSize = sc.nextInt();
        int repeatCount = sc.nextInt();
        int[][] tile = new int[tileSize + 1][tileSize + 1];
        int[][] prefixSumTile = new int[tileSize + 1][tileSize + 1];
        
        for(int row = 1; row <= tileSize; row++) {
            for(int col = 1; col <= tileSize; col++) {
                tile[row][col] = sc.nextInt();
            }
        }
        
        for(int row = 1; row <= tileSize; row++) {
            for(int col = 1; col <= tileSize; col++) {
                prefixSumTile[row][col] = prefixSumTile[row - 1][col] + prefixSumTile[row][col - 1] - prefixSumTile[row - 1][col - 1] + tile[row][col];
            }
        }
        
        for(int repeat = 0; repeat < repeatCount; repeat++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int result = prefixSumTile[x2][y2] - prefixSumTile[x1 - 1][y2] - prefixSumTile[x2][y1 - 1] + prefixSumTile[x1 - 1][y1 - 1];
             
            System.out.println(result);
        }
        
    }
}