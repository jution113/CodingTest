import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String B = sc.next();
        int N = sc.nextInt();
        int[] digitNum = new int[B.length()];
        int result = 0;
        
        for(int i = 0; i < B.length(); i++) {
            int askii = (int) B.charAt(i);
            digitNum[i] = askii < 65 ? askii - 48 : askii - 55;
        }
        
        for(int i = 0; i < B.length(); i++) {
            result += digitNum[B.length() - 1 - i] * Math.pow(N, i);
        }
        
        System.out.println(result);
    }
}