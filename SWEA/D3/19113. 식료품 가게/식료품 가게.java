import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            
            int N = Integer.parseInt(br.readLine());
            String[] strPriceArr = br.readLine().split(" ");
            
            long[] intPriceArr = new long[N * 2];
            Map<Long, Integer> hashMap = new HashMap<> ();
            
            for(int i = 0; i < strPriceArr.length; i++) {
                long intPrice = Long.parseLong(strPriceArr[i]);
                intPriceArr[i] = intPrice;
                hashMap.put(intPrice, hashMap.getOrDefault(intPrice, 0) + 1);
            }
            
            List<Long> arrayList = new ArrayList<> ();
            
            for(int i = 0; i < intPriceArr.length; i++) {
                long curPrice = intPriceArr[i];
                long salePrice =(curPrice * 75) / 100;
                
                if(curPrice % 4 == 0 && hashMap.get(curPrice) > 0 && hashMap.containsKey(salePrice) && hashMap.get(salePrice) > 0) {
                    hashMap.put(salePrice, hashMap.get(salePrice) - 1);
                    hashMap.put(curPrice, hashMap.get(curPrice) - 1);
                    arrayList.add(salePrice);
                }
            }
            
            Collections.sort(arrayList);
            
            for(Long price : arrayList) sb.append(price).append(" ");            

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}