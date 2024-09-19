import java.util.*;

class Solution {
    static Map<String, Integer> hashMap = new HashMap<> ();
    
    public String[] solution(String[] orders, int[] course) {
        Set<String> hashSet = new HashSet<> ();
        
        for(int c : course) {
            for(String o : orders) {
                String[] sortedOrder = o.split("");
                Arrays.sort(sortedOrder);
            
                int n = sortedOrder.length;
                if(c > n) continue;
                
                makeCombination(sortedOrder, new StringBuilder(), 0, n, c);
            }
            
            Optional<Integer> optionalMax = hashMap.values().stream()
                    .max((v1, v2) -> Integer.compare(v1, v2));
                
                int max = optionalMax.isPresent() ? optionalMax.get() : 0;
                
                if(max >= 2) hashMap.entrySet().stream()
                    .filter(entrySet -> entrySet.getValue() == max)
                    .forEach(entrySet -> hashSet.add(entrySet.getKey()));
            
            hashMap.clear();
        }
        
        return hashSet.stream()
            .sorted()
            .toArray(String[]::new);
    }
    
    static void makeCombination(String[] arr, StringBuilder sb, int start, int n, int r) {
        if(r == 0) {
            String key = sb.toString();
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            return;
        }
        
        for(int i = start; i < n; i++) {
            sb.append(arr[i]);
            makeCombination(arr, sb, i + 1, n, r - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}