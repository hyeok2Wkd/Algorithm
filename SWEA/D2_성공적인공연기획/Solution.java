package D2_성공적인공연기획;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int [] arr;
	static int now, answer;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		st = new StringTokenizer(br.readLine()," ");
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=T;t++) {
			
			answer = 0;
			now = 0;
			
			String str = br.readLine();
			
			for(int i = 0;i<str.length();i++) {
				
				int person = str.charAt(i) - '0';
				
				if(now >= i) {
					now += person;
				}else {
					// 고용
					answer += i-now;
					
					now += i-now + person;
				}
				
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}//end of testCase
		System.out.println(sb);
	
	}//end of main

}
