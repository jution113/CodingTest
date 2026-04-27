import java.util.*;

class Solution {
    private ArrayList<String> operators;
    private LinkedList<String> arr;
    private long maxAbs;
    
    
    public long solution(String expression) {
        arr = new LinkedList<> ();
        
        parsing(expression);
        
        maxAbs = 0;
        perm(0, 0, new ArrayList<> (), new boolean[operators.size()]);
        
        return maxAbs;
    }
    
    private void parsing(String expression) {
        HashSet<String> set = new HashSet<> ();
        
        for (int i = 0; i < expression.length(); i++) {
            String str = expression.substring(i, i + 1);
            
            if (isOperator(str)) {
                set.add(str);
                arr.add(str);
                continue;
            }

            StringBuilder sb = new StringBuilder();
            while (i < expression.length() && !isOperator(str)) {
                sb.append(str);
                i++;
                if (i == expression.length()) break;
                str = expression.substring(i, i + 1);
            }
            
            arr.add(sb.toString());
            i--;
        }
        
        operators = new ArrayList<> (set);
    }

    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*");
    }
    
    private void perm(int start, int depth, ArrayList<String> peeks, boolean[] visit) {
        if (depth == operators.size()) {
            maxAbs = Math.max(maxAbs, getMaxAbs(peeks));
            return;
        }
        
        for (int i = 0; i < operators.size(); i++) {
            if (visit[i]) continue;
            
            peeks.add(operators.get(i));
            visit[i] = true;
            perm(start + 1, depth + 1, peeks, visit);
            peeks.remove(peeks.size() - 1);
            visit[i] = false;
        }
    }
    
    private long getMaxAbs(ArrayList<String> peeks) {
        LinkedList<String> copiedArr = new LinkedList<> (arr);
        
        for (String operator : peeks) {
            for (int i = 0; i < copiedArr.size(); i++) {
                if (operator.equals(copiedArr.get(i))) {
                    long sum = 0;
                    long a = Long.parseLong(copiedArr.get(i - 1));
                    long b = Long.parseLong(copiedArr.get(i + 1));
                    
                    switch (operator) {
                        case "+":
                            sum = a + b;
                            break;
                        case "-":
                            sum = a - b;
                            break;
                        default:
                            sum = a * b;
                    }
                    
                    copiedArr.set(i, String.valueOf(sum));
                    copiedArr.remove(i + 1);
                    copiedArr.remove(i - 1);
                    
                    i = 0;
                }
            }
        }
        
        return Math.abs(Long.parseLong(copiedArr.get(0)));
    }
}