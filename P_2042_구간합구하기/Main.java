package P_2042_구간합구하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,K;
	static long []nums;
	static int s;
	static long [] tree;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("자료구조/P_2042_구간합구하기/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new long[N+1];
		
		for(int i = 1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			nums[i] = Long.parseLong(st.nextToken());
		}
		
		s = 1;
		while(s < N)
			s*=2;
		
		tree = new long[s*2];
		
		initBU();
		
		for(int i = 0;i<M+K;i++) {
			
			st = new StringTokenizer(br.readLine());
			int a;
			a = Integer.parseInt(st.nextToken());
			int b;
			long c;
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			
			//update
			if(a== 1) {
				long diff = c - tree[s+b-1];
				update(1,s,1,b,diff);
			}
			//query
			else if(a==2) {
				long result = query(1,s,1,b,(int)c);
				System.out.println(result);
			}
			
			
		}
		
		
		
		
	}
	
	static void initBU() {
		
		//리프노드 채우기
		for(int i = 1;i<=N;i++) {
			tree[i+s-1] = nums[i];
		}
		
		//내부노드 채우기
		for(int i=s-1;i>=1;i--) {
			tree[i] = tree[i*2] + tree[i*2+1];
		}
		
	}
	
	static void update(int left, int right, int node, int target, long diff) {
		
		//target을 포함
		if(left <= target && right >= target) {
			tree[node] += diff;
			if(left == right) return;
			int mid = (left+right) / 2;
			update(left, mid, node*2, target,diff);
			update(mid+1,right,node*2+1, target,diff);
		}
		//target을 포함하지X
		else {
			return ;
		}
		
	}
	
	static long query(int left, int right, int node, int queryLeft, int queryRight) {
		
		//관련X
		if(left > queryRight || right < queryLeft) {
			return 0;
		}
		//값사용
		else if(queryLeft <= left && queryRight >= right) {
			return tree[node];
		}
		//자식위임
		else {
			int mid = (left + right) / 2;
			long leftValue = query(left,mid,node*2,queryLeft, queryRight);
			long rightValue = query(mid+1,right, node*2+1,queryLeft, queryRight);
			return leftValue + rightValue;
		}
		
		
	}

}
