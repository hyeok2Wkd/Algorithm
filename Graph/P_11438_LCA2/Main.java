package P_11438_LCA2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static ArrayList<Integer> []graph;
	static int [] depth;
	static int [][] sparseTable;
	static int logN;
	
	
	public static void main(String[]args) throws Exception{
		System.setIn(new FileInputStream("그래프1/P_11438_LCA2/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		depth = new int[N+1];
		getLogN();
		sparseTable = new int[logN+1][N+1];
		
		for(int i = 1;i<=N;i++) {
			graph[i] = new ArrayList();
		}
		
		for(int i = 0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
			
		}
		
		getDepth();
		makeSparseTable();
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			int lca = getLCA(a, b);
			sb.append(lca+"\n");
			
		}
		
		System.out.println(sb);
		
		
		
	}
	
	static void getLogN() {
		logN = 1;
		int cnt = 1;
		while(logN < N) {
			logN *= 2;
			cnt++;
		}
		logN = cnt;
	}
	
	static void getDepth() {
		int start = 1;
		Queue<Integer> q = new LinkedList();
		depth[start] = 0;
		q.add(start);
		
		while(!q.isEmpty()) {
			
			int node = q.remove();
			
			for(int i = 0;i<graph[node].size();i++) {
				
				int next = graph[node].get(i);
				if(depth[next] == 0 && next != start) {
					depth[next] = depth[node] + 1;
					sparseTable[0][next] = node;
					q.add(next);
				}
				
				
			}
		}
		
	}
	
	static void makeSparseTable() {
		
		for(int i = 1;i<=logN;i++) {
			
			for(int j = 1;j<=N;j++) {
				
				sparseTable[i][j] = sparseTable[i-1][sparseTable[i-1][j]];
				
				
			}
			
			
		}
	}
	
	static int getLCA(int a, int b) {
		
		if(depth[a] < depth[b]) {
			return getLCA(b,a);
		}
		
		//높이맞추자
		for(int i = 0;i<=logN;i++) {
			if(((depth[a] - depth[b]) & (1 << i)) >= 1) {
				a = sparseTable[i][a];
			}
		}
		
		//LCA 여부확인
		if(a == b) {
			return a;
		}
		
		for(int i = logN;i>=0;i--) {
			
			if(sparseTable[i][a] != sparseTable[i][b]) {
				a = sparseTable[i][a];
				b = sparseTable[i][b];
			}
			
		}
		return sparseTable[0][a];
	}
	
}
