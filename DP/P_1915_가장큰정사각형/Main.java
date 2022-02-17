package P_1915_����ū���簢��;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int [][]nums;
	static int [][] DP;
	static int result = 0;
	
	public static void main(String [] args) throws Exception{
		System.setIn(new FileInputStream("src/P_1915_����ū���簢��/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N][M];
		DP = new int[N][M];
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0;j<M;j++) {
				nums[i][j] = str.charAt(j) - '0';
				DP[i][j] = nums[i][j];
			}
		}
		
		
		//�ʱⰪ ����(������, �ǿ�����)
		for(int i = 0;i<M;i++) {
			DP[0][i] = nums[0][i];
			result = Math.max(result, DP[0][i]);
		}
		
		for(int i = 0;i<N;i++) {
			DP[i][0] = nums[i][0];
			result = Math.max(result, DP[i][0]);
		}
		
		//dp
		for(int i = 1;i<N;i++) {
			for(int j = 1;j<M;j++) {
				
				//�����ڸ��� 1�ΰ��
				if(nums[i][j] == 1) {
					DP[i][j] = Math.min(DP[i-1][j], DP[i][j-1]);
					DP[i][j] = Math.min(DP[i][j], DP[i-1][j-1]) + nums[i][j];
					result = Math.max(result, DP[i][j]);
				}
				
			}
		}
		
		
		System.out.println(result * result);
	}
	
}
