import java.util.*;

class Main {
    public static void main(String[] args) {
        // 1. n개의 수를 받을 배열(numArr)을 만든다.
        // 2. n개의 수를 배열(numArr)에 넣는다.
        // 3. 배열(numArr)를 sort() 메서드를 사용하여 정렬한다.
        // 4. for문을 통해 원소를 0번째 index부터 출력한다.
        
        Scanner sc = new Scanner(System.in);
        int numArrSize = sc.nextInt();
        int[] numArr = new int[numArrSize];
        
        for(int i = 0; i < numArrSize; i++) {
            numArr[i] = sc.nextInt();
        }
        
        Arrays.sort(numArr);
        
        for(int i : numArr) {
            System.out.println(i);
        }
    }
}