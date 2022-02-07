package P_1275_커피숍2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static long [] nums;
	static long [] tree;
	static int s;
	
	public static void main(String[]args) throws Exception{
		
		System.setIn(new FileInputStream("src/P_1275_커피숍2/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new long[N+1];
		
		s = 1;
		
		while(s<N) {
			s *= 2;
		}
		
		tree = new long[s*2];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1;i<=N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		BUinit();
		
		
		
		for(int i = 0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int x,y,a;
			long b;
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if(x > y) {
				int temp = x;
				x = y;
				y = temp;
			}
			
			a = Integer.parseInt(st.nextToken());
			b = Long.parseLong(st.nextToken());
			
			sb.append(query(1,s,1,x,y) + "\n");
			long diff = b - (long)tree[s+a-1];
			
			
			update(1,s,1,a,diff);
			
			
			
			
		}
		
		System.out.println(sb);
		
		
		
		
		
		
		
	}
	
	static void BUinit() {
		
		
		//leaf채우기
		for(int i = 1;i<=N;i++) {
			tree[i+s-1] = nums[i];
		}

		//상위노드 채우기
		for(int i = s-1;i>=1;i--) {
			tree[i] = tree[i*2] + tree[i*2+1]; 
		}
			
		
	}
	
	static void update(int left,int right, int node, int target, long diff) {
		
		if(left <= target && right >= target) {
			
			tree[node] += diff;
			
			if(left == right) return;
			
			int mid = (left + right) / 2;
			
			update(left, mid, node*2, target, diff);
			update(mid+1, right, node*2+1, target, diff);
			
		}
		else {
			return ;
		}		
		
	}
	
	static long query(int left, int right, int node, int queryLeft, int queryRight) {
		
		//값사용x
		if(left > queryRight || right < queryLeft) {
			return 0;
		}
		else if(left >= queryLeft && right <= queryRight) { //값사용o
			return tree[node];
		}
		else { //자식에게 위임
			int mid = (left + right) / 2;
			return query(left, mid, node*2, queryLeft, queryRight) + query(mid+1, right, node*2+1, queryLeft, queryRight);
		}
		
		
		
	}

}
