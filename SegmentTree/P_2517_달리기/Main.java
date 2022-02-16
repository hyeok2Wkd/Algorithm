package P_2517_달리기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class MyNum implements Comparable<MyNum>{
	int num;
	int index;
	MyNum(int index, int num){
		this.index = index;
		this.num = num;
	}
	@Override
	public int compareTo(MyNum o) {
		return Integer.compare((int)num, (int)o.num);
	}
}

public class Main {
	
	static int N;
	static MyNum [] nums;
	static int [] tree;
	static int s;
	static int [] result;
	
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("src/P_2517_달리기/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		nums = new MyNum[N+1];
		nums[0] = new MyNum(0,0);
		result = new int[N+1];
		
		for(int i = 1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			nums[i] = new MyNum(i, Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(nums);
		
		
		s = 1;
		while(s < N) {
			s *=2;
		}
		tree = new int[s*2];

		
		
		for(int i = 1;i<=N;i++) {

			int queryLeft = 1;
			int queryRight = nums[i].index-1;
			
			if(queryLeft > queryRight) {
				result[nums[i].index] = nums[i].index;
				update(1,s,1,nums[i].index,1);
				continue;
			}
			
			int queryResult = query(1,s,1,queryLeft, queryRight);
			result[nums[i].index] = nums[i].index - queryResult;
			
			update(1,s,1,nums[i].index, 1);
		}
		
		for(int i = 1;i<=N;i++) {
			sb.append(result[i] + "\n");
		}
		System.out.println(sb);
		
	}
	
	static void update(int left, int right, int node, int target, int diff) {
		
		//target포함
		if(target >= left && target <= right) {
			tree[node] += diff;
			if(left != right) {
				int mid = (left + right) / 2;
				update(left,mid,node*2, target, diff);
				update(mid+1,right, node*2+1, target, diff);
			}
		}
		//target미포함
		else {
			return;
		}
		
	}
	
	static int query(int left, int right, int node, int queryLeft,int queryRight) {
		
		//값사용x
		if(queryRight < left || queryLeft > right) {
			return 0;
		}
		//값사용
		else if(queryLeft <= left && queryRight >= right){
			return tree[node];
		}
		else {
			int mid = (left + right) / 2;
			return query(left, mid, node*2, queryLeft,queryRight) + query(mid+1,right,node*2+1, queryLeft, queryRight);
		}
	}
}
