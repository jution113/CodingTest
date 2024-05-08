import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Test> testArr = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            testArr.add(new Test(t, r));
        }

        // 1. 시간을 오름차순으로, 2. 보상을 내림차순으로
        Collections.sort(testArr, new Comparator<Test>() {
            @Override
            public int compare(Test t1, Test t2) {
                if(t1.time == t2.time) return t1.reward < t2.reward ? 1 : (t1.reward == t2.reward ? 0 : -1);
                return t1.time > t2.time ? 1 : -1;
            }
        });

        PriorityQueue<Test> pq = new PriorityQueue<> (new Comparator<Test> () {
            @Override
            public int compare(Test t1, Test t2) {
                return Integer.compare(t1.reward, t2.reward);
            }
        });

        Test test = testArr.get(0);
        pq.offer(test);
        int deadLine = test.time;
        int sum = test.reward;

        for(int i = 1; i < N; i++) {
            test = testArr.get(i);
            deadLine = test.time;

            if(deadLine > pq.size()) {
                pq.offer(test);
                sum += test.reward;
                continue;
            }

            if(pq.peek().reward < test.reward) {
                sum -= pq.peek().reward;
                pq.poll();
                pq.offer(test);
                sum += test.reward;
            }
        }

        System.out.println(sum);
    }

    static class Test {
        int time;
        int reward;

        public Test(int t, int r) {
            this.time = t;
            this.reward = r;
        }
    }
}
