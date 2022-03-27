package 전화번호목록;

import java.util.*;

class MyString implements Comparable<MyString>{
    String str;

    public MyString(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        MyString myString = (MyString) o;
        boolean result = true;

        int size = Math.min(str.length(), myString.str.length());
        for(int i = 0;i<size;i++){
            if(str.charAt(i) != myString.str.charAt(i)){
                result = false;
                break;
            }
        }
        return result;
        /*
        if(str.length() > myString.str.length()){
            String temp = str.substring(0, myString.str.length());
            return temp.equals(myString.str);
        }
        else{
            String temp = myString.str.substring(0, str.length());
            return temp.equals(str);
        }

         */

    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public int compareTo(MyString o) {
        return str.compareTo(o.str);
    }
}


class Solution {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<MyString> hs = new HashSet<>();

        for(int i = 0;i< phone_book.length;i++){
            String str = phone_book[i];
            MyString myStr = new MyString(str);

            if(hs.contains(myStr)){
                answer = false;
                break;
            }

            hs.add(myStr);

        }


        return answer;
    }
}