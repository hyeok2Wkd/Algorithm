package P_9345_디지털비디오디스크;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T;
	static int N, K;
	static int[] tree;
	static int [] minTree;
	static int [] maxTree;
	static int MIN_VALUE = -1;
	static int MAX_VALUE = 100001;
	static int s;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/P_9345_디지털비디오디스크/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			// 인덱스트리 make
			s = 1;
			while (s < N) {
				s *= 2;
			}
			minTree = new int[s * 2];
			maxTree = new int[s*2];

			// init
			BUInit();

			for (int k = 0; k < K; k++) {

				st = new StringTokenizer(br.readLine());
				int Q, A, B;
				Q = Integer.parseInt(st.nextToken());
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());

				// Q == 0 --> update
				if (Q == 0) {
					int targetA = A+1;
					int targetB = B+1;
					
					int temp = minTree[s+targetA -1];
					minTree[s+targetA -1] = minTree[s+targetB-1];
					minTree[s+targetB-1] = temp;
					
					temp = maxTree[s+targetA -1];
					maxTree[s+targetA -1] = maxTree[s+targetB-1];
					maxTree[s+targetB-1] = temp;
			
					update(s+targetA-1);
					update(s+targetB-1);
					
				}
				// Q == 1 --> query
				else if (Q == 1) {
					
					int minValue = minQuery(1,s,1,A+1,B+1);
					if(minValue != A) {
						sb.append("NO\n");
						continue;
					}
					int maxValue = maxQuery(1,s,1,A+1,B+1);
					if(maxValue != B) {
						sb.append("NO\n");
						continue;
					}
					sb.append("YES\n");
				}

			}
		}

		System.out.println(sb);

	}

	static void BUInit() {

		// leaf채우기
		for (int i = 0; i < s; i++) {
			if(i < N) {
				minTree[s + i] = i;
				maxTree[s+i] = i;
			}
			else {
				minTree[s+i] = MAX_VALUE;
				maxTree[s+i] = MIN_VALUE;
			}
		}

		// parent 채우기
		for (int i = s - 1; i >= 1; i--) {
			minTree[i] = Math.min(minTree[i*2], minTree[i*2+1]);
			maxTree[i] = Math.max(maxTree[i*2], maxTree[i*2+1]);
		}

	}

	static int minQuery(int left, int right, int node, int queryLeft, int queryRight) {

		// 값 사용x
		if (queryRight < left || queryLeft > right)
			return MAX_VALUE;
		// 값 사용o
		else if (queryLeft <= left && queryRight >= right) {
			return minTree[node];
		}
		// 자식에게 위임
		else {
			int mid = (left + right) / 2;
			return Math.min(minQuery(left, mid, node * 2, queryLeft, queryRight)
					,minQuery(mid + 1, right, node * 2 + 1, queryLeft, queryRight));
		}
	}
	
	static int maxQuery(int left, int right, int node, int queryLeft, int queryRight) {

		// 값 사용x
		if (queryRight < left || queryLeft > right)
			return MIN_VALUE;
		// 값 사용o
		else if (queryLeft <= left && queryRight >= right) {
			return maxTree[node];
		}
		// 자식에게 위임
		else {
			int mid = (left + right) / 2;
			return Math.max(maxQuery(left, mid, node * 2, queryLeft, queryRight)
					,maxQuery(mid + 1, right, node * 2 + 1, queryLeft, queryRight));
		}
	}

	static void update(int node) {
		
		node = node / 2;
		
		while(node > 0) {
			
			maxTree[node] = Math.max(maxTree[node*2], maxTree[node*2+1]);
			minTree[node] = Math.min(minTree[node*2], minTree[node*2+1]);
			
			node /= 2;
			
		}
		
		
	}

}
