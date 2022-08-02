package D2_1979_어디에단어가들어갈수있을까;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("./src/D2_1979_어디에단어가들어갈수있을까/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=0;t<T;t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N;
			int K;
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int [][]arr = new int[N][N];
			
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			
			//가로
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					
					if(arr[i][j] == 1) {
						
						int cnt = 1;
						j++;
						while(j<N) {
							if(arr[i][j] == 1) {
								cnt++;
								j++;
							}
							else {
								break;
							}
						}
						
						if(cnt == K) {
							answer++;
						}
						
					}
					
					
				}
			}
			
			//세로
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					
					if(arr[j][i] == 1) {
						
						int cnt = 1;
						j++;
						while(j<N) {
							if(arr[j][i] == 1) {
								cnt++;
								j++;
							}
							else {
								break;
							}
						}
						
						if(cnt == K) {
							answer++;
						}
						
					}
					
					
				}
			}
			
			sb.append("#"+(t+1)+" " + answer+"\n");
		}
		System.out.println(sb);
		
		
	}

}
