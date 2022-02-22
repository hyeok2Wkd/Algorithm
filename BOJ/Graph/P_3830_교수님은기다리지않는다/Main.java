package P_3830_교수님은기다리지않는다;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int [] parent;
	static int [] weight;
	
	
	public static void main(String[]args) throws Exception{
		System.setIn(new FileInputStream("그래프1/P_3830_교수님은기다리지않는다/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		StringBuilder sb = new StringBuilder();
		
		while(true) {

			st = new StringTokenizer(br.readLine());
			
			
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) break;
			
			parent = new int[N+1];
			weight = new int[N+1];
			
			for(int i = 1;i<=N;i++) {
				parent[i] = i;
			}
			
			for(int i = 0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				char op;
				int a,b;
				op = st.nextToken().charAt(0);
				
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				//무게차이 알려주기
				if(op == '!') {
					int w = Integer.parseInt(st.nextToken());
					
					union(a,b,w);
					
					
					
				}
				//무게차이는 ?
				else if(op == '?') {
					
					if(find(a) == find(b)) {
						int result = weight[a] - weight[b];
						sb.append(result+"\n");
					}
					else {
						sb.append("UNKNOWN\n");
					}
					
					
				}
				
				
			}
		}
		
		System.out.println(sb);
		
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		
		int parentTemp = find(find(parent[a]));
		weight[a] += weight[parent[a]];
		parent[a] = parentTemp;
		return parent[a];
	}
	
	static void union(int a, int b,int w) {
		
		int pA = find(a);
		int pB = find(b);
		
		if(pA != pB) {
			parent[pA] = pB;
			weight[pA] = w - weight[a] + weight[b];
		}
		
		
		
	}

}
