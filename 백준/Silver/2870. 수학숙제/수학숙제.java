import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Collections;

public class Main {
    static ArrayList<BigInteger> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            boolean isCollecting = false;

            for(int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if('0' <= c && c <= '9') {
                    if(!isCollecting) isCollecting = true; 
                    sb.append(c);

                    if(j == input.length() - 1 && isCollecting) {
                        result.add(new BigInteger(sb.toString()));
                        sb.setLength(0);
                    }
                } else {
                    if(isCollecting) {
                        isCollecting = false;
                        result.add(new BigInteger(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }
        }

        Collections.sort(result);

        for(BigInteger i : result) System.out.println(i);
    }
}