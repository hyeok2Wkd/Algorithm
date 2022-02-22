package P_11404_플로이드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static long [][] dist;
	static final long INF = Long.MAX_VALUE;
	
	
	public static void main(String [] args) throws Exception{
		System.setIn(new FileInputStream("그래프2/P_11404_플로이드/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		dist = new long[N+1][N+1];
		
		for(int i = 1;i<=N;i++) {
			for(int j = 1;j<=N;j++) {
				if(i == j) dist[i][j] = 0;
				else
					dist[i][j] = INF;
			}
		}
		
		
		
		for(int i = 0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			int u,v;
			long w;
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Long.parseLong(st.nextToken());
			
			dist[u][v] = Math.min(dist[u][v], w);
		}
		
		
		
		
		for(int k = 1;k<=N;k++) {
			for(int i = 1;i<=N;i++) {
				
				for(int j = 1;j<=N;j++) {
					if(dist[i][k] != INF && dist[k][j] != INF)
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					
				}
			}
		}
		
		for(int i =1;i<=N;i++) {
			for(int j = 1;j<=N;j++) {
				if(dist[i][j] == INF) {
					System.out.print(0 + " ");
				}
				else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		
		
		
	}
}
