// int numsSize / 원소의 갯수 저장
// int repeatCount / 구간 합의 범위를 받을 횟수 저장
// int[] nums / 원소 저장
// int[] prefixSum / nums의 원소 누적 저장
// int[] result / 구간 합을 계산한 결과를 담을 배열
// for(numsSize만큼 반복) {
//     nums[]에 원소 할당
//     prefixSum = nums의 현재 원소 + prefixSum의 이전 원소 값
// }
// for(repeatCount만큼 반복) {
//     int startIdx / 시작 인덱스
//     int endIdx / 마지막 인덱스
//     if(startIdx == endIdx) {
//         result[i] = endIdx 출력
//     } else {
//         result[i] = prefixSum[endIdx] - prefixSum[startIdx] 출력
//    }
// }

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numSize = sc.nextInt();
        int repeatCount = sc.nextInt();
        int[] nums = new int[numSize];
        int[] prefixSumArr = new int[numSize];
        int[] result = new int[repeatCount];
        
        for(int i = 0; i < numSize; i++) {
            nums[i] = sc.nextInt();
            prefixSumArr[i] = i > 0 ? prefixSumArr[i - 1] + nums[i] : nums[i];
        }
        
        for(int i = 0; i < repeatCount; i++) {
            int startIdx = sc.nextInt() - 1;
            int endIdx = sc.nextInt() - 1;

            result[i] = startIdx < 1 ? prefixSumArr[endIdx] : prefixSumArr[endIdx] - prefixSumArr[startIdx - 1];
        }
        
        for(int i = 0; i < repeatCount; i++) {
            System.out.println(result[i]);
        }
    }
}