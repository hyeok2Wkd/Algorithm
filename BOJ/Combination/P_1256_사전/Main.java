package P_1256_사전;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,K;
	static int [][]dp;
	
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("조합론/P_1256_사전/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+M+1][N+M+1];
		
		dp[0][0] = 1;
		
		combination(N+M, M);
		
		
		if(K > dp[N+M][M]) {
			System.out.println(-1);
		}
		else {
			query(N,M,new StringBuilder());
		}
		
		
	}
	
	static void query(int n,int m, StringBuilder sb) {
		//a or z를 모두 사용한 경우
		if(n == 0) {
			while(m!=0) {
				sb.append("z");
				m--;
			}
			System.out.println(sb);
			return ;
		}
		else if(m == 0) {
			while(n!=0) {
				sb.append("a");
				n--;
			}
			System.out.println(sb);
			return ;
		}
		
		
		//left, right 비교
		int leftValue = dp[n+m-1][m];
		int rightValue = dp[n+m-1][m-1];
		
		//a를 뽑음
		if(leftValue >= K) {
			sb.append("a");
			query(n-1, m, sb);
		}
		else { //z를 뽑음
			
			K -= leftValue;
			
			sb.append("z");
			query(n, m-1, sb);
		}
		
		
		
		
	}
	static int combination(int n, int r) {
		
		if(n==r || r == 0) {
			
			dp[n][r] = 1;
			
			return 1;
		}
		
		else if(dp[n][r] != 0) return dp[n][r];
		
		else {
			
			return dp[n][r] = Math.min((int)1e9, combination(n-1, r) + combination(n-1, r-1));
			
		}
		
	}
}
