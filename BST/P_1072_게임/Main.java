package P_1072_게임;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long X,Y;
	static long start,end;
	static long Z;

	public static void main(String [] args) throws Exception{
		System.setIn(new FileInputStream("src/P_1072_게임/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());
		
		Z = (long)((Y*100)/X);

		start = 1;
		end = (99 * X) - (100 * Y);
		
		if(Z >= 99) {
			System.out.println(-1);
			return ;
		}
		
		
		long result = binarySearch();
		System.out.println(result);
		
		
	}
	
	
	static long binarySearch() {
		
		while(start < end) {
			long mid = (start + end) / 2;
			
			long newZ = (long)(((Y+mid)*100) / (X+mid));
			
			if(newZ > Z) {
				end = mid;
			}
			else {
				start = mid+1;
			}
		}
		
		return end;
		
	}
	
}
