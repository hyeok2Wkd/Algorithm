package P_11062_ī�����;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N;
	static int [] cards;
	static int [][][]DP;
	static int G = 0; //�ٿ�
	static int M = 1; //���
	
	public static void main(String [] args) throws Exception{
		System.setIn(new FileInputStream("src/P_11062_ī�����/input"));
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
		
		//������ �ϳ� ���� ���
		if(left == right) {
			if(who == G) {
				return cards[left];
			}
			else { //������ʸ� 0 ����
				return 0;
			}
		}
		
		//�̹� ���� ������
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
