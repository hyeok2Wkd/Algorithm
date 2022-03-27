package P4195_친구네트워크;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static HashMap<String, Integer> hm;
    static int [] parents;
    static int size;
    static int [] countOfFriends;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/P4195_친구네트워크/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("");

        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {

            hm = new HashMap<>();
            parents = new int[200000];
            size=0;
            for (int i = 0; i < 200000; i++) {
                parents[i] = i;
            }
            countOfFriends = new int[200000];


            st = new StringTokenizer(br.readLine());
            int F = Integer.parseInt(st.nextToken());

            for (int f = 0; f < F; f++) {
                st = new StringTokenizer(br.readLine());
                String str1 = st.nextToken();
                String str2 = st.nextToken();

                //각 아이디를 나타내는 인덱스
                int a, b;

                //str1 이미 존재하는 아이디
                if (hm.containsKey(str1)) {
                    a = hm.get(str1);
                } else { //존재하지 않아 아이디 추가
                    countOfFriends[size] = 1;
                    hm.put(str1, size);
                    a = size;
                    size++;
                }

                //str2 이미 존재하는 아이디
                if (hm.containsKey(str2)) {
                    b = hm.get(str2);
                } else {
                    countOfFriends[size] = 1;
                    hm.put(str2, size);
                    b = size;
                    size++;
                }

                int pa = find(a);
                int pb = find(b);
                if(pa != pb){
                    countOfFriends[pa] += countOfFriends[pb];
                    parents[pb] = pa;
                }

                sb.append(countOfFriends[pa] + "\n");


            }
        }

        System.out.println(sb);

    }

    static int find(int node){

        if(parents[node] == node) return node;

        return find(parents[node]);

    }
}
