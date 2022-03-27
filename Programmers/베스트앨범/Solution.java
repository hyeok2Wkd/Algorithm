package 베스트앨범;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Sing implements  Comparable<Sing>{

    int singNum;
    int playCount;

    public Sing(int singNum, int playCount) {
        this.singNum = singNum;
        this.playCount = playCount;
    }

    @Override
    public int compareTo(Sing o) {
        return Integer.compare(o.playCount, playCount);
    }
}

class Genres implements Comparable<Genres>{
    int genresNum;
    int totalPlayCount;

    public Genres(int genresNum, int totalPlayCount) {
        this.genresNum = genresNum;
        this.totalPlayCount = totalPlayCount;
    }

    @Override
    public int compareTo(Genres o) {
        return Integer.compare(o.totalPlayCount, totalPlayCount);
    }
}


public class Solution {

    static HashMap<String, Integer> hm;
    static ArrayList<ArrayList<Sing>> singList;
    static ArrayList<Genres> genresList;
    static int size;

    public int[] solution(String[] genres, int[] plays) {

        int length = genres.length;

        size = 0;
        genresList = new ArrayList();
        singList = new ArrayList<>();
        hm = new HashMap<>();

        for(int i = 0;i<length;i++){

            String str = genres[i];

            //이미 있는 장르
            if(hm.containsKey(str)){
                int index = hm.get(str);
                genresList.get(index).totalPlayCount += plays[i];
                singList.get(index).add(new Sing(i, plays[i]));
            }
            else{

                hm.put(str, size);
                genresList.add(new Genres(size, plays[i]));
                singList.add(new ArrayList());
                singList.get(size).add(new Sing(i, plays[i]));
                size++;
            }
        }

        Collections.sort(genresList);
        for(int i = 0;i<singList.size();i++){
            Collections.sort(singList.get(i));
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0;i<genresList.size();i++){

            int count = 0;
            int genresNum = genresList.get(i).genresNum;

            for(Sing sing : singList.get(genresNum)){
                result.add(sing.singNum);
                count++;
                if(count == 2)
                    break;
            }

        }

        int[] answer = new int[result.size()];

        for(int i = 0;i<answer.length;i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String [] genres = {"classic", "pop", "classic", "classic", "pop"};
        int [] plays = {500, 600, 150, 800, 2500};
        int [] result = s.solution(genres,plays);

        for(int i = 0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }
}
