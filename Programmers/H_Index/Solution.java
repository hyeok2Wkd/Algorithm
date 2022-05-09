package H_Index;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        //인용횟수별 논문 개수
        int []countOfCitations = new int[10001];

        for(int i = 0;i<citations.length;i++){
            countOfCitations[citations[i]]++;
        }

        int H = 0;

        for(int i = 10000;i>=0;i--){
            H += countOfCitations[i];
            if(i <= H){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
