package P17406_배열돌리기4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] arr;
	static int[][] origin;
	static int row_start;
	static int row_end;
	static int col_start;
	static int col_end;
	static StringBuilder sb = new StringBuilder();
	static int min_sum = Integer.MAX_VALUE;
	static List<List<Integer>> list = new ArrayList();
	static List<Integer> temp = new ArrayList();
	static boolean [] visited;
	static int [][] rcsList;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		origin = new int[N][M];
		visited = new boolean[K];
		rcsList = new int[K][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end of input
		
		for(int k = 0;k<K;k++) {
			int r,s,c;
			st = new StringTokenizer(br.readLine()," ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			rcsList[k][0] = r;
			rcsList[k][1] = c;
			rcsList[k][2] = s;
		}//end of input
		
		
		// 가능한 모든 경우의 수 (r,c,s) 나열하기 
		visited = new boolean[K];
		
		for(int i = 0;i<K;i++) {
			comb(i, 1);
			visited[i] = false;
			temp.remove(temp.size()-1);
		}
		
		for(int x = 0;x<list.size();x++) {
			
			for(int row = 0 ; row<N;row++) 
				arr[row] = Arrays.copyOf(origin[row], origin[row].length);
			
			
			
			for(int y = 0;y<list.get(x).size();y++) 
				rotate(list.get(x).get(y));
			
			getMinSum();
			
		}
		
		System.out.println(min_sum);
		

	}//end of main
	
	static void getMinSum() {
		
		for(int i = 0;i<N;i++) {
			int sum = 0;
			for(int j = 0;j<M;j++) {
				sum += arr[i][j];
			}
			
			min_sum = Math.min(min_sum, sum);
		}
		
	}
	
	static void comb(int now, int cnt) {
		//1. 체크인
		visited[now] = true;
		temp.add(now);
		
		//2. 목적지니
		if(cnt == K) {
			
			list.add(new ArrayList());
			
			for(int i = 0;i<temp.size();i++) {
				list.get(list.size()-1).add(temp.get(i));
			}
			return;
		}
		//3. 순회
		for(int i = 0;i<K;i++) {
			
			//4. 갈수있니
			if(!visited[i]) {
				//5. 간다
				comb(i, cnt+1);
				//6. 체크아웃
				visited[i] = false;
				temp.remove(temp.size()-1);
			}
			
		}
		
	}
	
	static void rotate(int k) {
		
		int r = rcsList[k][0];
		int c = rcsList[k][1];
		int s = rcsList[k][2];
		
		row_start = r-s-1;
		row_end = r + s-1;
		col_start = c - s-1;
		col_end = c + s-1;
		
		while(row_start < row_end && col_start < col_end) {
			
			//1
			int temp1 = arr[row_start][col_end];
			for(int j = col_end-1;j>=col_start;j--) {
				arr[row_start][j+1] = arr[row_start][j];
			}
			
			
			//2
			int temp2 = arr[row_end][col_end];
			for(int i = row_end-1;i>row_start;i--) {
				arr[i+1][col_end] = arr[i][col_end];
			}
			
			arr[row_start+1][col_end] = temp1;
			
			
			//3
			temp1 = arr[row_end][col_start];
			for(int j = col_start+1;j<=col_end-1;j++) {
				arr[row_end][j-1] = arr[row_end][j];
			}
			
			arr[row_end][col_end-1] = temp2;
			
			
			//4
			for(int i = row_start+1;i<row_end;i++) {
				arr[i-1][col_start] = arr[i][col_start];
			}
			
			arr[row_end-1][col_start] = temp1;
			
			row_start++;
			row_end--;
			col_start++;
			col_end--;
		}
	}
	

}
