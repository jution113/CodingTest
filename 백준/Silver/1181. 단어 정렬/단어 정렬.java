import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Word> treeSet = new TreeSet<> ();
        for (int i = 0; i < N; i++)
            treeSet.add(new Word(br.readLine()));

        StringBuilder sb = new StringBuilder();
        for (Word word : treeSet)
            sb.append(word.value).append("\n");
        System.out.println(sb);
    }

    public static class Word implements Comparable<Word> {
        String value;
        int length;

        public Word(String value) {
            this.value = value;
            this.length = value.length();
        }

        @Override
        public int compareTo(Word o) {
            if (this.length != o.length) {
                return this.length - o.length;
            } else {
                return this.value.compareTo(o.value);
            }
        }
    }
}
