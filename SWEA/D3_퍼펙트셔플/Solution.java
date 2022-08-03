package D3_퍼펙트셔플;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int T,N;
	static List<String> strList;
	static List<String> resultList;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t = 1;t<=T;t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			
			strList = new ArrayList<>();
			resultList = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine()," ");
			
			for(int i = 0;i<N;i++) {
				strList.add(st.nextToken());
			}
			
			int left = 0;
			int right = (int)((N / 2.0) + 0.5);
			
			while(true) {
				
				resultList.add(strList.get(left++));
				resultList.add(strList.get(right++));

				if(right >= N) break;
				
			}
			
			//홀수라면
			if(N % 2 == 1) {
				resultList.add(strList.get(left));
			}
			
			sb.append("#").append(t).append(" ");
			
			for(int i = 0;i<resultList.size();i++) {
				sb.append(resultList.get(i) + " ");
			}
			sb.append("\n");
			
		}//end of testCase
		System.out.println(sb);
	}//end of main

}
