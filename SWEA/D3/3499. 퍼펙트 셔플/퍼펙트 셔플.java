import java.util.*;
import java.io.*;

class Solution {
    // 입력
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    // 카드
    private static int n;
    private static String[] deck;
    private static String[] shuffledDeck;
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        int totalTestCase = Integer.parseInt(br.readLine());
        
		for(int testCase = 1; testCase <= totalTestCase; testCase++) {
            init();
            sb.append("#" + testCase);
            shuffle();
            for (String card : shuffledDeck) sb.append(" " + card);
            sb.append("\n");
		}
        System.out.println(sb.toString());
	}
    
    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        deck = new String[n];
        for (int i = 0; i < n; i++) {
            deck[i] = st.nextToken();
        }
        
        shuffledDeck = new String[n];
    }
    
    private static void shuffle() {
        int up = 0;
        int down = n % 2 == 0 ? n / 2 : n / 2 + 1;
        
        for (int i = 0; i < n; i++)
            shuffledDeck[i] = i % 2 == 0 ? deck[up++] : deck[down++];
    }
}