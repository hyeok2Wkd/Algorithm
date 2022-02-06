package P_1854_k번째최단경로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info>{
	int node;
	int cost;
	
	public Info(int node, int cost) {
		super();
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compareTo(Info o) {
		return Integer.compare(cost, o.cost);
	}
	
}


public class Main {
	
	static int N,M,K;
	static PriorityQueue<Integer> [] dist;
	static ArrayList<Info> []graph;
	
	
	public static void main(String [] args) throws Exception{
		System.setIn(new FileInputStream("그래프2/P_1854_k번째최단경로/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dist = new PriorityQueue[N+1];
		graph = new ArrayList[N+1];
		
		for(int i = 1;i<=N;i++) {
			dist[i] = new PriorityQueue<>(Collections.reverseOrder());
			graph[i] = new ArrayList();
		}
		
		
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u,v,w;
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Info(v,w));
			
		}
		
		//다익스트라
		PriorityQueue<Info> pq = new PriorityQueue<>();
		dist[1].add(0);
		pq.add(new Info(1,0));
		
		while(!pq.isEmpty()) {
			
			
			Info info = pq.remove();
			int now = info.node;
			int cost = info.cost;
			
			
			if(dist[now].size() == K && dist[now].peek() < cost) {
				continue;
			}
			
			for(int i = 0;i<graph[now].size();i++) {
				
				int next = graph[now].get(i).node;
				int nCost = graph[now].get(i).cost;
				
				//k개가 아직 아닌 경우
				if(dist[next].size() < K) {
					dist[next].add(cost + nCost);
					pq.add(new Info(next, cost+nCost));
				}
				else {
					if(dist[next].peek() > (cost + nCost)) {
						dist[next].remove();
						dist[next].add(cost+nCost);
						pq.add(new Info(next, cost + nCost));
					}
				}
				
				
			}
		}
		
		for(int i = 1;i<=N;i++) {
			
			if(dist[i].size() < K) {
				System.out.println(-1);
			}
			else if(dist[i].size()==K){
				System.out.println(dist[i].peek());
			}
			
			
			
			
		}
		
		
		
	}
}
