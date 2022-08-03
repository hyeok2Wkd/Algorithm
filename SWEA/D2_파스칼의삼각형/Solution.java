package D2_파스칼의삼각형;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int T,N;
	static int [][] arr;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		st = new StringTokenizer(br.readLine()," ");
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=T;t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			
			arr = new int[N][];
			for(int i = 0;i<N;i++) {
				arr[i] = new int[i+1];
			}
			
			arr[0][0] = 1;
			
			for(int i = 1;i<N;i++) {
				
				for(int j = 0;j<arr[i].length;j++) {
					
					if(j == 0 || j == arr[i].length-1) {
						arr[i][j] = 1;
					}else {
						arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
					}
				}
			}
			
			sb.append("#").append(t).append("\n");
			
			for(int i = 0;i<N;i++) {

				for(int j = 0;j<arr[i].length;j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			
		}//end of testCase
		System.out.println(sb);
	
	}//end of main

}
