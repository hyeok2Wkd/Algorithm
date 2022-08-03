package D2_패턴마디의길이;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t = 1;t<=T;t++) {
			
			String str = br.readLine();
			
			int answer = 0;
			StringBuilder result = new StringBuilder();
			result.append(str.charAt(0));
			
			for(int i = 1;i<str.length();i++) {
				
				if((i+result.length()) <= 30 && str.substring(i, i+result.length()).equals(result.toString())) {
					int start = 0;
					int len = result.length();
					
					int cnt = 0;
					
					while((start+len) <= 30) {
						if(str.substring(start, start+len).equals(result.toString())) {
							cnt++;
							start = start+len;
						}else {
							break;
						}
					}
					
					if(cnt == (30/len)) {
						answer = len;
					}
					
					
				}else {
					result.append(str.charAt(i));
				}
				
				
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}//end of testCase
		System.out.println(sb);
	}//end of main

}
