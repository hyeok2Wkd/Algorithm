package P_11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int [] nums;
	static int [] dp;
	
	public static void main(String[]args) throws Exception{
		System.setIn(new FileInputStream("DP1/P_11659_구간합구하기4/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N+1];
		dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1;i<=N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = nums[1];
		
		//dp 초기화  [n] --> nums배열 [1]~[n]까지의 합
		for(int i =2;i<=N;i++) {
			dp[i] = dp[i-1] + nums[i];
		}
		
		for(int i = 0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			
			System.out.println(dp[b] - dp[a-1]);
			
			
			
			
		}
		
		
	}

}
