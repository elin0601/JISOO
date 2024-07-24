import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();
        
        // 각 장르별로 총 재생 횟수 계산 및 노래 목록 생성
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
            
            if (!songsByGenre.containsKey(genre)) {
                songsByGenre.put(genre, new ArrayList<>());
            }
            songsByGenre.get(genre).add(new Song(i, play));
        }
        
        // 장르별 총 재생 횟수를 기준으로 장르를 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        Collections.sort(sortedGenres, (a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
        
        List<Integer> bestAlbum = new ArrayList<>();
        
        // 각 장르 내에서 재생 횟수를 기준으로 노래를 정렬하고 최대 두 개까지 선택
        for (String genre : sortedGenres) {
            List<Song> songs = songsByGenre.get(genre);
            Collections.sort(songs, (a, b) -> {
                if (b.play == a.play) {
                    return a.id - b.id;
                } else {
                    return b.play - a.play;
                }
            });
            
            int count = 0;
            for (Song song : songs) {
                if (count >= 2) break;
                bestAlbum.add(song.id);
                count++;
            }
        }
        
        // List<Integer>를 int[]로 변환하여 반환
        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }
    
    class Song {
        int id;
        int play;
        
        Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
}
