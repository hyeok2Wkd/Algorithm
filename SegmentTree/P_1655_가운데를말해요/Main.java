package P_1655_가운데를말해요;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class MyNum implements Comparable<MyNum>{
	int index;
	int num;
	int rank;
	public MyNum(int index, int num) {
		super();
		this.index = index;
		this.num = num;
	}
	@Override
	public int compareTo(MyNum o) {
		int comp1 = num - o.num;
		if(comp1 == 0) {
			int comp2 = index - o.index;
			return comp2;
		}
		return comp1;
	}
}

public class Main {
	
	static int N;
	static MyNum [] nums;
	static int [] tree;
	static int s;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("src/P_1655_가운데를말해요/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		nums = new MyNum[N+1];
		
		nums[0] = new MyNum(0,-10001);
		
		for(int i = 1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			nums[i] = new MyNum(i,Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(nums);
		
		int [] result = new int[N+1];
		
		for(int i = 1;i<=N;i++) {
			nums[i].rank=i;
			result[i] = nums[i].num;
		}
		
		Arrays.sort(nums, new Comparator<MyNum>() {
			@Override
			public int compare(MyNum o1, MyNum o2) {
				
				return Integer.compare(o1.index, o2.index);
			}
		});
		
		s = 1;
		while(s < N) {
			s *= 2;
		}
		tree = new int[s*2];
		
		
		for(int i = 1;i<=N;i++) {
			
			MyNum myNum = nums[i];
			
			update(1,s,1,myNum.rank);
			
			//개수가 짝수
			if(i % 2 == 0) {
				int rank = query(1,s,1,i / 2);
				sb.append(result[rank] + "\n");
			}
			//개수가 홀수
			else {
				int rank = query(1,s,1,(i / 2) +1);
				sb.append(result[rank] + "\n");
			}
		}
		
		System.out.println(sb);
		
		
		
		
		
	}
	
	static void update(int left, int right, int node, int target) {
		
		//관련o
		if(target >= left && target <= right) {
			tree[node] += 1;
			if(left != right) {
				int mid = (left+right) / 2;
				update(left, mid, node*2,target);
				update(mid+1,right, node*2+1,target);
				return;
			}
		}
		//관련x
		else {
			return;
		}
	}
	
	static int query(int left, int right, int node, int order) {
		
		if(left == right) {
			return node-s+1;
		}
		
		int mid = (left+right) / 2;
		
		//left에 존재
		if(tree[node*2] >= order) {
			return query(left, mid, node*2, order);
			
		}
		//right에 존재
		else {
			return query(mid+1,right, node*2+1, order - tree[node*2]);
		}
		
	}
	
}
