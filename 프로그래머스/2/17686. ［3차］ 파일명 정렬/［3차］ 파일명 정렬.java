import java.util.*;

class Solution {
    static int pt;
    
    public String[] solution(String[] files) {
        List<String> answer = new ArrayList<> ();
        List<FileInfo> pl = new ArrayList<> ();
        
        for (String file : files) {
            pt = 0;
            String head = getHead(file);
            int number = getNumber(file);
            
            pl.add(new FileInfo(file, head, number));
        }
        
        Collections.sort(pl);
        for (FileInfo f : pl) {
            answer.add(f.name);
        }
        
        return answer.toArray(new String[0]);
    }
    
    private String getHead(String file) {
        String lowerCaseFile = file.toLowerCase();
        
        while (pt < lowerCaseFile.length()) {
            char c = lowerCaseFile.charAt(pt);
            
            if ((c >= 'a' && c <= 'z') || c == ' ' || c == '-' || c == '.')
                pt++;
            else
                break;
        }
        
        return lowerCaseFile.substring(0, pt);
    }
    
    private int getNumber(String file) {
        String lowerCaseFile = file.toLowerCase();
        int number = 0;
        int maxDigit = 5;
        int digitCnt = 0;
        char c = '0';
        
        while (pt < lowerCaseFile.length() && digitCnt < maxDigit) {
            c = lowerCaseFile.charAt(pt);
            
            if (c >= '0' && c <= '9') {
                number *= 10;
                number += c - '0';
                pt++;
                digitCnt++;
            } else
                break;
        }
        
        return number;
    }
    
    private static class FileInfo implements Comparable<FileInfo> {
        String name;
        String head;
        int number;
        
        public FileInfo(String name, String head, int number) {
            this.name = name;
            this.head = head;
            this.number = number;
        }
        
        @Override
        public int compareTo(FileInfo other) {
            int compareRes= this.head.compareTo(other.head);
            
            if (compareRes != 0) {
                return compareRes;
            } else {
                return this.number - other.number;
            }
        }
    }
}