import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Cow> pq = new PriorityQueue<> (new Comparator<Cow> () {
            @Override
            public int compare(Cow c1, Cow c2) {
                return Integer.compare(c1.at, c2.at);
            }
        });


        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new Cow(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        int t = 0;
        
        while(!pq.isEmpty()) {
            Cow cow = pq.poll();
            if(cow.at > t) t = cow.at;
            t += cow.nt;
        }

        System.out.println(t);
    }

    static class Cow {
        int at;
        int nt;

        public Cow(int at, int nt) {
            this.at = at;
            this.nt = nt;
        }
    }
}
