package P_11062_카드게임;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N;
	static int [] cards;
	static int [][][]DP;
	static int G = 0; //근우
	static int M = 1; //명우
	
	public static void main(String [] args) throws Exception{
		System.setIn(new FileInputStream("src/P_11062_카드게임/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t = 0 ;t<T;t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			cards = new int[N];
			DP = new int[2][N][N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0;i<N;i++) {
				
				cards[i] = Integer.parseInt(st.nextToken());
				
			}
			
			sb.append(DFS(G,0,N-1)+"\n");
			
		}
		System.out.println(sb);
	}
	
	static int DFS(int who, int left, int right) {
		
		//마지막 하나 남은 경우
		if(left == right) {
			if(who == G) {
				return cards[left];
			}
			else { //명우차례면 0 리턴
				return 0;
			}
		}
		
		//이미 계산된 결과라면
		if(DP[who][left][right] != 0) {
			return DP[who][left][right];
		}
		
		
		if(who == G) {
			return DP[who][left][right] = Math.max(cards[left] + DFS(M,left+1,right), cards[right] + DFS(M,left,right-1));
		}
		else {
			return DP[who][left][right] = Math.min(DFS(G,left+1,right), DFS(G,left,right-1));
		}
		
		
		
	}
}
