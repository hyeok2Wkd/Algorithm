package P_1717_집합의표현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int []parent;
	
	public static void main(String[]args)throws Exception{
		System.setIn(new FileInputStream("그래프1/P_1717_집합의표현/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		
		for(int i = 1;i<=N;i++) {
			parent[i] = i;
		}
		
		for(int i = 0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int op,a,b;
			op = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			//union
			if(op == 0) {
				union(a,b);
			}
			//find
			else if(op == 1) {
				if(find(a) == find(b)) {
					sb.append("YES\n");
				}
				else {
					sb.append("NO\n");
				}
			}
			
		}
		
		System.out.println(sb);
		
		
		
		
		
		
		
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		
		int pA = find(a);
		int pB = find(b);
		
		parent[pA] = pB; 
		
	}

}
