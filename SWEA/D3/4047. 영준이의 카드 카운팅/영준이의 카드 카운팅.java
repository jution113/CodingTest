import java.util.*;
import java.io.*;

class Solution {
    private static final int CARD_TYPE_CNT = 4;
    private static final int DECK_SIZE = 13;
    
    // 입력 관련
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    
    // 카드 관련
    private static HashSet<Integer>[] cardInfos;
    
	public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        int totalTestCase = Integer.parseInt(br.readLine());
        
		for(int testCase = 1; testCase <= totalTestCase; testCase++) {
            if (!init()) {
                sb.append("#" + testCase + " ERROR\n");
                continue;
            }
            sb.append("#" + testCase);
            for (int i = 0; i < CARD_TYPE_CNT; i++) {
                int requiredCards = DECK_SIZE - cardInfos[i].size();
            	sb.append(" " + requiredCards);
            }
            sb.append("\n");
		}
        
        System.out.print(sb.toString());
	}
    
    private static boolean init() throws IOException {
        cardInfos =  new HashSet[CARD_TYPE_CNT];
        
        for (int i = 0; i < CARD_TYPE_CNT; i++)
            cardInfos[i] = new HashSet<> ();
        
        String cardInfo = br.readLine();
        for (int i = 0; i < cardInfo.length(); i++) {
            int cardTypeIdx = convertCardTypeToInt(cardInfo.charAt(i++));
            int cardNum = 10 * (cardInfo.charAt(i++) - '0') + (cardInfo.charAt(i) - '0');
            
            if (cardInfos[cardTypeIdx].contains(cardNum)) return false;
            cardInfos[cardTypeIdx].add(cardNum);
        }        
        return true;
    }
    
    private static int convertCardTypeToInt(char cardType) {
        switch (cardType) {
            case 'S':
                return 0;
            case 'D':
                return 1;
            case 'H':
                return 2;
        }
        return 3;
    }
}