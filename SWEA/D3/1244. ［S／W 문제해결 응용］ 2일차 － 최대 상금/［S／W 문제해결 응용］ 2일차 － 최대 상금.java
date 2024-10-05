import java.util.*;
import java.io.*;

public class Solution {
    static int max;
    static ArrayList<Integer> sortedList = new ArrayList<> ();
    static int maxNum;
    static boolean isDuplicated;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            String[] input = br.readLine().split(" ");
            List<Integer> numList = new ArrayList<> ();
            Map<Integer, Integer> numDuplicationMap = new HashMap<> ();
            for(String s : input[0].split("")) {
                int num = Integer.parseInt(s);
                numList.add(num);
                numDuplicationMap.put(num, numDuplicationMap.getOrDefault(num, 0) + 1);
            }
            sortedList = new ArrayList<> (numList);
            Collections.sort(sortedList, Collections.reverseOrder());
            maxNum = makeNum(sortedList);
            isDuplicated = numDuplicationMap.values().stream().anyMatch(num -> num >= 2);
            int swapCount = Integer.parseInt(input[1]);

            max = 0;
            makeCombination(numList, 0, numList.size(), swapCount);
            sb.append(max).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void makeCombination(List<Integer> numList, int start, int n, int swapCount) {
        if(swapCount == 0) {
            max = Math.max(makeNum(numList), max);
            return;
        }

        // 정렬된 값과 같을 때
        if(maxNum == makeNum(numList)) {
            if(swapCount % 2 == 1 && !isDuplicated) {
                swap(numList, n - 1, n - 2); // 교환
                max = Math.max(makeNum(numList), max);
                swap(numList, n - 1, n - 2); // 원복
            } else {
                max = Math.max(makeNum(numList), max);
            }
            return;
        }

        for(int i = start; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                swap(numList, i, j); // 교환
                makeCombination(numList, i + 1, n, swapCount - 1);
                swap(numList, i, j); // 원복
            }
        }
    }

    static void swap(List<Integer> numList, int a, int b) {
        int tmp = numList.get(a);
        numList.set(a, numList.get(b));
        numList.set(b, tmp);
    }

    static int makeNum(List<Integer> numList) {
        StringBuilder sb = new StringBuilder();
        for(int num : numList) sb.append(num);
        return Integer.parseInt(sb.toString());
    }
}