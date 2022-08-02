package D2_1961_숫자배열회전;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 0;t<T;t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int [][] arr = new int[N][N];
			
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int [][] rotate90 = new int[N][N];
			int [][] rotate180 = new int[N][N];
			int [][] rotate270 = new int[N][N];
			
			//90 rotate
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					rotate90[i][j] = arr[arr.length-1-j][i];
				}
			}
			
			//180 rotate
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					rotate180[arr.length-1-i][arr.length-1-j] = arr[i][j];
				}
			}
			
			//270 rotate
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					 rotate270[arr.length-1-j][i] = arr[i][j];
				}
			}
			
			sb.append("#"+(t+1) + "\n");
			
			for(int i=0;i<N;i++) {
				
				for(int j = 0;j<N;j++) {
					sb.append(rotate90[i][j]);
				}
				sb.append(" ");
				
				for(int j = 0;j<N;j++) {
					sb.append(rotate180[i][j]);
				}
				sb.append(" ");
				
				for(int j = 0;j<N;j++) {
					sb.append(rotate270[i][j]);
				}
				sb.append("\n");
				
			}
			
			
		}
		
	
		System.out.println(sb);
	}

}
