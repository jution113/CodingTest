import java.util.*;
import java.io.*;

class Solution
{
    static final int CARD_COUNT = 9;
    static final int TOTAL_CARD_COUNT = 18;
    
    static List<Integer> myDeck;
    static List<Integer> otherDeck;
    static int winCount;
    static int defeatCount;
    
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] myCardCheck = new boolean[TOTAL_CARD_COUNT + 1];
            myDeck = new ArrayList<> ();
            otherDeck = new ArrayList<> ();
            
            while(st.hasMoreTokens()) myCardCheck[Integer.parseInt(st.nextToken())] = true;
            
            for(int cardNum = 1; cardNum <= TOTAL_CARD_COUNT; cardNum++) {
                if(myCardCheck[cardNum]) {
                    myDeck.add(cardNum);
                } else {
                    otherDeck.add(cardNum);
                }
            }
            
            winCount = 0;
            defeatCount = 0;
            solve(0, new boolean[CARD_COUNT], 0, 0);
            
			System.out.println(String.format("#%d %d %d", tc, winCount, defeatCount));
        }
	}
    
    static void solve(int peekCount, boolean[] cardUseCheck, int mySum, int otherSum) {
        if(peekCount == CARD_COUNT) {
            if(mySum > otherSum) {
                winCount++;
            }  else {
                defeatCount++;
            }
            return;
        }
        
        for(int cardIdx = 0; cardIdx < CARD_COUNT; cardIdx++) {
            if(!cardUseCheck[cardIdx]) {
                int myCardNum = myDeck.get(peekCount);
                int otherCardNum = otherDeck.get(cardIdx);
                int myScore = 0;
                int otherScore = 0;
                if(myCardNum > otherCardNum) {
                    myScore = myCardNum + otherCardNum;
                } else {
                    otherScore = myCardNum + otherCardNum;
                }
                cardUseCheck[cardIdx] = true;
                solve(peekCount + 1, cardUseCheck, mySum + myScore, otherSum + otherScore);
                cardUseCheck[cardIdx] = false;
            }
        }
    }
}