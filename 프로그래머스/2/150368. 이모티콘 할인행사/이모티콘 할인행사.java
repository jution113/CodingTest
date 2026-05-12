import java.util.*;

class Solution {
    private final int[] discounts = {10, 20, 30, 40};
    
    private int m;
    private int[][] users;
    private int[] emoticons;
    private int maxMember;
    private int maxSale;
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        m = emoticons.length;
        maxMember = 0;
        maxSale = 0;
        
        permutation(0, 0, new int[m]);
        
        return new int[] {maxMember, maxSale};
    }
    
    private void permutation(int start, int peekCnt, int[] peeks) {
        if (peekCnt == m) {
            getMemeberAndSale(peeks);
        }
        
        for (int i = start; i < m; i++) {
            for (int discount : discounts) {
                peeks[i] = discount;
                permutation(i + 1, peekCnt + 1, peeks);
            }
        }
    }
    
    private void getMemeberAndSale(int[] peeks) {
        int member = 0;
        int sale = 0;
        
        for (int[] user : users) {
            int sum = 0;
            
            for (int i = 0; i < m; i++) {
                // 할인 기준 검사
                if (user[0] > peeks[i]) continue;
                sum += ((float) emoticons[i] / 100.0) * (100 - peeks[i]);
                
                // 구매 기준 검사
                if (user[1] <= sum) {
                    member++;
                    sum = 0;
                    break;
                }
            }
            sale += sum;
        }        
        
        // 결과 검사 및 갱신
        if (member >= maxMember) {
            maxSale = member == maxMember ? Math.max(maxSale, sale) : sale;
            maxMember = member;
        }
    }
}