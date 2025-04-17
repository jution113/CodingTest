import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] alphabetArr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int alphabetCnt = 0;

        for (String alphabet : alphabetArr) {
            alphabetCnt += (word.length() - word.replaceAll(alphabet, "").length()) / alphabet.length();
            word = word.replaceAll(alphabet, " ");
        }

        word = word.replaceAll(" ", "");

        System.out.println(word.length() + alphabetCnt);
    }
}
