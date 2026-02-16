import java.util.*;

class Solution {
    static HashMap<String, Integer> cntByCourse;
    static HashMap<Integer, Integer> maxCntByCourseLength;
    
    public String[] solution(String[] orders, int[] courseLengths) {
        cntByCourse = new HashMap<> ();
        maxCntByCourseLength = new HashMap<> ();
        
        for (int courseLength : courseLengths) {
            maxCntByCourseLength.put(courseLength, 0);
        }
        
        for (String order : orders) {
            char[] charArr = order.toCharArray();
            Arrays.sort(charArr);
            dfs(0, 0, courseLengths[courseLengths.length - 1], new String(charArr), "");
        }
        
        ArrayList<String> courseList = new ArrayList<> ();
        for (Map.Entry entrySet : cntByCourse.entrySet()) {
            String course = (String) entrySet.getKey();
            int length = course.length();
            int cnt = (int) entrySet.getValue();
            
            if (cnt >= 2 && cnt == maxCntByCourseLength.get(length)) {
                courseList.add(course);
            }
        }
        
        Collections.sort(courseList);
        
        return listToArr(courseList);
    }
    
    private void dfs(int start, int courseLength, int maxCourseLength, String order, String course) {
        if (courseLength > maxCourseLength) {
            return ;
        }
        if (isTargetCourseLength(courseLength)) {
            cntByCourse.put(course, cntByCourse.getOrDefault(course, 0) + 1);
            maxCntByCourseLength.put(courseLength, Math.max(maxCntByCourseLength.get(courseLength), cntByCourse.get(course)));
        }
        for (int i = start; i < order.length(); i++) {
            dfs(i + 1, courseLength + 1, maxCourseLength, order, course + order.charAt(i));
        }
    }
    
    private boolean isTargetCourseLength(int courseLength) {
        return maxCntByCourseLength.containsKey(courseLength);
    }
    
    private String[] listToArr(ArrayList<String> list) {
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}