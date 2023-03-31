import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            Stack stack = new Stack(50);
            String[] strArr = br.readLine().split("");
            boolean isStop = false;
            
            for(String str : strArr) {
                if(str.equals("(")) {
                    stack.push("(");
                } else {
                    if(stack.pop().equals("-1")) {
                        isStop = true;
                        break;
                    }
                }
            }
            
            bw.write(stack.isEmpty() && !isStop ? "YES\n" : "NO\n");
            
        }
        
        bw.flush();
        bw.close();

    }
}

class Stack {
    private int capacity;
    private String[] stack;
    private int ptr = 0;
    
    Stack(int capacity) {
        this.capacity = capacity;
        stack = new String[capacity];
    }
    
    void push(String str) {
        stack[ptr++] = str;
    }
    
    String pop() {
        if(ptr <= 0) return "-1";
        return stack[--ptr];
    }
    
    boolean isEmpty() {
        return ptr == 0;
    }
}