import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack stack = new Stack(100_000);
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        System.out.println(stack.sum());
        //bw.write();
        //bw.flush();
        //bw.close();
        
    }
}

class Stack {
    private int capacity;
    private int[] stack;
    private int ptr = 0;
        
    Stack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }
    
    void push(int x) {
        stack[ptr++] = x;
    }
    
    void pop() {
        if(ptr > 0) ptr--;
    }
    
    int sum() {
        int result = 0;
        
        for(int i = 0; i < ptr; i++) {
            result += stack[i]; 
        }
        
        return result;
    }
}