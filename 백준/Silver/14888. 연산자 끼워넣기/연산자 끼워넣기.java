import java.util.*;
import java.io.*;

public class Main {
    static long MAX_NUM = Long.MIN_VALUE;
    static long MIN_NUM = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numList = new int[N];
        for(int i = 0; i < N; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        ArrayList<String> operatorList = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            int operatorCnt = Integer.parseInt(st.nextToken());

            for(int j = 0; j < operatorCnt; j++) {
                switch(i) {
                    case 0:
                        operatorList.add("+");
                        break;
                    case 1:
                        operatorList.add("-");
                        break;
                    case 2:
                        operatorList.add("*");
                        break;
                    default:
                        operatorList.add("/");
                }
            }
        }

        boolean[] isVisited = new boolean[operatorList.size()];
        permutation(0, operatorList.size(), operatorList, numList, isVisited, numList[0]);

        System.out.println(MAX_NUM + "\n" + MIN_NUM);
    }

    static void permutation(int curDepth, int maxDepth, ArrayList<String> operatorList, int[] numList, boolean[] isVisited, int sum) {
        if(curDepth == maxDepth) {
            if(sum > MAX_NUM) MAX_NUM = sum;
            if(sum < MIN_NUM) MIN_NUM = sum;
            return;
        }

        for(int i = 0; i < operatorList.size(); i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                int subSum = sum;
                switch(operatorList.get(i)) {
                    case "+":
                        subSum += numList[curDepth + 1];
                        break;
                    case "-":
                        subSum -= numList[curDepth + 1];
                        break;
                    case "*":
                        subSum *= numList[curDepth + 1];
                        break;
                    default:
                        subSum /= numList[curDepth + 1];
                }
                permutation(curDepth + 1, maxDepth, operatorList, numList, isVisited, subSum);
                isVisited[i] = false;
            }
        }

    }
}
