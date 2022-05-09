package 모의고사;

import java.util.*;

public class Solution {

    static int [] firstPerson = {1,2,3,4,5};
    static int [] secondPerson = {2,1,2,3,2,4,2,5};
    static int [] thirdPerson = {3,3,1,1,2,2,4,4,5,5};

    public int[] solution(int[] answers) {
        int [] correctCnt = new int[3];

        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = 0;

        for(int i = 0;i<answers.length;i++){

            int correct = answers[i];

            if(firstPerson[firstIdx] == correct){
                correctCnt[0]++;
            }

            firstIdx++;
            if(firstIdx >= firstPerson.length)
                firstIdx = 0;

            if(secondPerson[secondIdx] == correct){
                correctCnt[1]++;
            }

            secondIdx++;
            if(secondIdx >= secondPerson.length)
                secondIdx = 0;


            if(thirdPerson[thirdIdx] == correct){
                correctCnt[2]++;
            }

            thirdIdx++;
            if(thirdIdx >= thirdPerson.length)
                thirdIdx = 0;


        }


        //get max
        int max = 0;
        for(int i = 0;i<3;i++){
            if(max < correctCnt[i]){
                max = correctCnt[i];
            }
        }

        ArrayList<Integer> arr = new ArrayList();

        for(int i = 0;i<3;i++){
            if(max == correctCnt[i]){
                arr.add(i+1);
            }
        }


        int [] answer = new int[arr.size()];

        for(int i = 0;i<answer.length;i++){
            answer[i] = arr.get(i);
        }

        return answer;
    }
}