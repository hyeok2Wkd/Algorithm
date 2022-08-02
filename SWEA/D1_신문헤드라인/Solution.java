package D1_신문헤드라인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int [] endDay = {0,31,28,31,30,31,30,31,31,30,31,30,31};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		String input = st.nextToken();
		
		int diff = 'a' - 'A';
		
		for(int i = 0;i<input.length();i++) {
			char alpha = input.charAt(i);
			
			if(alpha >= 'a' && alpha <= 'z') {
				alpha -= diff;
			}
			
			sb.append(alpha);
			
		}
		
		System.out.println(sb);
		
		
	}

}
