import java.util.*;
import java.io.*;

public class Main {
    static final String acceptable = "> is acceptable.\n";
    static final String notAcceptable = "> is not acceptable.\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        while(!input.equals("end")) {
            boolean[] vowelList = new boolean[input.length()];
            boolean hasVowel = false;
            boolean isBreak = false;

            for(int i = 0; i < input.length(); i++) {
                vowelList[i] = vowelCheck(input.charAt(i));
                if(!hasVowel) hasVowel = vowelList[i];

                if(i >= 1) {
                    if(duplicationCheck(input.charAt(i), input.charAt(i - 1))) {
                        isBreak = true;
                        break;
                    }

                    if(i >= 2) {
                        if(continuousValueCheck(vowelList, i - 2, i)) {
                            isBreak = true;
                            break;
                        }
                    }
                }
            }

            if(!isBreak && hasVowel) {
                sb.append('<').append(input).append(acceptable);
            } else {
                sb.append('<').append(input).append(notAcceptable);
            }

            input = br.readLine();
        }

        System.out.println(sb);
    }

    static boolean vowelCheck(char input) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for(char vowel : vowels) {
            if(input == vowel) return true;
        }

        return false;

    }

    static boolean duplicationCheck(char input1, char input2) {
        if(input1 != input2) return false;

        char[] exceptions = {'e', 'o'};
        
        for(char exception : exceptions) {
            if(input1 == exception) return false;
        }

        return true;

    }

    static boolean continuousValueCheck(boolean[] values, int startIdx, int endIdx) {
        boolean startValue = values[startIdx];

        for(int i = startIdx; i <= endIdx; i++) {
            if(startValue != values[i]) return false;
        }

        return true;
    }
}