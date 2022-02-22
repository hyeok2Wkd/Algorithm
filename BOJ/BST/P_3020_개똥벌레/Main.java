package P_3020_개똥벌레;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N,H;
	static int [] bottom;
	static int [] top;
	static int [] cuttingCount;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("src/P_3020_개똥벌레/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		bottom = new int[N/2];
		top = new int[N/2];
		cuttingCount = new int[H+1];
		
		int bIndex = 0;
		int tIndex = 0;
		
		for(int i = 0;i<N;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			//bottom
			if(i%2 == 0) {
				
				bottom[bIndex++] = Integer.parseInt(st.nextToken());
				
			}
			//top
			else {
				
				top[tIndex++] = H - Integer.parseInt(st.nextToken());
				
			}
			
		}
		
		Arrays.sort(bottom);
		Arrays.sort(top);
		
		int size = N/2;
		
		int minCut = 200001;
		
		for(int i = 1;i<=H;i++) {
			
			//최대가 자르는 위치보다 작으면 0개 잘림
			if(bottom[size-1] >= i) {
				int left = bottom_binarySearch(i);
				int right = size-1;
				cuttingCount[i] += right-left+1;
			}
			
			
			//최소가 나보다 크면 0개임
			if(top[0] < i) {
				int left = 0;
				int right = top_binarySearch(i);
				cuttingCount[i] += right-left+1;
			}
			
			minCut = Math.min(minCut, cuttingCount[i]);
		}
		
		int minCount = 0;
		
		for(int i = 1;i<=H;i++) {
			
			if(cuttingCount[i] == minCut) {
				minCount++;
			}
		}
		
		
		System.out.println(minCut + " " + minCount);
		
		
		
	}
	
	//크거나 같은 것 중에 가장 작은 것
	static int bottom_binarySearch(int target) {
		
		int start = 0;
		int end = N/2-1;
		
		int rtn = -1;
		
		while(start<=end) {
			
			int mid = (start + end) / 2;
			
			if(bottom[mid] > target) {
				rtn = mid;
				end = mid - 1;
			}
			else if(bottom[mid] < target){
				start = mid+1;
			}
			else {
				rtn = mid;
				end = mid-1;
			}
		}
		
		
		return rtn;
		
	}
	
	static int top_binarySearch(int target) {
		
		int start = 0;
		int end = N/2-1;
		
		int rtn = -1;
		
		while(start <= end) {
			
			int mid = (start+end) / 2;
			
			if(top[mid] > target) {
				end = mid-1;
			}
			else if(top[mid] < target) {
				rtn = mid;
				start = mid + 1;
			}
			else {
				end = mid-1;
			}
			
		}
		
		return rtn;
		
	}
}
