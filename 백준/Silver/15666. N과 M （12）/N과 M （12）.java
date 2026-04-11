import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static ArrayList<Integer> list;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // 소스의 중복 제거
        st = new StringTokenizer(br.readLine());
        
        HashSet<Integer> set = new HashSet<> ();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        list = new ArrayList<> (set);
        n = list.size();
        
        // 중복이 제거된 리스트 오름차순 정렬
        Collections.sort(list);
        
        sb = new StringBuilder();
        
        // 조합 구하기
        comb(0, 0, new ArrayList<Integer> ());
        
        System.out.println(sb.toString());
    }
    
    private static void comb(int curIdx, int curDepth, ArrayList<Integer> peekList) {
        if (curDepth == m) {
            for (int peek : peekList) {
                sb.append(peek + " ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = curIdx; i < n; i++) {
            peekList.add(list.get(i));
            comb(i, curDepth + 1, peekList);
            peekList.remove(peekList.size() - 1);
        }
    }
}