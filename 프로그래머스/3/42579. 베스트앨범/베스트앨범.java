import java.util.*;

class Solution {
    private int LIMIT = 2;
    
    private class Genre {
        String name;
        int playSum = 0;
        
        public Genre(String name, int play) {
            this.name = name;
            this.playSum += play;
        }
    }
    
    private class Music {
        int num;
        int play;
        
        public Music(int num, int play) {
            this.num = num;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playByGenre = new HashMap<> ();
        HashMap<String, PriorityQueue<Music>> musicsByGenre = new HashMap<> ();
                
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            playByGenre.put(genre, playByGenre.getOrDefault(genre, 0) + play);
            
            if (!musicsByGenre.containsKey(genre)) {
                // 재생 횟수가 같을 경우 고유 번호가 낮은 순서로 음악 정렬
                // 재생 횟수가 높은 순서로 음악 정렬
                musicsByGenre.put(genre, new PriorityQueue<> ((Music m, Music m2) -> {
                    if (m.play == m2.play) return Integer.compare(m.num, m2.num);
                    return Integer.compare(m2.play, m.play);
                }));
            }
            
            musicsByGenre.get(genre).offer(new Music(i, play));
        }
        
        // 총 재생 횟수가 높은 순서로 장르를 정렬
        PriorityQueue<Genre> sortedGenresByPlay = new PriorityQueue<> ((Genre g, Genre g2) -> {
            return Integer.compare(g2.playSum, g.playSum);
        });
        
        for (Map.Entry<String, Integer> entrySet : playByGenre.entrySet()) {
            sortedGenresByPlay.offer(new Genre(entrySet.getKey(), entrySet.getValue()));
        }
        
        ArrayList<Integer> answer = new ArrayList<> ();
        
        while (!sortedGenresByPlay.isEmpty()) {
            Genre sortedGenre = sortedGenresByPlay.poll();
            
            PriorityQueue<Music> musics = musicsByGenre.get(sortedGenre.name);
            
            int i = 0;
            while (i < LIMIT && !musics.isEmpty()) {
                answer.add(musics.poll().num);
                i++;
            }
        }
        
        return listToArray(answer);
    }
    
    private int[] listToArray(ArrayList<Integer> arrayList) {
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        
        return array;
    }
    
}