import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int jewelryCnt = Integer.parseInt(st.nextToken());
        int bagCnt = Integer.parseInt(st.nextToken());

        // 보석은 가벼운 것부터 정렬, 만약 무게가 같다면 비싸것이 우선순위를 갖도록 함
        Jewelry[] jewelryArr = new Jewelry[jewelryCnt];

        for(int i = 0; i < jewelryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewelryArr[i] = new Jewelry(weight, value);
        }

        Arrays.sort(jewelryArr, new Comparator<Jewelry> () {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if(o1.weight == o2.weight) {
                    return o1.value > o2.value ? -1 : (o1.value == o2.value ? 0 : 1); // 같거나 크면 비교를 종료하기 때문에 가격이 같을 경우에 대한 조건을 따로 명시하지 않았다.
                }
                return o1.weight > o2.weight ? 1 : -1;
            }
        });

        // 가방은 가벼운 것부터 정렬
        Integer[] bags = new Integer[bagCnt];

        for(int i = 0; i < bagCnt; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int jewelryIdx = 0;
        long totalPrice = 0;

        for(int bagIdx = 0; bagIdx < bagCnt; bagIdx++) {
            while(jewelryIdx < jewelryCnt && jewelryArr[jewelryIdx].weight <= bags[bagIdx]) {
                pq.offer(jewelryArr[jewelryIdx++].value);
            }

            if(!pq.isEmpty()) {
                totalPrice += pq.poll();
            }
        }

        System.out.print(totalPrice);
    }

    static class Jewelry {
        int weight;
        int value;

        public Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}