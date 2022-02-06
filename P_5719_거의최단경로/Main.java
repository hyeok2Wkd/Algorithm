package P_5719_거의최단경로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info>{
	
	int node;
	int cost;
	boolean isAlive;
	public Info(int node, int cost) {
		super();
		this.node = node;
		this.cost = cost;
		this.isAlive = true;
	}
	@Override
	public int compareTo(Info o) {
		return Integer.compare(cost, o.cost);
	}
}

public class Main {
	
	static int N,M;
	static int S,D;
	static ArrayList<Info> [] graph;
	static ArrayList<Integer> []preNode;
	static int [] dist;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("그래프2/P_5719_거의최단경로/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0) break;
			
			preNode = new ArrayList[N];
			graph = new ArrayList[N];
			dist = new int[N];
			
			for(int i = 0;i<N;i++) {
				graph[i] = new ArrayList();
				preNode[i] = new ArrayList();
				dist[i] = INF;
			}
			
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			
			for(int i = 0;i<M;i++) {
				
				st = new StringTokenizer(br.readLine());
				int u,v,w;
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				
				graph[u].add(new Info(v,w));
			}
			
			firstShortRoute();
			if(dist[D] == INF) {
				sb.append(-1+"\n");
				continue;
			}
			
			removeEdge(D);
			
			//거리초기화
			for(int i = 0;i<N;i++) {
				dist[i] = INF;
			}
			
			
			finalShortRoute();
			
			if(dist[D] != INF) {
				sb.append(dist[D] + "\n");
			}
			else {
				sb.append(-1+"\n");
			}
			
			
		}
		
		System.out.println(sb);
		
		
	}
	
	static void firstShortRoute() {
		dist[S] = 0;
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(S,0));
		
		while(!pq.isEmpty()) {
			
			Info info = pq.remove();
			int node = info.node;
			int cost = info.cost;
			
			if(cost > dist[node]) continue;
			
			for(int i = 0;i<graph[node].size();i++) {
				
				int nNode = graph[node].get(i).node;
				int nCost = graph[node].get(i).cost;
				
				
				if(dist[nNode] == (cost+nCost)) {
					preNode[nNode].add(node);
				}
				else if(dist[nNode] > (cost+nCost)) {
					dist[nNode] = cost+nCost;
					preNode[nNode].clear();
					preNode[nNode].add(node);
					pq.add(new Info(nNode, cost+nCost));
				}
			}
			
		}
		
		
	}
	
	static void removeEdge(int node) {
		
		for(int i = 0;i<preNode[node].size();i++) {
			
			int pre = preNode[node].get(i);
			
			for(int j = 0;j<graph[pre].size();j++) {
				
				if(graph[pre].get(j).node == node && graph[pre].get(j).isAlive != false) {
					graph[pre].get(j).isAlive = false;
					removeEdge(pre);
				}
			}
		}
		
		
		
	}
	
	static void finalShortRoute() {
		
		
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(S,0));
		dist[S] = 0;
		
		while(!pq.isEmpty()) {
			
			Info info =pq.remove();
			int node = info.node;
			int cost = info.cost;
			
			if(cost > dist[node]) {
				continue;
			}
			
			for(int i = 0;i<graph[node].size();i++) {
				
				if(graph[node].get(i).isAlive == false) continue;
				
				int nNode = graph[node].get(i).node;
				int nCost = graph[node].get(i).cost;
				
				if(dist[nNode] > (cost+nCost)) {
					dist[nNode] = cost+nCost;
					pq.add(new Info(nNode, cost+nCost));
				}
			}
		}
		
		
	}

}
