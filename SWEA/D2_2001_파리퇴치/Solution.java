package D2_2001_파리퇴치;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 0;t<T;t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N,M;
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int [][] arr = new int[N][N];
			
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			
			for(int i = 0;i<=N-M;i++) {
				
				for(int j = 0;j<=N-M;j++) {
					int sum = 0;
					
					for(int k = 0;k<M;k++) {
						for(int l = 0;l<M;l++) {
							sum += arr[i+k][j+l];
						}
					}
					
					answer = Math.max(answer, sum);
				}
			}
			
			sb.append("#" + (t+1) + " " + answer + "\n");
			
		}
		
		System.out.println(sb);
		
	}

}
