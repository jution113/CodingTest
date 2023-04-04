import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        Queue queue = new Queue(10_000);        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            String comand = br.readLine();
            st = new StringTokenizer(comand, " ");
            int result = -2;
            
            switch(st.nextToken()) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                    
                case "pop":
                    result = queue.pop();
                    break;
                    
                case "size":
                    result = queue.size();
                    break;
                    
                case "empty":
                    result = queue.empty();
                    break;
                    
                case "front":
                    result = queue.front();
                    break;
                    
                case "back":
                    result = queue.back();
                    break;
            }
            if(result != -2) bw.write(result + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}

class Queue {
    private int front;
    private int rear;
    private int max;
    private int size;
    private int[] queue;
    
    public class OverflowException extends RuntimeException {
        public OverflowException() { }
    }
    
    public class EmptyException extends RuntimeException {
        public EmptyException() { }
    }
    
    public Queue(int capacity) {
        size = front = rear = 0;
        max = capacity;
        queue = new int[capacity];
    }
    
    public void push(int x) throws OverflowException {
        if(size >= max) {
            throw new OverflowException();
        }
        
        queue[rear++] = x;
        size++;
        
        if(rear == max) {
            rear = 0;
        }
    }
    
    public int pop() throws EmptyException {
        if(size <= 0) {
            return -1;
        }
        
        int x = queue[front++];
        size--;

        if(front == max) {
            front = 0;
        }
        
        return x;
    }
    
    public int size() {
        return size;
    }
    
    public int empty() {
        if(size <= 0) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public int front() {
        if(size <= 0) {
            return -1;
        } else {
            return queue[front];
        }
    }
    
    public int back() {
        if(size <= 0) {
            return -1;
        } else {
            return queue[rear - 1];
        }
    }
}