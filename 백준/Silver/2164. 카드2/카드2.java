import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList();
        
        for(int i = 1; i <= N; i++) {
            que.offer(i);
        }
        
        while(que.size() > 1) {
            que.poll();
            
            int x = que.poll();
            que.offer(x);
        }
        
        System.out.println(que.poll());
    }
}