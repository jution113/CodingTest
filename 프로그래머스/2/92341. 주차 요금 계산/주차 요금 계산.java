import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingTimeMap = new HashMap<> ();
        Map<String, String> enterTimeMap = new HashMap<> ();
        List<String> orderedCarList = new ArrayList<> ();
        
        for (String record : records) {
            String[] recordInfo = record.split(" ");
            String time = recordInfo[0];
            String car = recordInfo[1];
            
            if (parkingTimeMap.containsKey(car)) {
                if (enterTimeMap.containsKey(car)) {
                    int parkingTime = getTime(enterTimeMap.get(car), time);
                    parkingTimeMap.put(car, parkingTimeMap.get(car) + parkingTime);
                    enterTimeMap.remove(car);
                } else {
                    enterTimeMap.put(car, time);
                }
            } else {
                parkingTimeMap.put(car, 0);
                enterTimeMap.put(car, time);
                orderedCarList.add(car);
            }
        }
        
        for (Map.Entry entry : enterTimeMap.entrySet()) {
            String car = (String) entry.getKey();
            int parkingTime = getTime((String) entry.getValue(), "23:59");
            
            parkingTimeMap.put(car, parkingTimeMap.get(car) + parkingTime);
            
        }
        
        int[] answer = new int[orderedCarList.size()];
        Collections.sort(orderedCarList);
        for (int i = 0; i < answer.length; i++) {
            String car = orderedCarList.get(i);
            int time =  parkingTimeMap.get(car);
            answer[i] = getFee(time, fees);
        }
        
        return answer;
    }
    
    private int getFee(int time, int[] fees) {
        int fee = fees[1];
        
        if (time > fees[0]) {
            time -= fees[0];
            fee += (int) Math.ceil((double) time / fees[2]) * fees[3];
        }
        
        return fee;
    }
    
    private int getTime(String in, String out) {
        String[] inArr = in.split(":");
        String[] outArr = out.split(":");
        
        int inToMin = strToInt(inArr[0]) * 60 + strToInt(inArr[1]);
        int outToMin = strToInt(outArr[0]) * 60 + strToInt(outArr[1]);
        
        return outToMin - inToMin;
    }
    
    private int strToInt(String str) {
        int num = 0;
        
        for (int i = 0; i < str.length(); i++) {
            num *= 10;
            num += (str.charAt(i) - '0');
        }
        
        return num;
    }
}