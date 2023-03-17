import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCount = sc.nextInt();
        String numsStr = sc.next();
        String[] numsArr = numsStr.split("");
        int sum = 0;
        
        for(int i = 0; i < numsArr.length; i++) {
            sum += Integer.valueOf(numsArr[i]);
        }
        
        System.out.println(sum);
    }
}