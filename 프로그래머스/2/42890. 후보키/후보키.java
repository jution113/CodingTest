import java.util.*;

class Solution {
    private int rowLen;
    private int colLen;
    private ArrayList<ArrayList<Integer>> keyList;
    private HashSet<ArrayList<Integer>> uniqueKeySet;
    private String[][] relation;

    public int solution(String[][] relation) {
        this.relation = relation;
        rowLen = relation.length;
        colLen = relation[0].length;
        uniqueKeySet = new HashSet<> ();

        int minKey = 1;

        while (minKey <= colLen) {
            keyList = new ArrayList<> ();
            comb(0, 0, minKey, new ArrayList<> ());
            validateKey();
            minKey++;
        }

        return uniqueKeySet.size();
    }

    

    private void comb(int start, int depth, int maxDepth, ArrayList<Integer> key) {
        if (depth == maxDepth) {
            keyList.add(new ArrayList<> (key));
            return;
        }

        for (int col = start; col < colLen; col++) {
            key.add(col);
            comb(col + 1, depth + 1, maxDepth, key);
            key.remove(key.size() - 1);
        }
    }

    private void validateKey() {
        outer:
        for (ArrayList<Integer> key : keyList) {
            HashSet<String> keySet = new HashSet<> (); 

            for (int row = 0; row < rowLen; row++) {
                StringBuilder sb = new StringBuilder();
                for (int col : key) sb.append(relation[row][col] + " ");
                if (keySet.contains(sb.toString())) continue outer;
                keySet.add(sb.toString());
            }

            for (ArrayList<Integer> uniqueKey : uniqueKeySet) {
                if (key.containsAll(uniqueKey)) continue outer;
            }
            uniqueKeySet.add(key);
        }
    }
}