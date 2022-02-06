package P_1722_순열의순서;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int op;
	static long [] dp;

	static ArrayList<Integer> list;
	static ArrayList<Integer> nums;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("조합론/P_1722_순열의순서/input2"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		op = Integer.parseInt(st.nextToken());
		
		dp = new long[N+1];
		list = new ArrayList();
		nums = new ArrayList();
		
		for(int i = 1;i<=N;i++) {
			nums.add(i);
		}
		
		factorialInit(N);

		//k번째 수열 출력
		if(op == 1) {
			
			long k = Long.parseLong(st.nextToken());
			query1(N,k);
			
			for(int i = 0;i<list.size();i++) {
				System.out.print(list.get(i) + " ");
			}
			
		}
		
		//n개의 숫자입력받고 몇번째 수열인지 출력
		else if(op == 2) {
			for(int i = 1;i<=N;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			query2(N,0,1);
		}
		
		
	}
	
	static void query1(int n, long k) {
		
		if(n == 1) {
			list.add(nums.get(0));
			return ;
		}
		
		int idx = 0;
		
		while(true) {
			
			
			
			if(dp[n-1] >= k) {
				list.add(nums.get(idx));
				
				nums.remove(idx);
				break;
			}

			else {
				k -= dp[n-1];
				idx++;
			}
			
		}
		
		query1(n-1,k);
		
	}
	
	static void query2(int n, int now, long order) {
		
		
		if(n==1) {
			
			if(list.get(0) == 1) {
				System.out.println(order);
			}
			else {
				System.out.println(order);
			}
			
			return ;
			
		}
		
		
		int idx = 0;
		
		while(true) {
			
			//list[now] == nums[idx]
			if(list.get(now) == nums.get(idx)){
				nums.remove(idx);
				break;
			}
			else { //list[now] != nums[idx]
				idx++;
				order += dp[n-1];
			}
		}
		query2(n-1, now+1, order);
	}
	
	static void factorialInit(int n) {
		dp[1] = 1;
		for(int i = 2;i<=n;i++) {
			dp[i] = dp[i-1] * i;
		}
	}
}
