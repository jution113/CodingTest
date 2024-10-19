import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            int result = solve(N, M, 1, N);
            System.out.println(String.format("#%d %d", test_case, result));
		}
	}
    
    static int solve(int n, int pow, int curPow, int result) {
        if(curPow == pow) return result;
        return solve(n, pow, curPow + 1, result * n);
    }
}