package P_7579_¾Û;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int N,M;
	static int [] size;
	static int [] cost;
	static int [][] dp;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/P_7579_¾Û/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		size = new int[N+1];
		cost = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1;i<N+1;i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<N+1;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum += cost[i];
		}
		
		dp = new int[N+1][sum+1];
		
		for(int i = 1;i<=N;i++) {
			for(int j = 0;j<=sum;j++) {
				dp[i][j] = dp[i-1][j];
				
				if(j >= cost[i]) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-cost[i]] + size[i]);
				}
				
			}
		}
		
		for(int i = 0;i<=sum;i++) {
			if(dp[N][i] >= M) {
				System.out.println(i);
				break;
			}
		}
		
		
		
	}
}
