import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        HashSet<Integer> setA = new HashSet<> ();
        HashSet<Integer> setB = new HashSet<> ();
        ArrayList<Integer> uniqueListA = new ArrayList<> ();
        ArrayList<Integer> uniqueListB = new ArrayList<> ();
        
        int n = arrayA.length;
        
        for (int i = 0; i < n; i++) {
            int a = arrayA[i];
            int b = arrayB[i];
            if (!setA.contains(a)) {
                setA.add(a);
                uniqueListA.add(a);
            }
            if (!setB.contains(b)) {
                setB.add(b);
                uniqueListB.add(b);
            }
        }
        
        int gcdA = getGcd(uniqueListA);
        int gcdB = getGcd(uniqueListB);
        
        int answer = 0;
        for (int dA = 1; dA <= Math.sqrt(gcdA); dA++) {
            if (gcdA % dA != 0)
                continue;
            if (conditionCheck(dA, uniqueListB)) {
                answer = Math.max(answer, dA);
            }
            if (conditionCheck(gcdA / dA, uniqueListB)) {
                answer = Math.max(answer, gcdA / dA);
            }
        }
        
        for (int dB = 1; dB <= Math.sqrt(gcdB); dB++) {
            if (gcdB % dB != 0)
                continue;
            if (conditionCheck(dB, uniqueListA)) {
                answer = Math.max(answer, dB);
            }
            if (conditionCheck(gcdB / dB, uniqueListA)) {
                answer = Math.max(answer, gcdB / dB);
            }
        }
        
        return answer;
    }
    
    private static boolean conditionCheck(int n, ArrayList<Integer> targetList) {
        for (int target : targetList) {
            if (target % n == 0)
                return false;
        }
        return true;
    }
    
    private static int getGcd(ArrayList<Integer> uniqueList) {
        if (uniqueList.size() == 1)
            return uniqueList.get(0);
        
        int gcd = getGcd(uniqueList.get(0), uniqueList.get(1));
        if (gcd == 1)
            return 1;
        
        for (int i = 2; i < uniqueList.size() - 1; i++) {
            gcd = getGcd(gcd, uniqueList.get(i));
            if (gcd == 1)
                return 1;
        }
        
        return gcd;
    }
    
    private static int getGcd(int n, int n2) {
        int b = Math.max(n, n2);
        int s = Math.min(n, n2);
        
        while (b % s != 0) {
            int tmp = s;
            s = b % s;
            b = tmp;
        }
        
        return s;
    }
}