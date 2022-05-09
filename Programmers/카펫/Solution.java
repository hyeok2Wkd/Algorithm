package 카펫;

class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        //init
        int bTop = (brown-2)/2 - 2;
        int bSide = 1;
        int y = bTop;

        while(true){

            if(y == yellow) {
                answer[0] = bTop+2;
                answer[1] = bSide + 2;
                break;
            }

            bTop--;
            y = y - bSide;
            y += bTop;
            bSide++;

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int brown = 24;
        int yellow = 24;

        int [] answer = s.solution(brown, yellow);
        System.out.println(answer[0] + " "+ answer[1]);
    }
}
