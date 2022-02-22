package Lv2;

import java.util.*;

class Pair {
    String uid;
    char type; //Enter or Leave

    public Pair(String uid, char type) {
        this.uid = uid;
        this.type = type;
    }
}



public class 오픈채팅방 {

    public static void main(String[] args) {

        String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String [] answer = solution(record);

        for(int i = 0;i<answer.length;i++){
            System.out.println(answer[i]);
        }

    }

    static String[] solution(String[] record) {
        String[] answer = {};
        List<Pair> list = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();


        int len = 0;
        for (int i = 0; i < record.length; i++) {

            StringTokenizer st = new StringTokenizer(record[i]);
            String type = st.nextToken();
            String uid = st.nextToken();

            //입장
            if (type.equals("Enter")) {
                hm.put(uid, st.nextToken());
                list.add(new Pair(uid, 'E'));
            }
            //퇴장
            else if (type.equals("Leave")) {
                list.add(new Pair(uid, 'L'));
            }
            //변경
            else {
                hm.put(uid, st.nextToken());
            }
        }


        answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);

            String name = hm.get(p.uid);

            //입장
            if (p.type == 'E') {
                answer[i] = name+"님이 들어왔습니다.";
            }
            //퇴장
            else if (p.type == 'L') {
                answer[i] = name+"님이 나갔습니다.";
            }

        }


        return answer;
    }

}
