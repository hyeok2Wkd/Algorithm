package P_11266_단절점;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static ArrayList<Integer> []graph;
	static int [] order;
	static int now;
	static boolean [] isCut;
	static int cutNodeCount = 0;
	
	public static void main(String[]args) throws Exception{
		System.setIn(new FileInputStream("그래프2/P_11266_단절점/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		order = new int[N+1];
		isCut = new boolean[N+1];
		
		for(int i = 1;i<=N;i++) {
			graph[i] = new ArrayList();
		}
		
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i = 1;i<=N;i++) {
			
			if(order[i] == 0) {
				DFS(i,true);
			}
			
		}
		
		StringBuilder list = new StringBuilder();
		
		for(int i = 1;i<=N;i++) {
			if(isCut[i] == true)
			{
				cutNodeCount++;
				list.append(i+" ");
			}
		}
		System.out.println(cutNodeCount);
		System.out.println(list);
		
	}
	
	static int DFS(int node, boolean isRoot) {
		
		now++;
		order[node] = now;
		
		
		int rtn = now;
		int childCnt = 0;
		
		for(int i = 0;i<graph[node].size();i++) {
			
			int next = graph[node].get(i);
			
			//미방문
			if(order[next] == 0) {
				childCnt++;
				int low = DFS(next, false);
				
				if(isRoot == false && order[node] <= low) {
					isCut[node] = true;
				}
				rtn = Math.min(rtn, low);
			}
			//이미 방문
			else {
				rtn = Math.min(rtn, order[next]);
			}
			
		}
		
		if(isRoot == true && childCnt >= 2) {
			isCut[node] = true;
		}
		
		
		return rtn;
		
	}
}
