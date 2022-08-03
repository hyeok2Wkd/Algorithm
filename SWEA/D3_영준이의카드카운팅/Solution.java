package D3_영준이의카드카운팅;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static String s;
	static int [][] cntOfCard;
	static boolean isError;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t = 1;t<=T;t++) {
			
			s = br.readLine();
			cntOfCard = new int[4][14];
			isError = false;
			
			for(int i = 0 ;i<s.length();i+=3) {
				
				char ch = s.charAt(i);
				int num = Integer.parseInt(s.substring(i+1,i+1+2));
				
				switch (ch) {
				case 'S':
					if(cntOfCard[0][num] >= 1) isError = true;
					cntOfCard[0][num]++;
					break;
				case 'D':
					if(cntOfCard[1][num] >= 1) isError = true;
					cntOfCard[1][num]++;
					break;
				case 'H':
					if(cntOfCard[2][num] >= 1) isError = true;
					cntOfCard[2][num]++;
					break;
				case 'C':
					if(cntOfCard[3][num] >= 1) isError = true;
					cntOfCard[3][num]++;
					break;
				}
				
				if(isError) break;
				
			}
			
			sb.append("#").append(t).append(" ");
			
			if(isError) {
				sb.append("ERROR\n");
			}else {
				
				for(int i = 0;i<4;i++) {
					int cnt = 0;
					for(int j = 1;j<=13;j++) {
						if(cntOfCard[i][j] == 0) cnt++;
					}
					sb.append(cnt +" ");
				}
				sb.append("\n");
			}
			
			
			
		}//end of testCase
		System.out.println(sb);
	}//end of main

}
