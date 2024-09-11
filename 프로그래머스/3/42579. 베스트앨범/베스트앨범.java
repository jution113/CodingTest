import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 두번째 버전
        // 장르별 조회수
        Map<String, Integer> genrePlayInfo = new HashMap<> ();
        // 장르별 곡의 고유 번호와 조회수
        Map<String, List<Integer[]>> musicInfoByGenre = new HashMap<> ();

        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            if(!genrePlayInfo.containsKey(genre)) {
                genrePlayInfo.put(genre, 0);
                musicInfoByGenre.put(genre, new ArrayList<> ());
            }

            genrePlayInfo.put(genre, genrePlayInfo.get(genre) + play);
            musicInfoByGenre.get(genre).add(new Integer[] {i, play});
        }

        List<String> genreSortedByPlay =  genrePlayInfo.entrySet().stream()
                .sorted((entrySet1, entrySet2) -> Integer.compare(entrySet2.getValue(), entrySet1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<> ();

        genreSortedByPlay.stream()
                .forEach(genre -> {
                    musicInfoByGenre.get(genre).stream()
                            .sorted((musicInfo1, musicInfo2) -> Integer.compare(musicInfo2[1], musicInfo1[1]))
                            .limit(2)
                            .forEach(music -> answer.add(music[0]));
                });

        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}