package P_3176_도로네트워크;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info{
	int node;
	int cost;
	public Info(int node, int cost) {
		super();
		this.node = node;
		this.cost = cost;
	}
	
}

public class Main {

	static int N,K;
	static int [][]sparseTable;
	static int [] depth;
	static int logN;
	static ArrayList<Info> []graph;
	static int [][]maxDp;
	static int [][]minDp;
	static int maxEdge;
	static int minEdge;
	
	public static void main(String[]args) throws Exception{
		
		System.setIn(new FileInputStream("src/P_3176_도로네트워크/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		
		getLogN();
		
		maxDp = new int[logN][N+1];
		minDp = new int[logN][N+1];
		sparseTable = new int[logN][N+1];
		depth = new int[N+1];
		
		for(int i = 1;i<=N;i++) {
			graph[i] = new ArrayList();
		}
		
		for(int i = 1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int u,v,w;
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			graph[u].add(new Info(v,w));
			graph[v].add(new Info(u,w));
		}
		
		getDepth(); //깊이구하기
		
		makeSparseTable(); //깊이별 부모노드 테이블
		
		st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			maxEdge = 0;
			minEdge = 1000001;
			
			getLCA(a, b);
			System.out.println(minEdge + " " + maxEdge);
			
			
		}
		
		
		
	}
	
	static void getLogN() {
		
		int n = 1;
		logN = 1;
		
		while(n < N) {
			n *= 2;
			logN++;
		}
	}
	
	static void getDepth() {
		int start = 1;
		depth[start] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			
			int node = q.remove();
			
			for(int i = 0;i<graph[node].size();i++) {
				
				int nNode = graph[node].get(i).node;
				int nCost = graph[node].get(i).cost;
				
				if(depth[nNode] == 0 && nNode != start) {
					depth[nNode] = depth[node] + 1;
					sparseTable[0][nNode] = node;
					maxDp[0][nNode] = nCost;
					minDp[0][nNode] = nCost;
					q.add(nNode);
				}
			}
			
			
		}
		
		
		
	}
	
	static void makeSparseTable() {
		
		for(int i = 1;i<logN;i++) {
			for(int j = 1;j<=N;j++) {
				sparseTable[i][j] = sparseTable[i-1][sparseTable[i-1][j]];
				maxDp[i][j] = Math.max(maxDp[i-1][j], maxDp[i-1][sparseTable[i-1][j]]);
				minDp[i][j] = Math.min(minDp[i-1][j], minDp[i-1][sparseTable[i-1][j]]);
			}
		}
		
		
		
		
	}
	
	static void getLCA(int a, int b) {
		
		//a가 깊이가 더 크다는 가정하에 구현
		if(depth[a] < depth[b]) {
			getLCA(b,a);
			return ;
		}
		
		//높이맞추기
		for(int i = 0;i<logN;i++) {
			
			if(depth[a] == depth[b]) break;
			
			if(((depth[a] - depth[b]) & (1<<i)) >= 1) {
				maxEdge = Math.max(maxEdge, maxDp[i][a]);
				minEdge = Math.min(minEdge, minDp[i][a]);
				a = sparseTable[i][a];
			}
		}
		
		
		if(a == b) {
			return ;
		}
		
		int tempA = a;
		int tempB = b;
		
		//LCA구하기
		for(int i = logN-1;i>=0;i--) {
			
			if(sparseTable[i][tempA] != sparseTable[i][tempB]) {
				tempA = sparseTable[i][tempA];
				tempB = sparseTable[i][tempB];
			}
			
		}
		
		int lca = sparseTable[0][tempA];
		
		//a와 LCA , b와 LCA까지 거리 중 최대최소 구하기
		getMaxMin(a, lca);
		getMaxMin(b, lca);
	}
	
	static void getMaxMin(int a, int b) {
		for(int i = 0;i<logN;i++) {
			if(depth[a] == depth[b]) break;
			
			if(((depth[a] - depth[b]) & (1<<i)) >= 1) {
				
				maxEdge = Math.max(maxEdge, maxDp[i][a]);
				minEdge = Math.min(minEdge, minDp[i][a]);
				a = sparseTable[i][a];
			}
		}
		
		
	}
}
