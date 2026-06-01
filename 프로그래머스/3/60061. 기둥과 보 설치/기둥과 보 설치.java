import java.util.*;

class Solution {
    private HashSet<ArrayList<Integer>> frameSet;
    
    public int[][] solution(int n, int[][] buildFrames) {
        frameSet = new HashSet<> ();
        
        for (int[] buildFrame : buildFrames) {
            int x = buildFrame[0];
            int y = buildFrame[1];
            int a = buildFrame[2];
            int b = buildFrame[3];
            ArrayList<Integer> frame = new ArrayList<> (Arrays.asList(x, y, a));
            
            if (b == 0) {
                // 제거
                frameSet.remove(frame);
                
                if (a == 0) {
                    // 기둥
                    boolean pillarCheck = true;
                    boolean floorCheck = true;
                    boolean floorCheck2 = true;
                    if (frameSet.contains(new ArrayList<> (Arrays.asList(x, y + 1, 0))))
                        pillarCheck = validatePillar(x, y + 1);
                    if (frameSet.contains(new ArrayList<> (Arrays.asList(x, y + 1, 1))))
                        floorCheck = validateFloor(x, y + 1);
                    if (frameSet.contains(new ArrayList<> (Arrays.asList(x - 1, y + 1, 1)))) 
                        floorCheck2 = validateFloor(x - 1, y + 1);
                    if (!pillarCheck || !floorCheck || !floorCheck2)
                        frameSet.add(frame);
                } else {
                    // 보
                    boolean pillarCheck = true;
                    boolean pillarCheck2 = true;
                    boolean floorCheck = true;
                    boolean floorCheck2 = true;
                    if (frameSet.contains(new ArrayList<> (Arrays.asList(x, y, 0))))
                        pillarCheck = validatePillar(x, y);
                    if (frameSet.contains(new ArrayList<> (Arrays.asList(x + 1, y, 0)))) 
                        pillarCheck2 = validatePillar(x + 1, y);
                    if (frameSet.contains(new ArrayList<> (Arrays.asList(x - 1, y, 1))))
                        floorCheck = validateFloor(x - 1, y);
                    if (frameSet.contains(new ArrayList<> (Arrays.asList(x + 1, y, 1))))
                        floorCheck2 = validateFloor(x + 1, y);
                    if (!pillarCheck || !pillarCheck2 || !floorCheck || !floorCheck2)
                        frameSet.add(frame);
                }
            } else {
                // 설치
                boolean isValidation = a == 0 ? validatePillar(x, y) : validateFloor(x, y);
                if (isValidation) frameSet.add(frame);
            }
        }
        
        int[][] answer = new int[frameSet.size()][3];
        int i = 0;
        for (ArrayList<Integer> frame : frameSet)
            answer[i++] =  new int[] {frame.get(0), frame.get(1), frame.get(2)};
        Arrays.sort(answer, (a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1])
                    return a[2] - b[2];
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        return answer;
    }
    
    private boolean validatePillar(int x, int y) {
        ArrayList<Integer> targetPillar = new ArrayList<> (Arrays.asList(x, y - 1, 0));
        ArrayList<Integer> targetFloor = new ArrayList<> (Arrays.asList(x, y, 1));
        ArrayList<Integer> targetFloor2 = new ArrayList<> (Arrays.asList(x - 1, y, 1));
        
        boolean isOnBase = y == 0;
        boolean isOnPillar = frameSet.contains(targetPillar);
        boolean isOnFloor = frameSet.contains(targetFloor) ||frameSet.contains(targetFloor2);
        
        return isOnBase || isOnPillar || isOnFloor;
    }
    
    private boolean validateFloor(int x, int y) {
        ArrayList<Integer> targetPillar = new ArrayList<> (Arrays.asList(x, y - 1, 0));
        ArrayList<Integer> targetPillar2 = new ArrayList<> (Arrays.asList(x + 1, y - 1, 0));
        ArrayList<Integer> targetFloor = new ArrayList<> (Arrays.asList(x - 1, y, 1));
        ArrayList<Integer> targetFloor2 = new ArrayList<> (Arrays.asList(x + 1, y, 1));
                    
        boolean isOnPillar = frameSet.contains(targetPillar) || frameSet.contains(targetPillar2);
        boolean isConnectedFloor = frameSet.contains(targetFloor) && frameSet.contains(targetFloor2);
        
        return isOnPillar || isConnectedFloor;
    }
}