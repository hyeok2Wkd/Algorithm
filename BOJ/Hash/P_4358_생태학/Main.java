package P_4358_생태학;

import java.io.*;
import java.util.*;

class MyString {
    String str;
    int count;

    public MyString(String str) {
        this.str = str;
    }

    /*
    @Override
    public int compareTo(MyString o) {
        return str.compareTo(o.str);
    }

     */
}

public class Main {

    static HashMap<String, Integer> hm;
    static int size;
    static ArrayList<MyString> type;
    static ArrayList<String> list;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/P_4358_생태학/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        hm = new HashMap<>();
        list = new ArrayList<>();
        //strArr = new String[10000];
        type = new ArrayList<>();

        while(true){
            try {
                st = new StringTokenizer(br.readLine());
                StringBuilder sbTemp = new StringBuilder(st.nextToken());
                try {
                    String str2 = st.nextToken();
                    sbTemp.append(" ");
                    sbTemp.append(str2);
                }catch(NoSuchElementException e){
                }
                list.add(sbTemp.toString());
            }catch (NullPointerException e){
                break;
            }
        }



        for(int i = 0;i<list.size();i++){
            String str = list.get(i);
            int index;

            if(hm.containsKey(str)){
                index = hm.get(str);
            }
            else{
                hm.put(str, size);
                index = size;
                type.add(new MyString(str));
                size++;
            }

            type.get(index).count++;
        }

        Collections.sort(type, new Comparator<MyString>() {
            @Override
            public int compare(MyString o1, MyString o2) {
                return o1.str.compareTo(o2.str);
            }
        });

        for(int i = 0;i<size;i++){
            double result = (type.get(i).count/(double)list.size() * 100);
            sb.append(type.get(i).str + " " + String.format("%.4f", result) + "\n");
        }
        System.out.println(sb);
    }

}
