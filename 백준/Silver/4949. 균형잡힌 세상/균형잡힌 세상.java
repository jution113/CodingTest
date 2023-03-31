import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            String[] strLine = br.readLine().split("");
            if(strLine[0].equals(".")) break;
            
            Stack stack = new Stack(100);
            boolean isStop = false;
            
            for(String str : strLine) {
                if(str.equals("(") || str.equals("[")) {
                    stack.push(str);
                } else if(str.equals(")") || str.equals("]")) {
                    if(stack.pop(str).equals("no")) {
                        isStop = true;
                        break;
                    }
                }
            }
            
            bw.write(stack.isEmpty() && !isStop ? "yes\n" : "no\n");
        }
        
        bw.flush();
        bw.close();

    }
}

class Stack {
    int capacity;
    String[] stack;
    int ptr = 0;
    
    Stack(int capacity) {
        this.capacity = capacity;
        stack = new String[capacity];
    }
    
    void push(String str) {
        if(ptr < capacity) stack[ptr++] = str;
    }
    
    String pop(String str) {
        if(ptr > 0 && stack[ptr - 1].equals("(") && str.equals(")")) {
            return stack[--ptr];
        } else if(ptr > 0 && stack[ptr - 1].equals("[") && str.equals("]")) {
            return stack[--ptr];
        } else {
            return "no";
        }
    }
    
    boolean isEmpty() {
        return ptr == 0;
    }
}