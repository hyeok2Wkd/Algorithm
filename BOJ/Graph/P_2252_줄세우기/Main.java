package P_2252_줄세우기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int [] inDegree;
	static ArrayList<Integer> []graph;
	
	
	public static void main(String[]args)throws Exception{
		System.setIn(new FileInputStream("그래프1/P_2252_줄세우기/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inDegree = new int[N+1];
		graph = new ArrayList[N+1];
		
		for(int i = 1;i<=N;i++) {
			graph[i] = new ArrayList();
		}
		
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			inDegree[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1;i<=N;i++) {
			if(inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		
		//DAG
		while(!q.isEmpty()) {
			
			int node = q.remove();
			sb.append(node + " ");
			
			for(int i = 0;i<graph[node].size();i++) {
				
				int next = graph[node].get(i);
				
				inDegree[next]--;
				if(inDegree[next] == 0) {
					q.add(next);
				}
			}
			
		}
		System.out.println(sb);
		
		
	}
}
