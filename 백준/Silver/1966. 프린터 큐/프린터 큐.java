import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int targetIndex = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());

            Queue importanceQue = new Queue(size);
            Queue identifierQue = new Queue(size);
            for(int j = 0; j < size; j++) {
                // importanceQue에 중요도 offer
                importanceQue.offer(Integer.parseInt(st.nextToken()));
                // identifierQue의 원소에 대응하는 고유 번호 부여(0 ~ size - 1)
                identifierQue.offer(j);
            }
            
            // 지정한 순서를 확인하려는 문서의 고유 번호
            int targetIdentifier = targetIndex;
            
            // 출력 카운드
            int printCount = 0;
            boolean isChecking = true;
            
            while(isChecking) {
                int importance = importanceQue.poll();
                int identifier = identifierQue.poll();

                if(importanceQue.hasBiggerThan(importance)) {
                    // 현재 중요도보다 높은 중요도의 문서가 queue에 있기 때문에 다시 offer
                    importanceQue.offer(importance);
                    identifierQue.offer(identifier);
                } else {
                    // 현재 출력물보다 높은 중요도가 없음 && 고유 번호 일치
                    if(identifier == targetIdentifier) isChecking = false;
                    printCount++; // 출력
                }
            }
            
            bw.write(printCount + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}

class Queue {
    class EmptyException extends RuntimeException {
        public EmptyException() { }
    }
    
    class OverflowException extends RuntimeException {
        public OverflowException() { }
    }
    
    private int size;
    private int front;
    private int rear;
    private int max;
    private int[] que;
    
    public Queue(int capacity) {
        size = front = rear = 0;
        max = capacity;
        que = new int[capacity];
    }
    
    public int offer(int x) {
        if(size >= max) {
            throw new OverflowException();
        }
        
        que[rear++] = x;
        size++;
        
        if(rear == max) {
            rear = 0;
        }
        
        return x;
    }
    
    public int poll() {
        if(size <= 0) {
            throw new EmptyException();
        }
        
        int x = que[front++];
        size--;
        
        if(front == max) {
            front = 0;
        }
        
        return x;
    }
    
    public int peek() {
        if(size <= 0) throw new EmptyException();
        return que[front];
    }
    
    public boolean hasBiggerThan(int x) {
        boolean isBigger = false;
        
        for(int i = 0; i < size; i++) {
            if(que[(front + i) % max] > x) {
                isBigger = true;
                break;
            }
        }
        
        return isBigger;
    }
    
    public int size() {
        return size;
    }
}