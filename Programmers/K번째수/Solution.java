package K번째수;

import java.util.*;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        ArrayList<Integer> list = new ArrayList();

        for(int idx = 0;idx<commands.length;idx++){

            int start = commands[idx][0];
            int end = commands[idx][1];
            int k = commands[idx][2];
            list.clear();

            for(int i = start;i<=end;i++){
                list.add(array[i-1]);
            }

            Collections.sort(list);
            answer[idx] = list.get(k-1);
        }
        return answer;
    }
}