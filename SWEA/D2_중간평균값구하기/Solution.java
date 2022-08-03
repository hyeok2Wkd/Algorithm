package D2_중간평균값구하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int [] arr;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		st = new StringTokenizer(br.readLine()," ");
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=T;t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			arr = new int[10];
			
			int maxValue = 0;
			int minValue = Integer.MAX_VALUE;
			
			int sum = 0;
			
			for(int i = 0;i<10;i++) {
				int num = Integer.parseInt(st.nextToken());
				sum+=num;
				maxValue = Math.max(num, maxValue);
				minValue = Math.min(num, minValue);
			}
			
			sum -= maxValue;
			sum -= minValue;
			
			double avg = sum / 8.0;
			
			sb.append("#").append(t).append(" ").append(String.format("%.0f\n", avg));
		}//end of testCase
		System.out.println(sb);
	
	}//end of main

}
