import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Long> genrePlaySumMap = new HashMap<> ();
        HashMap<String, PriorityQueue<Music>> musicMap = new HashMap<> ();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            long sum = 0;
            PriorityQueue<Music> pq = new PriorityQueue<> ();
            
            if (genrePlaySumMap.containsKey(genre)) {
                sum = genrePlaySumMap.get(genre);
                pq = musicMap.get(genre);
            }
            sum += play;
            pq.offer(new Music(i, play));
            genrePlaySumMap.put(genre, sum);
            musicMap.put(genre, pq);
        }
        
        PriorityQueue<Genre> genrePq = new PriorityQueue<> ();
        for (Map.Entry entrySet : genrePlaySumMap.entrySet()) {
            genrePq.offer(new Genre((String) entrySet.getKey(), (long) entrySet.getValue()));
        }
        
        ArrayList<Integer> answerList = new ArrayList<> ();
        while (!genrePq.isEmpty()) {
            Genre genre = genrePq.poll();
            PriorityQueue<Music> musicPq = musicMap.get(genre.name);
            
            int pollCnt = 0;
            while (!musicPq.isEmpty() && pollCnt < 2) {
                answerList.add(musicPq.poll().idx);
                pollCnt++;
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    static class Genre implements Comparable<Genre> {
        String name;
        long playSum;
        
        public Genre(String name, long playSum) {
            this.name = name;
            this.playSum = playSum;
        }
        
        @Override
        public int compareTo(Genre other) {
            if (other.playSum > this.playSum)
                return 1;
            return -1;
        }
        
    }
    
    static class Music implements Comparable<Music> {
        int idx;
        int play;
        
        public Music(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music other) {
            if (this.play == other.play)
                return this.idx - other.idx;
            return other.play - this.play;
        }
    }
}