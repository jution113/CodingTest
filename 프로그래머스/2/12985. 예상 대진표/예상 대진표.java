import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int count = 1;
        if(a % 2 == 1) a++; 
        if(b % 2 == 1) b++; 
        
        while(Math.abs(a - b) > 1) {
            count++;
            a /= 2;
            b /= 2;
            
            if(a % 2 == 1) a++; 
            if(b % 2 == 1) b++; 
        }
        
        return count;
    }
}