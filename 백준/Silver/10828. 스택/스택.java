import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        IntStack stack = new IntStack(10000);
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            switch(st.nextToken()) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                    
                case "pop":
                    bw.write(stack.pop() + "\n");
                    break;
                    
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                    
                case "empty":
                    bw.write(stack.empty() + "\n");
                    break;
                    
                case "top":
                    bw.write(stack.top() + "\n");
                    break;
            }
        }
        
        bw.flush();
        bw.close();
    }
}

class IntStack {
    int ptr = 0;
    int max;
    int[] stack;
    
    IntStack(int max) {
        stack = new int[max];
    }
    
    void push(int x) {
        stack[ptr++] = x;
    }
        
    int pop() {
        if(ptr <= 0) return -1;
        return stack[--ptr];
    }
        
    int size() {
        return ptr;
    }
        
    int empty() {
        return ptr <= 0 ? 1 : 0;
    }
        
    int top() {
        return ptr <= 0 ? -1 : stack[ptr - 1];
    }
}