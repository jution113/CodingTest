import java.util.*;

class Main {
    public static void main(String args[]) {
        // 1. 과목의 수를 담을 int형 변수 nums를 선언 후 담는다.
        // 2. 과목의 점수를 담을 배열형 변수 subjectScore[]를 선언한다.
        // 3. nums만큼 반복하며 시험 점수를 subjectScore[]에 담는다.
        // 4. 최댓값을 담을 변수 double형 변수 max를 선언한 뒤 subjectScore[]에 값을 담을 때 값을 비교하여 max에 최댓값을 저장한다.
        // 5. 과목의 총합을 담을 double형 변수 sum을 선언한다.
        // 6. nums만큼 반복하며 subjectScore[]의 원소 / max * 100의 값을 sum에 더한다.
        // 7. sum / nums의 값을 반환한다.
        
        Scanner sc = new Scanner(System.in);
        int numsOfSubject = sc.nextInt();
        double max = 0;
        double sum = 0;
        int[] subjectScores = new int[numsOfSubject];
            
        for(int i = 0; i < numsOfSubject; i++) {
            int score = sc.nextInt();
            subjectScores[i] = score;
            max = max < score ? score : max;
        }
        
        for(int score : subjectScores) {
            sum += score / max * 100;
        }
        
        System.out.println(sum / numsOfSubject);
    }
}