package P_2824_최대공약수;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long A;
	static long B;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("정수론/P_2824_최대공약수/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A=1;
		B=1;
		
		int n,m;
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			A *= Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<m;i++) {
			B *= Long.parseLong(st.nextToken());
		}
		
		long gcdResult = gcd(A,B);
		String str = Long.toString(gcdResult);
		
		if(str.length() > 9) {
			for(int i = str.length()-9;i<str.length();i++) {
				System.out.print(str.charAt(i));
			}
		}
		else {
			System.out.println(gcdResult);
		}
		
		
	}
	
	static long gcd(long a, long b) {
		
		while(b != 0) {
			
			long r = a % b;
			a = b;
			b = r;
			
		}
		
		return a;
		
		
		
	}
}
