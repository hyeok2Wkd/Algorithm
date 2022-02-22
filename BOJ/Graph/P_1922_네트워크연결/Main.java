package P_1922_네트워크연결;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Info implements Comparable<Info>{
	int from;
	int to;
	int cost;
	public Info(int from, int to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	@Override
	public int compareTo(Info o) {
		return Integer.compare(cost, o.cost);
	}
	
}

public class Main {
	
	static int N,M;
	static int []parent;
	static ArrayList<Info> list;
	static int minCost;
	public static void main(String[]args)throws Exception{
		System.setIn(new FileInputStream("그래프1/P_1922_네트워크연결/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		list = new ArrayList();
		
		for(int i = 0;i<=N;i++) {
			parent[i] = i;
		}
		
		for(int i = 0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			int a, b, cost;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			list.add(new Info(a,b,cost));
			
		}
		
		Collections.sort(list);
		
		int count = 0;
		int idx = 0;
		
		//kruskal
		while(count != (N-1)) {
			
			Info info = list.get(idx);
			
			
			if(union(info.from, info.to)) {
				minCost += info.cost;
				count++;
				idx++;
				
			}
			else {
				idx++;
			}
			
			
		}
		
		
		System.out.println(minCost);
		
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		
		int pA = find(a);
		int pB = find(b);
		
		if(pA == pB) return false;
 		
		parent[pA] = pB;
		return true;
		
	}
}
