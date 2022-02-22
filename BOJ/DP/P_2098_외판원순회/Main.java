package P_2098_외판원순회;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int [][]W;
	static int [][]dp;
	static int visitedAll;
	static int INF = Integer.MAX_VALUE;
	static int result = INF;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/P_2098_외판원순회/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken());
		 visitedAll = (1<<N)-1;
		 W = new int[N+1][N+1];
		 dp = new int[N+1][visitedAll+1];
		 
		 for(int i = 1;i<=N;i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j = 1;j<=N;j++) {
				 W[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 
		 for(int i = 1;i<=N;i++) {
			 Arrays.fill(dp[i], INF);
		 }
		
		 dp[1][1] = 0;
		 DFS(1,1);
		 System.out.println(result);
		 
		
	}
	
	static void DFS(int now, int visited) {
		
		//1. 체크인
		
		//2. 목적지니?
		if(visited == visitedAll) {
			if(W[now][1] == 0) return;
			result = Math.min(result, dp[now][visited] + W[now][1]);
			return;
		}
		
		//3. 순회
		for(int i = 1;i<=N;i++) {
			int next = (1<<(i-1));
			int nextVisited = visited | next;
			
			//4. 갈수있니 ?
			if(nextVisited == visited) continue; //이미 방문한 곳임
			if(W[now][i] == 0) continue; //갈수있는 길이 없음
			
			if(dp[i][nextVisited] > dp[now][visited] + W[now][i]) {
				//체크인
				dp[i][nextVisited] = dp[now][visited] + W[now][i];
				//5. 간다
				DFS(i,nextVisited);
			}
			
			
		}
		
		
		//6. 체크아웃
	}

}
