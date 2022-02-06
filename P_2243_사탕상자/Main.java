package P_2243_사탕상자;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int s;
	static int [] tree;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("자료구조/P_2243_사탕상자/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		s = 1;
		while(s<1000000)
			s*=2;
		
		tree= new int[s*2];
		
		for(int i = 0;i<N;i++) {
			
			st = new StringTokenizer(br.readLine());
			int a;
			a = Integer.parseInt(st.nextToken());
			
			
			//a==1 --> 사탕 꺼내기
			if(a==1) {
				int b;
				b= Integer.parseInt(st.nextToken());
				
				int result = query(1,s,1,b);
				update(1,s,1,result,-1);
				sb.append(result + " \n");
			}
			//a==2 --> b번째 사탕상자에 c만큼 추가하기
			else if(a==2) {
				int b,c;
				b= Integer.parseInt(st.nextToken());
				c= Integer.parseInt(st.nextToken());
				update(1,s,1,b,c);
			}
			
			
			
			
			
		}
		
		System.out.println(sb);
		
	}
	
	static void update(int left, int right, int node, int target, int diff) {
		
		//target포함
		if(left <= target && right >= target) {
			tree[node] += diff;
			if(left != right) {
				int mid = (left + right) / 2;
				update(left, mid, node*2, target, diff);
				update(mid+1,right, node*2+1,target,diff);
			}
		}
		//target포함 X
		else {
			return ;
		}
		
		
		
	}
	
	static int query(int left, int right, int node, int queryValue) {
		
		
		//리프노드
		if(left == right) {
			return node-s+1;
		}
		
		
		int mid = (left + right) / 2;
		
		//leftChild에 존재
		if(tree[node*2] >= queryValue) {
			return query(left, mid, node*2,queryValue);
		}
		//rightChild에 존재
		else {
			return query(mid+1, right, node*2+1,queryValue-tree[node*2]);
		}
	}
}
