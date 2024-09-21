import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){ 
        Map<String, String> enrollReferralMap = new HashMap<> ();
        Map<String, Integer> enrollTotalMoneyMap = new HashMap<> ();
        
        for(int i = 0; i < enroll.length; i++) {
            enrollReferralMap.put(enroll[i], referral[i]);
            enrollTotalMoneyMap.put(enroll[i], 0);
        }
        
        for(int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int sales = amount[i] * 100;
            int shareMoney = sales / 10;
            int totalMoney = enrollTotalMoneyMap.getOrDefault(name, 0) + sales - shareMoney;
            enrollTotalMoneyMap.put(name, totalMoney);
            
            while(shareMoney > 0 && !enrollReferralMap.get(name).equals("-")) {
                name = enrollReferralMap.get(name);
                totalMoney = enrollTotalMoneyMap.get(name);
                enrollTotalMoneyMap.put(name, totalMoney + shareMoney - shareMoney / 10);
                shareMoney = shareMoney / 10;
            }
        }

        int[] answer = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++) answer[i] = enrollTotalMoneyMap.get(enroll[i]);
        
        return answer;
    }
}