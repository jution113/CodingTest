import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 조회수를 담을 맵
        Map<String, Integer> genreWithPlayMap = new HashMap<> ();
        // 음악별 정보를 담을 리스트
        List<SongInfo> songInfoList = new ArrayList<> ();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 장르별 조회수 저장 및 업데이트
            if(genreWithPlayMap.containsKey(genre)) {
                genreWithPlayMap.put(genre, genreWithPlayMap.get(genre) + play);
            } else {
                genreWithPlayMap.put(genre, play);
            }
            
            // 음악별 정보 저장
            songInfoList.add(new SongInfo(i, play, genre));
        }
        
        // 장르별 조회수 내림차순 정렬
        String[] genreSortedByPlay = genreWithPlayMap.entrySet().stream()
            .sorted((g1, g2) -> Integer.compare(g2.getValue(), g1.getValue()))
            .map(g -> g.getKey())
            .toArray(size -> new String[size]);
        
        // 음악별 아이디를 담을 리스트
        List<Integer> answer = new ArrayList<> ();
        
        for(String genre : genreSortedByPlay) {
            SongInfo[] songInfoArrSortedByPlay = songInfoList.stream()
                .filter(s -> s.genre.equals(genre))
                .sorted((s1, s2) -> {
                    if(s1.play == s2.play) return Integer.compare(s1.id, s2.id);
                    return Integer.compare(s2.play, s1.play);
                })
                .toArray(size -> new SongInfo[size]);
            
            // 장르별 조회수가 가장 높은 음악 리스트에 추가
            answer.add(songInfoArrSortedByPlay[0].id);
            
            // 차순위 조회수의 음악이 존재한다면, 장르별 차순위 조회수 음악 리스트에 추가
            if(songInfoArrSortedByPlay.length >= 2) answer.add(songInfoArrSortedByPlay[1].id);
        }
        
        // 리스트를 배열로 변환하여 반환
        return answer.stream()
            .mapToInt(i -> i.intValue())
            .toArray();
    }
    
    public static class SongInfo {
        int id;
        int play;
        String genre;
        
        public SongInfo(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }
    }
}