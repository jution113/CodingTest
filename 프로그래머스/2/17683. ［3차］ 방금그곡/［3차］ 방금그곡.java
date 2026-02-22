class Solution {
    public String solution(String melody, String[] musicInfos) {
        String answer = "(None)";
        melody = replaceProcess(melody);
        int maxPlayTime = Integer.MIN_VALUE;
        
        for (int i = 0; i < musicInfos.length; i++) {
            String[] musicInfo = musicInfos[i].split(",");
            int playTime = getMusicPlayTime(musicInfo[0], musicInfo[1]);
            String name = musicInfo[2];
            String music = replaceProcess(musicInfo[3]);
            String fullMusic = makeFullMusic(playTime, music);
            
            if (fullMusic.contains(melody) && playTime > maxPlayTime) {
                maxPlayTime = playTime;
                answer = name;
            }
        }
        
        return answer;
    }
    
    private int getMusicPlayTime(String start, String end) {
        String[] startArr = start.split(":");
        String[] endArr = end.split(":");
        
        int startTime = Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]);
        int endTime = Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1]);
        return endTime - startTime;
    }
    
    private String replaceProcess(String str) {
        str = str.replaceAll("C#", "c");
        str = str.replaceAll("D#", "d");
        str = str.replaceAll("F#", "f");
        str = str.replaceAll("G#", "g");
        str = str.replaceAll("A#", "a");
        str = str.replaceAll("E#", "e");
        str = str.replaceAll("B#", "b");
        
        return str;
    }
    
    private String makeFullMusic(int playTime, String music) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < playTime; i++) {
            sb.append(music.charAt(i % music.length()));
        }
        
        return sb.toString();
    }
}