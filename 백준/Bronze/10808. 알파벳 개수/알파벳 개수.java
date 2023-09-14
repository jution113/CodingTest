import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 소문자로 이루어진 단어 s
        String s = sc.nextLine();
        
        int[] result = new int[26];
        
        // 문자열의 문자를 순회하며 a=0 ~ z=26으로 설정된 배열에 문자 개수 저장
        for(int i=0; i<s.length(); i++) {
            // 'a'의 아스키 코드는 97
            // s[i]가 'a'라면 int('a')-97 -> 97-97 -> 0번째 인덱스
            result[(int)s.charAt(i) - 97] += 1;
        }
        
        // 출력
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
        
    }
}