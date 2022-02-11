package P_10217_KCMTravel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info>{
	int node;
	int cost; //비용
	int dist; //거리
	public Info(int node, int cost, int dist) {
		super();
		this.node = node;
		this.cost = cost;
		this.dist = dist;
	}
	@Override
	public int compareTo(Info o) {
		int comp1 = Integer.compare(dist, o.dist);
		if(comp1 == 0) {
			int comp2 = Integer.compare(cost, o.cost);
			return comp2;
		}
		return comp1;
	}
}

public class Main {
	
	static int T;
	static int N,M,K;
	static ArrayList<Info> []graph;
	static int INF = Integer.MAX_VALUE;
	static int [][] DP;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/P_10217_KCMTravel/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		
		for(int t = 0;t<T;t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N+1];
			DP = new int[N+1][M+1];
			
			for(int i = 1;i<=N;i++) {
				graph[i] = new ArrayList();
				Arrays.fill(DP[i], INF);
			}
			
			for(int k = 0;k<K;k++) {
				
				st = new StringTokenizer(br.readLine());
				
				int u,v,c,d;
				
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				
				graph[u].add(new Info(v,c,d));
				
			}
			
			//dijkstra
			PriorityQueue<Info> pq = new PriorityQueue<>();
			pq.add(new Info(1,0,0));
			DP[1][0] = 0;
			
			while(!pq.isEmpty()) {
				
				Info info = pq.remove();
				int node = info.node;
				int cost = info.cost;
				int dist = info.dist;
				
				if(DP[node][cost] > dist) continue;
				
				for(int i = 0;i<graph[node].size();i++) {
					
					int nNode = graph[node].get(i).node;
					int nCost = graph[node].get(i).cost;
					int nDist = graph[node].get(i).dist;
					
					if((cost+nCost) > M) continue;
					
					if(DP[nNode][cost+nCost] <= (dist+nDist)) {
						continue;
					}
					
					for(int j = cost+nCost;j<=M;j++) {
						if(DP[nNode][j] > (dist+nDist)) {
							DP[nNode][j] = dist+nDist;
						}
					}
					
					pq.add(new Info(nNode,cost+nCost, dist+nDist));
				}
			}
			
			
			int result = INF;
			
			for(int i = 0;i<=M;i++) {
				result = Math.min(result, DP[N][i]);
			}
			
			if(result == INF) {
				sb.append("Poor KCM\n");
			}
			else {
				sb.append(result+"\n");
			}
			
			
			
		}
		
		System.out.println(sb);
		
	}
}
