package P_7453_합이0인네정수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int [][]arr;
	static int []sum1;
	static int []sum2;
	static long result = 0;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("src/P_7453_합이0인네정수/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[4][N];
		sum1 = new int[N*N];
		sum2 = new int[N*N];
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
			arr[2][i] = Integer.parseInt(st.nextToken());
			arr[3][i] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0;
		
		//0,1 배열 합 / 2,3 배열 합 구하기
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				sum1[index] = arr[0][i] + arr[1][j];
				sum2[index] = arr[2][i] + arr[3][j];
				index++;
			}
		}
		
		Arrays.sort(sum1);
		Arrays.sort(sum2);
		
		int left = 0;
		int right = N*N-1;
		
		//이분탐색
		for(int i = 0;i<N*N;i++) {
			
			int target = -sum1[i];
			
			int lower = lowerBound(0, N*N, target);
			int upper = upperBound(0, N*N, target);
			result += (upper - lower);
		}
		
		System.out.println(result);
		
	}
	
	static int lowerBound(int start, int end, int target) {
		
		while(start < end) {
			int mid = (start+end) / 2;
			
			if(sum2[mid] < target) {
				start = mid+1;
			}
			else {
				end = mid;
			}
			
		}
		
		return end;
		
	}
	
	static  int upperBound(int start, int end, int target) {
		
		while(start < end) {
			
			int mid = (start+end) / 2;
			
			if(sum2[mid] <= target) {
				start = mid+1;
			}
			else {
				end = mid;
			}
		}
		
		return end;
	}
}
