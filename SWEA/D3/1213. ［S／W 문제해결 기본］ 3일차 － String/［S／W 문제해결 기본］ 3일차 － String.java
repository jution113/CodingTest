// 1. 특정 문자열 삭제
// 2. (문자열 삭제 전의 길이 - 문자열 삭제 후 길이) / 특정 문자열 길이 

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = 0; tc < 10; tc++) {
            int TC = Integer.parseInt(br.readLine());
            String input1 = br.readLine();
            String input2 = br.readLine();
            String modifided =  input2.replaceAll(input1, "");
            int result = (input2.length() - modifided.length()) / input1.length();
            System.out.println(String.format("#%d %d", TC, result));
        }
	}
}