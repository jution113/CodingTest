import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[]  input = br.readLine().toCharArray();
        for(char c : input) {
            if(97 <= (int) c && (int) c < 97 + 26) {
                sb.append((char) (c - 32));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
	}
}