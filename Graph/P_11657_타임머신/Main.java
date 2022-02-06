package P_11657_타임머신;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Info{
	int from;
	int to;
	int cost;
	public Info(int from, int to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	
}

public class Main {
	
	static int N,M;
	static ArrayList<Info> edgeList;
	static long [] dist;
	static int INF = Integer.MAX_VALUE;
	
	
	public static void main(String [] args) throws Exception{
		System.setIn(new FileInputStream("그래프2/P_11657_타임머신/input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new long[N+1];
		edgeList = new ArrayList();
		
		for(int i = 1;i<=N;i++) {
			dist[i] = INF;
		}
		
		dist[1] = 0;
		
		for(int i = 0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int u,v,w;

			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Info(u,v,w));
			
		}
		
		boolean isCycle = false;
		
		for(int n = 0;n<N;n++) {
			
			for(int i = 0;i<edgeList.size();i++) {
				
				Info info = edgeList.get(i);
				
				int u = info.from;
				int v = info.to;
				int w = info.cost;
				
				if(dist[u] != INF && (dist[u] + w) < dist[v]) {
					if(n == N-1) isCycle = true;
					dist[v] = dist[u] + w;
				}
			}
			
		}
		
		if(isCycle == true) {
			System.out.println(-1);
		}
		else {
			for(int i = 2;i<=N;i++) {
				
				if(dist[i] == INF) {
					sb.append(-1+"\n");
				}
				else {
					sb.append(dist[i] + "\n");
				}
				
				
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
