package 위장;

import java.util.HashMap;

class Solution {

    static int size;
    static int answer;
    static int[] countOfClothes;

    public int solution(String[][] clothes) {
        size = 0;

        HashMap<String, Integer> hm = new HashMap<>();
        countOfClothes = new int[30];
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];

            //이미 하나 이상 가지고 있는 옷
            if (hm.containsKey(type)) {
                int idx = hm.get(type);
                countOfClothes[idx]++;
            }
            //첫 옷의 종류
            else {
                hm.put(type, size);
                countOfClothes[size] = 1;
                size++;
            }

        }

        // 옷의쌍 계산
        for (int i = 0; i < size; i++) {
            DFS(i, 1, countOfClothes[i]);
        }


        return answer;
    }

    static void DFS(int idx, int visitedCount, int nowClothesCount) {

        //1. 체크인
        answer += nowClothesCount;
        //2. 목적지니?
        //3. 순회
        for (int i = idx + 1; i < size; i++) {
            //4. 갈수있니?
            //5. 간다
            DFS(i, visitedCount + 1, nowClothesCount * countOfClothes[i]);
        }

        //6. 체크아웃

    }
}
