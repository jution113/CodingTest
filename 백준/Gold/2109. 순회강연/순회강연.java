import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 0) {
            System.out.println(0);
            System.exit(0);
        }

        ArrayList<Presentation> presentations = new ArrayList<> ();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            presentations.add(new Presentation(p, d));
        }

        // 1. 시간: 오름차순, 2. 보상: 내림차순
        Collections.sort(presentations, new Comparator<Presentation> () {
            @Override
            public int compare(Presentation p1, Presentation p2) {
                if(p1.d == p2.d) return p1.p < p2.p ? 1 : p1.p == p2.p ? 0 : -1;
                return p1.d > p2.d ? 1 : -1;
            }
        });

        // 1. 보상: 오름차순
        PriorityQueue<Presentation> plan = new PriorityQueue<>(new Comparator<Presentation>() {
            @Override
            public int compare(Presentation p1, Presentation p2) {
                return p1.p > p2.p ? 1 : -1;
            }
        });

        Presentation presentation = presentations.get(0);
        plan.offer(presentation);
        int sum = presentation.p;

        for(int i = 1; i < presentations.size(); i++) {
            presentation = presentations.get(i);

            if(presentation.d <= plan.size()) {
                if(plan.peek().p < presentation.p) {
                    sum -= plan.peek().p;
                    plan.poll();
                    plan.offer(presentation);
                    sum += presentation.p;
                }
                continue;
            }

            plan.offer(presentation);
            sum += presentation.p;
        }

        System.out.println(sum);
    }

    static class Presentation {
        int p;
        int d;

        public Presentation(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }
}