package D3_의석이의세로로말해요;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static String [] strArr;
	static List<Character> result;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		st = new StringTokenizer(br.readLine()," ");
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=T;t++) {
			
			strArr = new String[5];
			result = new ArrayList();
			
			int maxLen = 0;
			
			for(int i= 0;i<5;i++) {
				strArr[i] = br.readLine();
				maxLen = Math.max(maxLen, strArr[i].length());
			}
			
			int idx = 0;
			
			while(idx < maxLen) {
				
				for(int i = 0;i<5;i++) {
					
					if(idx >= strArr[i].length()) continue;
					
					result.add(strArr[i].charAt(idx));
					
				}
				
				idx++;
			}
			
			sb.append("#").append(t).append(" ");
			
			for(int i = 0;i<result.size();i++) {
				
				sb.append(result.get(i));
				
			}
			
			sb.append("\n");
			
			
		}//end of testCase
		System.out.println(sb);
	
	}//end of main

}
